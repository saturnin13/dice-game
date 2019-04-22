package main;

import main.game.Game;
import main.dice.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.start();

    }
}

// TODO refactor printing
// TODO playerAction