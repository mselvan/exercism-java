package com.belyf;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProteinTranslator {
    private final Map<String, String> NORMAL_CONDON_PROTEIN_MAP = Map.ofEntries(
            Map.entry("AUG", "Methionine"),
            Map.entry("UUU, UUC", "Phenylalanine"),
            Map.entry("UUA, UUG", "Leucine"),
            Map.entry("UCU, UCC, UCA, UCG", "Serine"),
            Map.entry("UAU, UAC", "Tyrosine"),
            Map.entry("UGU, UGC", "Cysteine"),
            Map.entry("UGG", "Tryptophan"),
            Map.entry("UAA, UAG, UGA", "STOP")
    );

    private final Map<String, String> CONDON_PROTEIN_MAP = NORMAL_CONDON_PROTEIN_MAP.entrySet()
            .stream()
            .flatMap(entry -> {
                String originalKey = entry.getKey();
                List<String> keys = Arrays.stream(originalKey.split(",")).map(s -> s.trim()).collect(Collectors.toList());
                return keys.stream().map(key -> new AbstractMap.SimpleEntry<String, String>(key, entry.getValue()));
            }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    List<String> translate(String rnaSequence) {
        List<String> rnaCondonList = Pattern.compile(".{1,3}")
                .matcher(rnaSequence)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
        AtomicBoolean proceed = new AtomicBoolean(true);
        return rnaCondonList.stream().takeWhile(value -> proceed.get()).map(condon -> {
            String protein = CONDON_PROTEIN_MAP.get(condon);
            if(protein.equals("STOP")) {
                proceed.set(false);
            }
            return protein;
        }).filter(value -> !value.equals("STOP")).collect(Collectors.toList());
    }
}
