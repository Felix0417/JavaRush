package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score;
    protected int maxTile;

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
        score = 0;
        maxTile = 0;
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = true;
        boolean arrayBeChanged = false;
        while (isChanged) {
            isChanged = false;
            for (int i = tiles.length - 1; i > 0; i--) {
                if (tiles[i].isEmpty()) continue;
                if (tiles[i - 1].isEmpty()) {
                    Tile swap = tiles[i - 1];
                    tiles[i - 1] = tiles[i];
                    tiles[i] = swap;
                    isChanged = true;
                    arrayBeChanged = true;
                    break;
                }
            }
        }
        return arrayBeChanged;

    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean changedMerge = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && tiles[i].value != 0) {
                tiles[i].value *= 2;
                tiles[i + 1].value = 0;
                score += tiles[i].value;
                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }
                changedMerge = true;
            }
        }
        compressTiles(tiles);
        return changedMerge;
    }

    protected void left() {
        boolean flag = false;
        for (Tile[] gameTile : gameTiles) {
            if (mergeTiles(gameTile) | compressTiles(gameTile)) {
                flag = true;
            }
        }
        if (flag && getEmptyTiles().size() > 0) {
            addTile();
        }
    }
}
