package com.lukaklacar.convgen;

import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.CommonOps;
import org.ejml.simple.SimpleMatrix;

public class SoftmaxLayer implements Layer {
    public SimpleMatrix process(SimpleMatrix w) {

        SimpleMatrix maxes = new SimpleMatrix(w.numCols(), w.numRows());

        for (int i = 0; i < w.numCols(); i++) {
            SimpleMatrix vector = w.extractVector(true, i);
            for (int j = 0; j < w.numRows(); j++) {
                maxes.set(i, j, vector.elementMaxAbs());
            }
        }

        DenseMatrix64F res = new DenseMatrix64F(w.numCols(), w.numRows());
        CommonOps.sub(w.getMatrix(), maxes.getMatrix(), res);
        SimpleMatrix e = new SimpleMatrix(res);
        for (int i = 0; i < e.getNumElements(); i++) {
            e.set(i, Math.exp(e.get(i)));
        }


        SimpleMatrix sumMatrix = new SimpleMatrix(w.numCols(), w.numRows());
        for (int i = 0; i < e.numCols(); i++) {
            SimpleMatrix vector = e.extractVector(true, i);
            double sum = vector.elementSum();
            for (int j = 0; j < w.numRows(); j++) {
                sumMatrix.set(i, j, sum);
            }
        }
        SimpleMatrix dist = new SimpleMatrix(w.numCols(), w.numRows());

        for (int i = 0; i < e.numCols(); i++) {
            for (int j = 0; j < e.numRows(); j++) {
                dist.set(i, j, e.get(i, j) / sumMatrix.get(i, 0));
            }
        }

        return dist;
    }
}
