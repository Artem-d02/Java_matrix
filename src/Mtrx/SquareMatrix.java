package Mtrx;

import org.jetbrains.annotations.NotNull;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SquareMatrix<T extends Number> {
    private Matrix<T> matrix;
    private int size;
    public SquareMatrix(final int size) {
        this.size = size;
        matrix = new Matrix<>(size, size);
    }
    public SquareMatrix(final @NotNull List<List<T>> inputData) throws IllegalArgumentException {
        size = inputData.size();
        if (inputData.size() != inputData.get(0).size()) {  //  if its not square
            throw new IllegalArgumentException("Fatal error: matrix is not square");
        }
        matrix = new Matrix<>(inputData);
    }
    public SquareMatrix(@NotNull SquareMatrix<T> anotherMat) {
        this(anotherMat.size);
        for (int yIndex = 0; yIndex < size; yIndex++) {
            setRaw(yIndex, anotherMat.getRaw(yIndex));
        }
    }
    @Override
    public SquareMatrix<T> clone() {
        return new SquareMatrix<>(this);
    }

    public T get(int x, int y) throws IndexOutOfBoundsException {
        return matrix.get(x, y);
    }

    public void set(int x, int y, T value) throws IndexOutOfBoundsException {
        matrix.set(x, y, value);
    }

    public void setRaw(int index, final @NotNull List<T> newRaw) throws IllegalStateException {
        matrix.setRaw(index, newRaw);
    }

    public List<T> getRaw(int index) throws IllegalStateException {
        return matrix.getRaw(index);
    }

    public void print(PrintStream stream) {
        matrix.print(stream);
    }

    public int getSize() {
        return size;
    }
}
