package test;

import Mtrx.Matrix;
import Mtrx.SquareMatrix;

import java.util.ArrayList;
import java.util.Arrays;

public class Tester {
    public static boolean matrixTest() {
        //  Simple test
        Matrix<Float> myMat = new Matrix<>(3, 2);
        myMat.setRaw(0, Arrays.asList(1.0f, 2.0f, 3.0f));
        myMat.setRaw(1, Arrays.asList(3.0f, 4.0f, 5.0f));
        myMat.set(0, 1, 55.0f);
        myMat.print(System.out);

        //  Copy test
        Matrix<Float> anotherMat = myMat.clone();
        anotherMat.set(1, 1, 13.0f);
        System.out.println("myMat:");
        myMat.print(System.out);
        System.out.println("anotherMat:");
        anotherMat.print(System.out);
        if (myMat.get(1, 1) == 13.0f)
            return false;

        //  list initialization test
        Matrix<Float> listMat = new Matrix<>(
            Arrays.asList(
                    Arrays.asList(1.0f, 2.0f, 3.0f),
                    Arrays.asList(4.0f, 5.0f, 6.0f),
                    Arrays.asList(7.0f, 8.0f, 9.0f)
                    )
        );
        System.out.println("Matrix from list:");
        listMat.print(System.out);

        return true;
    }
    public static boolean squareMatrixTest() {
        //  list initialization test
        SquareMatrix<Float> listMat = new SquareMatrix<>(
                Arrays.asList(
                        Arrays.asList(1.0f, 2.0f, 3.0f),
                        Arrays.asList(4.0f, 5.0f, 6.0f),
                        Arrays.asList(7.0f, 8.0f, 9.0f)
                )
        );
        System.out.println("Square matrix:");
        listMat.print(System.out);

        return true;
    }
}
