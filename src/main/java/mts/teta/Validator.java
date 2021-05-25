package mts.teta;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public static int validateResizeOption(String option) throws BadAttributesException {
        List<String> resizeOptions  = Arrays.asList(option.split(" "));
        if (resizeOptions.size() != 2) {
            throw new BadAttributesException("Wrong params: resize options must be two params");
        }
        try {
            int width = Integer.parseInt(resizeOptions.get(0));
            int height = Integer.parseInt(resizeOptions.get(1));
            if (width < 0 || height < 0) {
                throw new BadAttributesException("Wrong params: resize options must be positive");
            }
        } catch (NumberFormatException e) {
            throw new BadAttributesException("Wrong params: resize options must be digits");
        }
        return 0;
    }

    public static int validateQualityOption(String qualityOption) throws BadAttributesException {
        if (qualityOption.split(" ").length != 1) {
            throw new BadAttributesException("Wrong params: quality option must be one param");
        }
        try {
            int value = Integer.parseInt(qualityOption);
            if (value < 1 || value > 100) {
                throw new BadAttributesException("Wrong params: quality option must be in range 1..100");
            }
        } catch (NumberFormatException e) {
            throw new BadAttributesException("Wrong params: quality option must be digit");
        }
        return 0;
    }

    public static int validateCropOption(String option) throws BadAttributesException {
        List<String> cropOptions = Arrays.asList(option.split(" "));
        if (cropOptions.size() != 4) {
            throw new BadAttributesException("Wrong params: crop options must be four params");
        }
        try {
            int width = Integer.parseInt(cropOptions.get(0));
            int height = Integer.parseInt(cropOptions.get(1));
            int x = Integer.parseInt(cropOptions.get(2));
            int y = Integer.parseInt(cropOptions.get(3));
            if (width < 0 || height < 0 || x < 0 || y < 0) {
                throw new BadAttributesException("Wrong params: crop options must be positive");
            }
        } catch (NumberFormatException e) {
            throw new BadAttributesException("Wrong params: crop options must be digits");
        }
        return 0;
    }

    public static int validateBlurOption(String blurOption) throws BadAttributesException {
        if (blurOption.split(" ").length != 1) {
            throw new BadAttributesException("Wrong params: blur option must be one param");
        }
        try {
            int radius = Integer.parseInt(blurOption);
            if (radius < 0) {
                throw new BadAttributesException("Wrong params: blur option must be positive");
            }
        } catch (NumberFormatException e) {
            throw new BadAttributesException("Wrong params: blur option must be digit");
        }
        return 0;
    }

    public static int validateFormatOption(String formatOption) throws BadAttributesException {
        if (!formatOption.equals("png") && !formatOption.equals("jpg")) {
            throw new BadAttributesException("Wrong params: new format must be png or jpg");
        }
        return 0;
    }
}
