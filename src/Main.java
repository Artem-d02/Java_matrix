import Mtrx.Matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //  Simple test
        Matrix<Float> myMat = new Matrix<>(3, 2);
        myMat.setRaw(0, new ArrayList<>(Arrays.asList(1.0f, 2.0f, 3.0f)));
        myMat.setRaw(1, new ArrayList<>(Arrays.asList(3.0f, 4.0f, 5.0f)));
        myMat.set(0, 1, 55.0f);
        myMat.print(System.out);

        //  Copy test
        Matrix<Float> anotherMat = myMat.clone();
        anotherMat.set(1, 1, 13.0f);
        System.out.println("myMat:");
        myMat.print(System.out);
        System.out.println("anotherMat:");
        anotherMat.print(System.out);

    }
}