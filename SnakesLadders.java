package Dificultad5kyu;

import java.util.HashMap;

public class SnakesLadders {

    public SnakesLadders() {
    }

    int turn = 1;
    int square1 = 0;
    int square2 = 0;
    boolean won = false;

    HashMap<Integer, Integer> upordown = new HashMap<Integer, Integer>();

    public String play(int die1, int die2) {
        if (won) {
            return "Game over!";
        } else {
            int total = die1 + die2;
            if (turn == 1) {
                square1 += total;
                if (checkmove(square1, square2) != -1) {
                    square1 = checkmove(square1, square2);
                }
                if (square1 == 100) {
                    won = true;
                    return "Player 1 Wins!";
                }
                if (square1 > 100) {
                    int bounce = square1 - 100;
                    square1 = 100 - bounce;
                    if (checkmove(square1, square2) != -1) {
                        square1 = checkmove(square1, square2);
                    }
                }
                if (die1 != die2) {
                    turn = 2;
                }
                return "Player 1 is on square " + square1;
            } else {
                square2 += total;
                if (checkmove(square1, square2) != -1) {
                    square2 = checkmove(square1, square2);
                }
                if (square2 == 100) {
                    won = true;
                    return "Player 2 Wins!";
                }
                if (square2 > 100) {
                    int bounce = square2 - 100;
                    square2 = 100 - bounce;
                    if (checkmove(square1, square2) != -1) {
                        square2 = checkmove(square1, square2);
                    }
                }
                if (die1 != die2) {
                    turn = 1;
                }
                return "Player 2 is on square " + square2;
            }
        }
    }

    public int checkmove(int square1, int square2) {
        upordown.put(2, 38);
        upordown.put(7, 14);
        upordown.put(8, 31);
        upordown.put(15, 26);
        upordown.put(16, 6);
        upordown.put(21, 42);
        upordown.put(28, 84);
        upordown.put(36, 44);
        upordown.put(46, 25);
        upordown.put(49, 11);
        upordown.put(51, 67);
        upordown.put(62, 19);
        upordown.put(64, 60);
        upordown.put(71, 91);
        upordown.put(74, 53);
        upordown.put(78, 98);
        upordown.put(87, 94);
        upordown.put(89, 68);
        upordown.put(92, 88);
        upordown.put(95, 75);
        upordown.put(99, 80);

        for (int i : upordown.keySet()) {
            if (turn == 1) {
                if (square1 == i) {
                    return upordown.get(i);
                }
            } else {
                if (square2 == i) {
                    return upordown.get(i);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SnakesLadders game = new SnakesLadders();
        game.play(1, 1);
    }
}
