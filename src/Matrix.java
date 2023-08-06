import java.util.ArrayList;

public class Matrix<T extends Number> {
    private ArrayList<ArrayList<T>> matrix;
    private int sizeX;
    private int sizeY;
    Matrix(final int sizeX, final int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        matrix = new ArrayList<>(sizeY);
        for (int rawIndex = 0; rawIndex < sizeY; rawIndex++) {
            matrix.add(rawIndex, new ArrayList<>(sizeX));
        }
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
    public void print(java.io.PrintStream stream) {
        for (ArrayList<T> raw : matrix) {
            stream.println(raw);
        }
    }
}
