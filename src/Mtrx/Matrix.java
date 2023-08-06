package Mtrx;

import java.util.ArrayList;

public class Matrix<T extends Number> {
    private ArrayList<ArrayList<T>> matrix;
    private int sizeX;
    private int sizeY;
    public Matrix(final int sizeX, final int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        matrix = new ArrayList<>(sizeY);
        for (int rawIndex = 0; rawIndex < sizeY; rawIndex++) {
            matrix.add(rawIndex, new ArrayList<>(sizeX));
        }
    }
    public Matrix(Matrix<T> anotherMat) {
        this(anotherMat.sizeX, anotherMat.sizeY);
        for (int yIndex = 0; yIndex < sizeY; yIndex++) {
            matrix.set(yIndex, (ArrayList<T>) anotherMat.getRaw(yIndex).clone());
        }
    }
    @Override
    public Matrix<T> clone() {
        Matrix<T> result = new Matrix<>(this);
        return result;
    }
    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public T get(final int x, final int y) throws IndexOutOfBoundsException {
        return matrix.get(y).get(x);
    }
    public void set(final int x, final int y, final T value) throws IndexOutOfBoundsException {
        matrix.get(y).set(x, value);
    }
    public void setRaw(final int index, final ArrayList<T> newRaw) throws IllegalStateException {
        if (newRaw.size() != sizeX)
            throw new IllegalArgumentException("Fatal error: illegal size of raw");
        matrix.set(index, newRaw);
    }
    public ArrayList<T> getRaw(final int index) throws IllegalStateException {
        if (index >= sizeY)
            throw new IllegalArgumentException("Fatal error: illegal size of raw");
        return matrix.get(index);
    }
    public void print(java.io.PrintStream stream) {
        for (ArrayList<T> raw : matrix) {
            stream.println(raw);
        }
    }
}
