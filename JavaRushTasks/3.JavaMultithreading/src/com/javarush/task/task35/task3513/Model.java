package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public Model() {
        resetGameTiles();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (Tile[] gameTile : gameTiles) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTile[j].isEmpty()) {
                    emptyTiles.add(gameTile[j]);
                }
            }
        }
        return emptyTiles;
    }

    private void addTile() {
        List<Tile> tiles = getEmptyTiles();
        if (!tiles.isEmpty()) {
            tiles.get((int) (tiles.size() * Math.random())).value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    protected void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }
}
