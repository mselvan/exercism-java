package com.belyf;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    private static final int GIGASECONDS = 1_000_000_000;
    private LocalDateTime localDateTime;
    public Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
        this.localDateTime = moment.plusSeconds(GIGASECONDS);
    }

    public LocalDateTime getDateTime() {
        return localDateTime;
    }
}
