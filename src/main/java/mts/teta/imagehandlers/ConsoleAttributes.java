package mts.teta.imagehandlers;

import java.io.File;

public class ConsoleAttributes {

    protected File inputFile;
    protected File outputFile;
    protected Integer resizeWidth;
    protected Integer resizeHeight;
    protected Integer qualityValue;
    protected Integer cropWidth;
    protected Integer cropHeight;
    protected Integer cropX;
    protected Integer cropY;
    protected Integer blurRadius;
    protected String format;

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public Integer getResizeWidth() {
        return resizeWidth;
    }

    public void setResizeWidth(Integer resizeWidth) {
        this.resizeWidth = resizeWidth;
    }

    public Integer getResizeHeight() {
        return resizeHeight;
    }

    public void setResizeHeight(Integer resizeHeight) {
        this.resizeHeight = resizeHeight;
    }

    public Integer getQualityValue() {
        return qualityValue;
    }

    public void setQualityValue(Integer qualityValue) {
        this.qualityValue = qualityValue;
    }

    public Integer getCropWidth() {
        return cropWidth;
    }

    public void setCropWidth(Integer cropWidth) {
        this.cropWidth = cropWidth;
    }

    public Integer getCropHeight() {
        return cropHeight;
    }

    public void setCropHeight(Integer cropHeight) {
        this.cropHeight = cropHeight;
    }

    public Integer getCropX() {
        return cropX;
    }

    public void setCropX(Integer cropX) {
        this.cropX = cropX;
    }

    public Integer getCropY() {
        return cropY;
    }

    public void setCropY(Integer cropY) {
        this.cropY = cropY;
    }

    public Integer getBlurRadius() {
        return blurRadius;
    }

    public void setBlurRadius(Integer blurRadius) {
        this.blurRadius = blurRadius;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
