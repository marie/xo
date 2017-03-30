package xo.view;

import xo.controller.Game;
import xo.model.Field;
import xo.model.Player;
import java.util.Scanner;

public class Console {

  private Game game;

  public Console(Game game) {
    this.game = game;
  }

  public void show() {
    while (!game.isOver()) {
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

      System.out.println("Enter coordinates: ");
      Scanner in = new Scanner(System.in);
      int x = in.nextInt();
      int y = in.nextInt();

      if (!game.makeStep(x - 1, y - 1)) {
        System.out.println("Not valid coordinates.");
      }
    }
  }
}
