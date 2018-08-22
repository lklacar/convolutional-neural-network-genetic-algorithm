package com.lukaklacar.convgen;

import com.lukaklacar.convgen.image.ImageMatrix;
import com.lukaklacar.convgen.image.ImageUtil;
import com.lukaklacar.convgen.neuralnetwork.layers.ConvolutionLayer;
import com.lukaklacar.convgen.util.Dimension;
import org.ejml.simple.SimpleMatrix;

public class Program {

    public static void main(String[] args) {

        ImageMatrix matrix = ImageUtil.loadImage("/home/luka/Pictures/tutorial_image_1.png");


        ConvolutionLayer convolutionLayer = new ConvolutionLayer(new Dimension(3, 3));
        convolutionLayer.setWeights(new SimpleMatrix(new double[][]{
                new double[]{1, 0, 0},
                new double[]{1, 0, 0},
                new double[]{1, 0, 0},
        }));
        SimpleMatrix processedRedChannel = convolutionLayer.process(new SimpleMatrix(matrix.getRedChannel()));
        SimpleMatrix processedGreenChannel = convolutionLayer.process(new SimpleMatrix(matrix.getGreenChannel()));
        SimpleMatrix processedBlueChannel = convolutionLayer.process(new SimpleMatrix(matrix.getBlueChannel()));

        ImageMatrix processedImageMatrix = new ImageMatrix(250, 250,
                doShit(processedRedChannel),
                doShit(processedGreenChannel),
                doShit(processedBlueChannel));

        ImageUtil.writeImage(processedImageMatrix, "test.jpg");

    }

    private static double[][] doShit(SimpleMatrix sm) {
        double[][] res = new double[sm.numCols()][sm.numRows()];

        for (int i = 0; i < sm.numCols(); i++) {
            for (int j = 0; j < sm.numRows(); j++) {
                res[i][j] = sm.get(i, j);
            }
        }

        return res;
    }

}
