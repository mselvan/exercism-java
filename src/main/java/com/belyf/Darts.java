package com.belyf;

class Darts {
    int score = 0;

    Darts(double x, double y) {
        double squareX = x * x;
        double squareY = y * y;
        double radius = Math.sqrt(squareX + squareY);
        if (radius <= 1) {
            score = 10;
        } else if (radius <= 5) {
            score = 5;
        } else if (radius <= 10) {
            score = 1;
        }
    }

    int score() {
        return score;
    }
}