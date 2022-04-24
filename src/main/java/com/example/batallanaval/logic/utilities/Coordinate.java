package com.example.batallanaval.logic.utilities;

public class Coordinate implements Comparable<Coordinate> {

    private int row = 0;
    private int col = 0;

    public static final String H_ORDINATES = "abcdefghij";
    public static final String V_ORDINATES = "1234567890";

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getChessFormat() {
        char[] rows = V_ORDINATES.toCharArray();
        char[] cols = H_ORDINATES.toCharArray();

        return "" + rows[this.row] + cols[this.col];
    }

    public static Coordinate parseCoordinate(String value) {
        char[] rows = V_ORDINATES.toCharArray();
        char[] cols = H_ORDINATES.toCharArray();

        for (int row = 0; row < 10; row++) {
            for (int columm = 0; columm < 10; columm++) {
                if (("" + cols[columm] + rows[row]).equals(value.toLowerCase())) {
                    Coordinate coordinate = new Coordinate(row, columm);
                    coordinate.setRow(row);
                    coordinate.setCol(columm);
                    return coordinate;
                }
            }
        }

        return null;
    }

    public String toString() {
        char[] rows = "1234567890".toCharArray();
        char[] cols = "abcdefghij".toCharArray();

        return "" + cols[col] + rows[row];
    }

    @Override
    public int compareTo(Coordinate coordinate) {
        if (this.getRow() == coordinate.getRow() && this.getCol() == coordinate.getCol()) {
            return 0;
        }
        return -1;
    }
}
