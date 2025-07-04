package Balik.kubuv;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Zapis {
	public static void napis() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("vysledky.txt")))
		{
		}
		catch (Exception e)
		{
		        System.err.println("Do souboru se nepovedlo zapsat.");
		}
	}
	
	public static void napis(String string, double i, String string2, double a, String string3, String text) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("vysledky.txt", true)))
		{
		        bw.write("vypocet: " + string + " byl:");
		        bw.newLine();
		        bw.write(string2 +  i + ", " + string3 + a );
		        bw.newLine();
		        bw.write(text+ "A/m");
		        bw.newLine();
		        bw.write("");
		        bw.newLine();
		        bw.flush();
		}
		catch (Exception e)
		{
		        System.err.println("Do souboru se nepovedlo zapsat.");
		}
	}

	public static void napis(String string, double i, String string2, double a, String string3, double r,
			String string4, String text) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("vysledky.txt", true)))
		{
		        bw.write("vypocet: " + string + " byl:");
		        bw.newLine();
		        bw.write(string2 +  i + ", " + string3 + a + ", " + string4 + r);
		        bw.newLine();
		        bw.write(text + "A/m");
		        bw.newLine();
		        bw.write("");
		        bw.newLine();
		        bw.flush();
		}
		catch (Exception e)
		{
		        System.err.println("Do souboru se nepovedlo zapsat.");
		}
	}
}
