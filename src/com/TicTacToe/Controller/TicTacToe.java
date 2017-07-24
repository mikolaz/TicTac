package com.TicTacToe.Controller;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Admin on 24.07.2017.
 */
public class TicTacToe {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Board b = new Board();
        Scanner scanner = new Scanner(System.in);
        b.dispayBoard();
        System.out.println("Select turn: \n. Computer (X) / 2. User (0) : ");
        int choice = scanner.nextInt();

        if (choice == Board.PLAYER_X) {
            Point p = new Point(RANDOM.nextInt(3), RANDOM.nextInt(3));
            b.placeAMove(p, Board.PLAYER_X);
            b.dispayBoard();

        }

        while (!b.isGameOver()) {
            boolean moveOk = true;
            do {
                if (!moveOk) {
                    System.out.println("Cell already filled !");
                }
                System.out.println("Your move: ");
                Point userMove = new Point(scanner.nextInt(), scanner.nextInt());
                moveOk = b.placeAMove(userMove,Board.PLAYER_0);


            } while (!moveOk);

            b.dispayBoard();

            if (b.isGameOver())
                break;

            b.minimax(0, Board.PLAYER_X);
            System.out.println("Computer choose position :" + b.computerMove);

            b.placeAMove(b.computerMove, Board.PLAYER_X);
            b.dispayBoard();
        }

        if (b.hasPlayerWon(Board.PLAYER_X))
            System.out.println("You lose!");
        else if (b.hasPlayerWon(Board.PLAYER_0))
            System.out.print("You win!");
        else System.out.print("Draw!");
    }
}