package com.belyf;

class Greeter {
    String getGreeting() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        System.out.println(greeter.getGreeting());
    }
}

