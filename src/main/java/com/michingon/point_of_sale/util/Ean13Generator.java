package com.michingon.point_of_sale.util;

public class Ean13Generator {

    /**
     * Genera un código EAN-13 interno válido.
     * Estructura: 2 + CC + PPPPP + TT + D
     * * @param category (CC) 2 dígitos (1-99)
     * 
     * @param sequence (PPPPP) 5 dígitos (1-99999)
     * @param size     (TT) 2 dígitos (10-99)
     * @return String con el código de 13 dígitos y checksum correcto.
     */

    public static String generateEan13(int category, int sequence, int size) {
        // Give format numbers with leading zeros
        String cc = String.format("%02d", category);
        String pppp = "2" + cc + String.format("%05d", sequence);
        String tt = String.format("%02d", size);

        String baseCode = "2" + cc + pppp + tt;
        int checksum = calculateChecksum(baseCode);
        return baseCode + checksum;
    }

    private static int calculateChecksum(String code) {
        int sumOdd = 0; // Positions 1,3,5,7,9,11...
        int sumEven = 0; // Positions 2,4,6,8,10,12...

        for (int i = 0; i < code.length(); i++) {
            int digit = Character.getNumericValue(code.charAt(i));
            if (i % 2 == 0) {
                sumOdd += digit;
            } else {
                sumEven += digit;
            }
        }
        int total = sumOdd + (sumEven * 3);
        int remainder = total % 10;
        return (remainder == 0) ? 0 : 10 - remainder;
    }
}