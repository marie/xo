package xo.controller;

import xo.model.Field;
import xo.model.Player;

public class Game {

  private Field field;

  private Player playerX;

  private Player playerO;

  private Player lastPlayer;

  private Player winner;

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
    // проверяем строки
    for (int y = 0; y < field.getSize(); y++) {
        if (checkX(0, y)) {
          return true;
        }
    }
    // проверяем столбцы
    for (int x = 0; x < field.getSize(); x++) {
        if (checkY(x, 0)) {
          return true;
        }
    }
    // проверяем диагонали
    if (field.getFigure(0, 0) != null &&
    field.getFigure(1, 1) != null &&
    field.getFigure(2, 2) != null) {
      if (field.getFigure(0, 0).equals(field.getFigure(1, 1)) &&
      field.getFigure(1, 1).equals(field.getFigure(2, 2))) {
        return true;
      }
    }

    if (field.getFigure(2, 0) != null &&
    field.getFigure(1, 1) != null &&
    field.getFigure(0, 2) != null) {
      if (field.getFigure(2, 0).equals(field.getFigure(1, 1)) &&
      field.getFigure(1, 1).equals(field.getFigure(0, 2))) {
        return true;
      }
    }

    winner = lastPlayer;
    return false;
  }

  private boolean checkX(int x, int y) {
    if (x >= field.getSize() - 1) {
      return true;
    }

    Player f1 = field.getFigure(x, y);
    Player f2 = field.getFigure(++x, y);

    if (f1 == null || f2 == null) {
      return false;
    }

    if (f1.figure.equals(f2.figure)) {
        return checkX(x, y);
    } else {
      return false;
    }
  }

  private boolean checkY(int x, int y) {
    if (y >= field.getSize() - 1) {
      return true;
    }

    Player f1 = field.getFigure(x, y);
    Player f2 = field.getFigure(x, ++y);

    if (f1 == null || f2 == null) {
      return false;
    }

    if (f1.figure.equals(f2.figure)) {
        return checkY(x, y);
    } else {
      return false;
    }
  }

  public Player getWinner() {
    return winner;
  }
}
