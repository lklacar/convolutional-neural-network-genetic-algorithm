package com.lukaklacar.convgen.image;

public class ImageMatrix {

    private double[][] redChannel;
    private double[][] greenChannel;
    private double[][] blueChannel;

    private int width, height;

    public ImageMatrix(int width, int height, double[][] redChannel, double[][] greenChannel, double[][] blueChannel) {
        this.redChannel = redChannel;
        this.greenChannel = greenChannel;
        this.blueChannel = blueChannel;
        this.width = width;
        this.height = height;
    }

    public double[][] getRedChannel() {
        return redChannel;
    }

    public double[][] getGreenChannel() {
        return greenChannel;
    }

    public double[][] getBlueChannel() {
        return blueChannel;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
