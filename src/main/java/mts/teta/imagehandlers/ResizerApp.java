package mts.teta.imagehandlers;

import mts.teta.ImageProcessor;

import javax.imageio.ImageIO;
import java.util.concurrent.Callable;

public class ResizerApp extends ConsoleAttributes implements Callable<Integer> {

    public ResizerApp() {
    }

    public ResizerApp(ConsoleAttributes consoleAttributes) {
        this.inputFile = consoleAttributes.getInputFile();
        this.outputFile = consoleAttributes.getOutputFile();
        this.resizeWidth = consoleAttributes.getResizeWidth();
        this.resizeHeight = consoleAttributes.getResizeHeight();
    }

    @Override
    public Integer call() throws Exception {
        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.processImage(ImageIO.read(inputFile), this);
        return 0;
    }
}
