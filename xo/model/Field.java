package xo.model;

public class Field {
  private Player[][] field;

  public Field(int size) {
    field = new Player[size][size];
  }

  public int getSize() {
    return field.length;
  }

  public void setFigure(Player player, int x, int y) {
    field[x][y] = player;
  }

  public Player getFigure(int x, int y) {
    return field[x][y];
  }

  public boolean hasFigure(int x, int y) {
    return field[x][y] != null;
  }
}
