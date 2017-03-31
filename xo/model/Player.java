package xo.model;

public class Player {
  public String figure;

  public Player(String figure) {
    this.figure = figure;
  }

  public String toString() {
    return figure;
  }

  public boolean compareTo(Player player) {
    return player.figure.equals(figure);
  }
}
