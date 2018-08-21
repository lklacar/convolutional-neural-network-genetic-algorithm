package com.lukaklacar.convgen;

import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.CommonOps;
import org.ejml.simple.SimpleMatrix;

public class Program {

    public static void main(String[] args) {

//        new ConvolutionLayer(new Dimension(3, 3)).process(new SimpleMatrix(new double[][]{
//                new double[]{1, 2, 3},
//                new double[]{1, 2, 3},
//                new double[]{1, 2, 3}
//        }));

        SimpleMatrix w = new SimpleMatrix(new double[][]{
                new double[]{1, 2, 3},
                new double[]{4, 5, 6},
                new double[]{1, 1234245, 9}
        });

        SimpleMatrix maxes = new SimpleMatrix(new double[][]{
                new double[]{3},
                new double[]{6},
                new double[]{1234245}
        });


        new SoftmaxLayer().process(w);


//
//        DenseMatrix64F res = new DenseMatrix64F();
//
//        CommonOps.sub(w, maxes, res);
//
//        System.out.println(res);

    }

}
