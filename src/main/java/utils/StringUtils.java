package utils;

import java.util.Random;

public class StringUtils {
    public String generateRandomAlphanumeric(final int length) {
        String randomAlphanumeric = generateRandomCharSequence(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
        return randomAlphanumeric;
    }

    public String generateRandomString(final int length) {
        String randomString = generateRandomCharSequence(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        return randomString;
    }

    public String generateRandomNumber(final int length) {
        String randomNumber = generateRandomCharSequence(length, "1234567890");
        return randomNumber;
    }

    private String generateRandomCharSequence(final int length, final String possibleChars) {
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        while (builder.length() < length) {
            int index = (int)(rnd.nextFloat() * possibleChars.length());
            builder.append(possibleChars.charAt(index));
        }

        return builder.toString();
    }
}
