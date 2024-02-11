package xyz.toddlasley.random.arraysandstrings;

public class RotationalCipher {
    private static int ALPHABET_COUNT = 26;
    private static int NUMBER_COUNT = 10;
    private static int CHARACTER_RADIX = 36;

    public static String rotate(String input, int rotationFactor) {
        if (rotationFactor == 0) {
            return input;
        }

        final int alphabeticRotation = rotationFactor - (ALPHABET_COUNT * (int)Math.floor(rotationFactor / ALPHABET_COUNT));
        final int numericRotation = rotationFactor - (NUMBER_COUNT * (int)Math.floor(rotationFactor / NUMBER_COUNT));
        final StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result.append(
                        String.valueOf(
                                rotateCharacter(c, alphabeticRotation, Character.getNumericValue('A'), Character.getNumericValue('Z'))
                        ).toUpperCase()
                );
            } else if (c >= 'a' && c <= 'z') {
                result.append(
                        String.valueOf(
                                rotateCharacter(c, alphabeticRotation, Character.getNumericValue('a'), Character.getNumericValue('z'))
                        ).toLowerCase()
                );
            } else if (c >= '0' && c <= '9') {
                result.append(
                        String.valueOf(
                                rotateCharacter(c, numericRotation, Character.getNumericValue('0'), Character.getNumericValue('9'))
                        )
                );
            } else {
                result.append(String.valueOf(c));
            }
        }

        return result.toString();
    }

    private static char rotateCharacter(final char c, final int rotationFactor, final int lowerBound, final int upperBound) {
        final int characterNumericvalue = Character.getNumericValue(c);

        if (characterNumericvalue + rotationFactor <= upperBound) {
            return Character.forDigit(characterNumericvalue + rotationFactor, CHARACTER_RADIX);
        } else {
            return Character.forDigit((lowerBound - 1) + ((characterNumericvalue + rotationFactor) - upperBound), CHARACTER_RADIX);
        }
    }
}
