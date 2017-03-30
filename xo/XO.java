package xo;

import xo.model.Field;
import xo.controller.Game;
import xo.view.Console;

class XO {
    public static void main(String[] args) {
        final int FIELD_SIZE = 3;

        Field field = new Field(FIELD_SIZE);

        Game game = new Game(field);

        Console console = new Console(game);
        console.show();
    }
}
