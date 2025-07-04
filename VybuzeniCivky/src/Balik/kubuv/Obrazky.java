package Balik.kubuv;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class Obrazky {
	static ImageIcon[] schema;
	static ImageIcon[] rovnoSchema;
	//JFrame mujKontejner;
	
	public static ImageIcon ukazObraz(int index) 
	{
		schema = new ImageIcon[6];
		try {
			schema[0] = new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/1.png")));
			schema[1] = new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/2.png")));
			schema[2] = new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/3.png")));
			schema[3] = new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/4.png")));
			schema[4] = new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/5.png")));
			schema[5] = new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/6.png")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schema[index];
	}
	public static ImageIcon ukazRovnici(int index) 
	{
		rovnoSchema = new ImageIcon[6];
	
		try {
		rovnoSchema[0] = new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/m1.gif")));
		rovnoSchema[1] = new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/m2.gif")));
		rovnoSchema[2] = new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/m3.gif")));
		rovnoSchema[3] = new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/m4.gif")));
		rovnoSchema[4] = new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/m5.gif")));
		rovnoSchema[5] = new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/m6.gif")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rovnoSchema[index];
		}
}
