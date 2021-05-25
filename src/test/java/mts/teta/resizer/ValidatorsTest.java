package mts.teta.resizer;

import mts.teta.BadAttributesException;
import mts.teta.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorsTest {

    @Test
    void validateResizeOption_success() throws BadAttributesException {
        assertEquals(Validator.validateResizeOption("100 100"), 0);
    }

    @Test
    void validateResizeOption_wrongValidation_oneParameter() {

        BadAttributesException generatedException = null;

        try {
            Validator.validateResizeOption("400");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: resize options must be two params", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());
    }

    @Test
    void validateResizeOption_wrongValidation_negativeParameter() {

        BadAttributesException generatedException = null;

        try {
            Validator.validateResizeOption("100 -100");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: resize options must be positive", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());
    }

    @Test
    void validateResizeOption_wrongValidation_textParameter() {

        BadAttributesException generatedException = null;

        try {
            Validator.validateResizeOption("10 ten");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: resize options must be digits", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());
    }

    @Test
    void validateQualityOption_success() throws BadAttributesException {
        assertEquals(Validator.validateQualityOption("100"), 0);
    }

    @Test
    void validateQualityOption_wrongValidation_manyParameters() throws BadAttributesException {
        BadAttributesException generatedException = null;

        try {
            Validator.validateQualityOption("one two three four five six");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: quality option must be one param", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());
    }


    @Test
    void validateQualityOption_wrongValidation_outOfRange1() throws BadAttributesException {
        BadAttributesException generatedException = null;

        try {
            Validator.validateQualityOption("10000000");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: quality option must be in range 1..100", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());
    }

    @Test
    void validateQualityOption_wrongValidation_outOfRange2() throws BadAttributesException {
        BadAttributesException generatedException = null;

        try {
            Validator.validateQualityOption("-1");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: quality option must be in range 1..100", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());
    }

    @Test
    void validateQualityOption_wrongValidation_textParameter() throws BadAttributesException {
        BadAttributesException generatedException = null;

        try {
            Validator.validateQualityOption("ten");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: quality option must be digit", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());
    }

    @Test
    void validateCropOption_success() throws BadAttributesException {
        assertEquals(Validator.validateCropOption("10 10 10 10"), 0);
    }

    @Test
    void validateCropOption_wrongValidation_oneParameter() {
        BadAttributesException generatedException = null;

        try {
            Validator.validateCropOption("one");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: crop options must be four params", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());
    }

    @Test
    void validateCropOption_wrongValidation_negativeParameter() {
        BadAttributesException generatedException = null;

        try {
            Validator.validateCropOption("10 10 -10 10");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: crop options must be positive", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());
    }

    @Test
    void validateCropOption_wrongValidation_textParameter() {
        BadAttributesException generatedException = null;

        try {
            Validator.validateCropOption("one two three four");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: crop options must be digits", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());
    }

    @Test
    void validateBlurOption_success() throws BadAttributesException {
        assertEquals(Validator.validateBlurOption("15"), 0);
    }

    @Test
    void validateBlurOption_wrongValidation_manyParameters() {


        BadAttributesException generatedException = null;

        try {
            Validator.validateBlurOption("one two three four five six");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: blur option must be one param", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());

    }

    @Test
    void validateBlurOption_wrongValidation_negativeParameter() {


        BadAttributesException generatedException = null;

        try {
            Validator.validateBlurOption("-10");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: blur option must be positive", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());

    }

    @Test
    void validateBlurOption_wrongValidation_textParameter() {
        BadAttributesException generatedException = null;

        try {
            Validator.validateBlurOption("ten");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: blur option must be digit", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());
    }

    @Test
    void validateFormatOption_success_jpg() throws BadAttributesException {
        assertEquals(Validator.validateFormatOption("jpg"), 0);
    }

    @Test
    void validateFormatOption_success_png() throws BadAttributesException {
        assertEquals(Validator.validateFormatOption("png"), 0);
    }

    @Test
    void validateFormatOption_wrongValidation_wrongFormat() {
        BadAttributesException generatedException = null;

        try {
            Validator.validateFormatOption("avi");
        } catch (BadAttributesException e) {
            generatedException = e;
        }

        assertEquals("Wrong params: new format must be png or jpg", generatedException.getMessage());
        assertEquals(BadAttributesException.class, generatedException.getClass());
    }
}
