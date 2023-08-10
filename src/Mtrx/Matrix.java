package Mtrx;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Matrix<T extends Number> {
    private ArrayList<ArrayList<T>> matrix;
    private int sizeX;
    private int sizeY;
    private T defaultValue;
    public Matrix(final int sizeX, final int sizeY, final T defaultValue) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.defaultValue = defaultValue;
        matrix = new ArrayList<>(sizeY);
        for (int rawIndex = 0; rawIndex < sizeY; rawIndex++) {
            ArrayList<T> raw = new ArrayList<>(sizeX);
            for (int colIndex = 0; colIndex < sizeX; colIndex++) {
                raw.add(defaultValue);
            }
            matrix.add(rawIndex, raw);
        }
    }
    public Matrix(final @NotNull List<List<T>> inputData) throws IllegalArgumentException {
        this(inputData.size(), inputData.get(0).size(), inputData.get(0).get(0));    //  sized by first raw, defaultValue by first elem
        int rawIndex = 0;
        for (List<T> raw : inputData) {
            if (raw.size() != sizeX)
                throw new IllegalArgumentException("Fatal error: the sizes of raws in Matrix constructor are not equal");
            setRaw(rawIndex++, raw);
        }
    }
    public Matrix(@NotNull Matrix<T> anotherMat) {
        this(anotherMat.sizeX, anotherMat.sizeY, anotherMat.defaultValue);
        for (int yIndex = 0; yIndex < sizeY; yIndex++) {
            ArrayList<T> raw = new ArrayList<>(anotherMat.getRaw(yIndex));
            matrix.set(yIndex, raw);
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
    public List<T> getRaw(final int index) throws IndexOutOfBoundsException {
        if (index >= sizeY)
            throw new IndexOutOfBoundsException("Fatal error: illegal index of raw");
        return matrix.get(index);
    }
    public void setRaw(final int index, final @NotNull List<T> newRaw) throws IndexOutOfBoundsException {
        if (newRaw.size() != sizeX)
            throw new IndexOutOfBoundsException("Fatal error: illegal size of raw");
        matrix.set(index, new ArrayList<>(newRaw));
    }
    public List<T> getColumn(final int index) throws IndexOutOfBoundsException {
        if (index >= sizeX)
            throw new IndexOutOfBoundsException("Fatal error: illegal index of column");
        ArrayList<T> column = new ArrayList<>(sizeY);
        for (int yIndex = 0; yIndex < sizeY; yIndex++) {
            column.add(yIndex, get(index, yIndex));
        }
        return column;
    }
    public void setColumn(final int index, final @NotNull List<T> newColumn) throws IndexOutOfBoundsException {
        if (index >= sizeX)
            throw new IndexOutOfBoundsException("Fatal error: illegal index of column");
        for (int yIndex = 0; yIndex < sizeY; yIndex++) {
            set(index, yIndex, newColumn.get(yIndex));
        }
    }
    public void print(java.io.PrintStream stream) {
        for (ArrayList<T> raw : matrix) {
            stream.println(raw);
        }
    }
    public T getDefaultValue() {
        return defaultValue;
    }
}
