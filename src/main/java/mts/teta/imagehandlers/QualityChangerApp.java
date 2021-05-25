package mts.teta.imagehandlers;

import mts.teta.ImageProcessor;

import java.util.concurrent.Callable;

public class QualityChangerApp extends ConsoleAttributes implements Callable<Integer> {

    public QualityChangerApp(ConsoleAttributes consoleAttributes) {
        this.inputFile = consoleAttributes.inputFile;
        this.outputFile = consoleAttributes.outputFile;
        this.qualityValue = consoleAttributes.qualityValue;
    }

    @Override
    public Integer call() {
        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.processImage(this);
        return 0;
    }
}
