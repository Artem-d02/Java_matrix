package Mtrx;

import org.jetbrains.annotations.NotNull;

import java.io.PrintStream;
import java.util.List;
import java.util.Objects;

public class SquareMatrix<T extends Number> {
    private Matrix<T> matrix;
    private int size;
    public SquareMatrix(final int size, final T defaultValue) {
        this.size = size;
        matrix = new Matrix<>(size, size, defaultValue);
    }
    public SquareMatrix(final @NotNull List<List<T>> inputData) throws IllegalArgumentException {
        size = inputData.size();
        if (inputData.size() != inputData.get(0).size()) {  //  if its not square
            throw new IllegalArgumentException("Fatal error: matrix is not square");
        }
        matrix = new Matrix<>(inputData);
    }
    public SquareMatrix(@NotNull SquareMatrix<T> anotherMat) {
        this(anotherMat.size, anotherMat.getDefaultValue());
        for (int yIndex = 0; yIndex < size; yIndex++) {
            setRow(yIndex, anotherMat.getRow(yIndex));
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

    public void setRow(int index, final @NotNull List<T> newRow) throws IllegalStateException {
        matrix.setRow(index, newRow);
    }

    public List<T> getRow(int index) throws IllegalStateException {
        return matrix.getRow(index);
    }

    public void print(PrintStream stream) {
        matrix.print(stream);
    }

    public int getSize() {
        return size;
    }

    public List<T> getColumn(int index) throws IndexOutOfBoundsException {
        return matrix.getColumn(index);
    }

    public void setColumn(int index, @NotNull List<T> newColumn) throws IndexOutOfBoundsException {
        matrix.setColumn(index, newColumn);
    }

    public T getDefaultValue() {
        return matrix.getDefaultValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareMatrix<?> that = (SquareMatrix<?>) o;
        return size == that.size && Objects.equals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matrix, size);
    }
}
