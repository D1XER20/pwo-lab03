/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo;

/**
 *
 * @author student
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LucasSequence {
    public static void main(String[] args) {
        int n = 100; 
        long[] lucasSequence = generateLucasSequence(n);
        saveSequenceToFile(lucasSequence, "lucas_sequence.txt");
    }

    
    public static long[] generateLucasSequence(int n) {
        long[] sequence = new long[n];
        sequence[0] = 2;
        if (n > 1) {
            sequence[1] = 1;
            for (int i = 2; i < n; i++) {
                sequence[i] = sequence[i - 1] + sequence[i - 2];
            }
        }
        return sequence;
    }

   
    public static void saveSequenceToFile(long[] sequence, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < sequence.length; i++) {
                writer.write("L(" + i + ") = " + sequence[i]);
                writer.newLine();
            }
            System.out.println("Ciąg Lucasa został zapisany do pliku " + fileName);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania do pliku: " + e.getMessage());
        }
    }
}
