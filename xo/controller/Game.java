package xo.controller;

import xo.model.Field;
import xo.model.Player;

public class Game {

  private Field field;

  private Player playerX;

  private Player playerO;

  private Player lastPlayer;

  public Game(Field field) {
    this.field = field;

    playerX = new Player("X");
    playerO = new Player("O");
  }

  public Field getField() {
    return field;
  }

  public boolean makeStep(int x, int y) {
    if (lastPlayer == null) {
      lastPlayer = playerX;
    }

    if (!setCoordinates(lastPlayer, x, y)) {
      return false;
    }

    if (lastPlayer == playerX) {
      lastPlayer = playerO;
    } else if (lastPlayer == playerO) {
      lastPlayer = playerX;
    }

    return true;
  }

  private boolean setCoordinates(Player player, int x, int y) {
    // проверка на корректность координат
    if (x < 0 || x >= field.getSize() || y < 0 || y >= field.getSize()) {
      return false;
    }

    if (field.hasFigure(y, x)) {
      return false;
    }

    field.setFigure(player, y, x);

    return true;
  }

  public boolean isOver() {
    return false;
  }
}
