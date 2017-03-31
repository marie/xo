package xo.view;

import xo.controller.Game;
import xo.model.Field;
import xo.model.Player;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Console {

  private Game game;

  public Console(Game game) {
    this.game = game;
  }

  public void show() {
    while (!game.isOver()) {
      // System.out.println("\u001b[2J"); // очистка экрана
      showField();
      getUserInput();
    }
    showField();

    System.out.println(game.getWinner() + " wins!");
  }

  public void showField() {
    Field field = game.getField();

    for (int y = 0; y < field.getSize(); y++) {
      for (int x = 0; x < field.getSize(); x++) {
        if (x != 0) {
          System.out.print("|");
        }
        Player figure = field.getFigure(x, y);
        if(figure != null) {
          System.out.print(" " + figure + " ");
        } else {
          System.out.print("   ");
        }
      }
      if (y != field.getSize() - 1) {
        System.out.println("");
        System.out.println("------------");
      }
    }

    System.out.println("");
  }

  private void getUserInput() {
    System.out.println("Enter coordinates: ");
    Scanner in = new Scanner(System.in);

    try {
      int x = in.nextInt();
      int y = in.nextInt();

      if (!game.makeStep(x - 1, y - 1)) {
        System.out.println("Not valid coordinates.");
      }
    } catch (InputMismatchException e) {
      System.out.println("Not valid coordinates.");
    }
  }
}
