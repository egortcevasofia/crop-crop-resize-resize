package mts.teta;

import mts.teta.imagehandlers.*;
import picocli.CommandLine;
import picocli.CommandLine.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import static mts.teta.Validator.*;

@Command(name = "convert", mixinStandardHelpOptions = true, version = "https://github.com/egortcevasofia/crop-crop", synopsisHeading = "Available formats: jpeg, png\n" +
        "order of options: --resize, --quality, -crop, --blur\n" +
        "Usage: ")
public class MainConsole implements Callable<Integer> {

    @Parameters(index = "0", paramLabel = "input-file", description = "AbsolutePath to file or name of file, if it is in current directory")
    private String inputFilePath;

    @Parameters(index = "1", paramLabel = "output-file", description = "AbsolutePath to file or name of file, if it is must be saved in current directory")
    private String outputFilePath;

    @Option(names = {"-r", "--resize"}, paramLabel = "\"width height\"", description = "reduces, increases an image or set new size")
    private String resizeOption;

    @Option(names = {"-q", "--quality"}, paramLabel = "value", description = "set the compression level for JPEG / PNG files; from 1 (lowest quality) to 100 (best quality)")
    private String qualityOption;

    @Option(names = {"-c", "--crop"}, paramLabel = "\"width height x y\"", description = "cuts out a rectangular area of the image with width and height from point (x, y)")
    private String cropOption;

    @Option(names = {"-b", "--blur"}, paramLabel = "radius", description = "add blur")
    private String blurOption;

    @Option(names = {"-f", "--format"}, paramLabel = "jpg/png", description = "converts image to JPEG / PNG")
    private String formatOption;

    public static void main(String... args) {
        int exitCode = new CommandLine(new MainConsole()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        ConsoleAttributes consoleAttributes = new ConsoleAttributes();
        consoleAttributes.setInputFile(new File(inputFilePath));
        consoleAttributes.setOutputFile(new File(outputFilePath));

        validateOptions();

        resize(consoleAttributes);
        qualityChange(consoleAttributes);
        crop(consoleAttributes);
        blur(consoleAttributes);
        formatChange(consoleAttributes);
        return 0;
    }

    private void resize(ConsoleAttributes consoleAttributes) throws Exception {
        if (resizeOption != null) {
            List<String> params = Arrays.asList(resizeOption.split(" "));

            consoleAttributes.setResizeWidth(Integer.valueOf(params.get(0)));
            consoleAttributes.setResizeHeight(Integer.valueOf(params.get(1)));

            ResizerApp resizerApp = new ResizerApp(consoleAttributes);
            resizerApp.call();
            consoleAttributes.setInputFile(resizerApp.getOutputFile());
        }
    }

    private void qualityChange(ConsoleAttributes consoleAttributes) throws BadAttributesException {
        if (qualityOption != null) {

            consoleAttributes.setQualityValue(Integer.valueOf(qualityOption));

            QualityChangerApp qualityChangerApp = new QualityChangerApp(consoleAttributes);
            qualityChangerApp.call();
            consoleAttributes.setInputFile(qualityChangerApp.getOutputFile());
        }
    }

    private void crop(ConsoleAttributes consoleAttributes) throws BadAttributesException {
        if (cropOption != null) {
            List<String> params = Arrays.asList(cropOption.split(" "));

            consoleAttributes.setCropWidth(Integer.valueOf(params.get(0)));
            consoleAttributes.setCropHeight(Integer.valueOf(params.get(1)));
            consoleAttributes.setCropX(Integer.valueOf(params.get(2)));
            consoleAttributes.setCropY(Integer.valueOf(params.get(3)));

            CropperApp cropperApp = new CropperApp(consoleAttributes);
            cropperApp.call();
            consoleAttributes.setInputFile(cropperApp.getOutputFile());
        }
    }

    private void blur(ConsoleAttributes consoleAttributes) throws BadAttributesException {
        if (blurOption != null) {

            consoleAttributes.setBlurRadius(Integer.valueOf(blurOption));

            BluerApp bluerApp = new BluerApp(consoleAttributes);
            bluerApp.call();
            consoleAttributes.setInputFile(bluerApp.getOutputFile());
        }
    }

    private void formatChange(ConsoleAttributes consoleAttributes) throws Exception {
        if (formatOption != null) {

            String previousFormat = inputFilePath.substring(inputFilePath.length() - 3);
            String newFormat = outputFilePath.substring(outputFilePath.length() - 3);

            if (!previousFormat.equals(newFormat) && newFormat.equals(formatOption)) {
                consoleAttributes.setFormat(formatOption);
                FormatChangerApp formatChangerApp = new FormatChangerApp(consoleAttributes);
                formatChangerApp.call();
                consoleAttributes.setInputFile(formatChangerApp.getOutputFile());
            }
        }
    }

    private void validateOptions() throws BadAttributesException {

        if (resizeOption != null) {
            validateResizeOption(resizeOption);
        }

        if (qualityOption != null) {
            validateQualityOption(qualityOption);
        }

        if (cropOption != null) {
            validateCropOption(cropOption);
        }

        if (blurOption != null) {
            validateBlurOption(blurOption);
        }

        if (formatOption != null) {
            validateFormatOption(formatOption);
        }
    }
}
