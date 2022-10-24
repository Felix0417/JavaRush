package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Model {
    private static final int FIELD_WIDTH = 4;
    public Tile[][] gameTiles;
    protected int score;
    protected int maxTile;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

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

    public Model(Tile[][] gameTiles) {
        this.gameTiles = gameTiles;
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

    public boolean canMove() {
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (getEmptyTiles().size() > 0
                        || gameTiles[i][j].value == gameTiles[i][j + 1].value
                        || gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
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
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean flag = false;
        for (Tile[] gameTile : gameTiles) {
            if (mergeTiles(gameTile) | compressTiles(gameTile)) {
                flag = true;
                isSaveNeeded = true;
            }
        }
        if (flag && getEmptyTiles().size() > 0) {
            addTile();
        }
    }

    protected void right() {
        saveState(gameTiles);
        rotateRightAn90Angle(2);
        left();
        rotateRightAn90Angle(2);
    }

    protected void up() {
        saveState(gameTiles);
        rotateRightAn90Angle(3);
        left();
        rotateRightAn90Angle(1);
    }

    protected void down() {
        saveState(gameTiles);
        rotateRightAn90Angle(1);
        left();
        rotateRightAn90Angle(3);
    }

    private void rotateRightAn90Angle(int rotateRange) {
        Tile[][] rotatedTile = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                rotatedTile[j][FIELD_WIDTH - 1 - i] = gameTiles[i][j];
            }
        }

        gameTiles = Arrays.copyOf(rotatedTile, rotatedTile.length);
        if (rotateRange != 1) {
            rotateRightAn90Angle(--rotateRange);
        }
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTiles[i][j] = new Tile(gameTiles[i][j].value);
            }
        }
        previousStates.push(tempTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            this.gameTiles = previousStates.pop();
            this.score = previousScores.pop();
        }
    }

    public void randomMove() {
        switch (((int) (Math.random() * 100)) % 4) {
            case 0:
                right();
                break;
            case 1:
                left();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    private boolean hasBoardChanged() {
        int gameTilesMatch = 0;
        int previousStatesMatch = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTilesMatch += gameTiles[i][j].value;
                previousStatesMatch += previousStates.peek()[i][j].value;
            }
        }
        return gameTilesMatch != previousStatesMatch;
    }

    private MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        if (!hasBoardChanged()) {
            return new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }
}
