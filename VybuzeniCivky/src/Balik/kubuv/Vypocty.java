package Balik.kubuv;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Vypocty implements Pocty {
	JFrame mujKontejner;
	public Vypocty(JFrame mujKontejner)
	{
		this.mujKontejner = mujKontejner;
	}
	@Override
	public double Magneticke_Pole_V_Okoli_Primeho_Vodice(double I, double a) {
		if(a == 0 ){JOptionPane.showMessageDialog(mujKontejner, "a nesmi byt nula");
		return 0;}
		if(I< 0|| a< 0){ JOptionPane.showMessageDialog(mujKontejner, "zadavate zaporny cisla");
			return 0;
		}
		return  I/(2*Math.PI*a);
	}

	@Override
	public double Magneticke_Pole_Uvnitr_Vodice(double I, double a, double r){
		if(r == 0 ){JOptionPane.showMessageDialog(mujKontejner, "r nesmi byt nula");
		return 0;}
		if(I< 0|| a< 0||r < 0){ JOptionPane.showMessageDialog(mujKontejner, "zadavate zaporny cisla");
			return 0;
		}
		return (I*a)/(2*Math.PI*Math.pow(r, 2));
	}

	@Override
	public double Magneticke_Pole_Uvnitr_Zavitu(double I, double D) {
		if(D == 0 ){JOptionPane.showMessageDialog(mujKontejner, "D nesmi byt nula");
		return 0;}
		if(D< 0|| I< 0){ JOptionPane.showMessageDialog(mujKontejner, "zadavate zaporny cisla");
			return 0;
		}
		return I/D;
	}

	@Override
	public double Magneticke_Pole_Uvnitr_Dlohe_Civky(double N, double I, double l) {
		if(l == 0 ){JOptionPane.showMessageDialog(mujKontejner, "l nesmi byt nula");
		return 0;}
		if(I< 0|| N< 0||l < 0){ JOptionPane.showMessageDialog(mujKontejner, "zadavate zaporny cisla");
			return 0;
		}
		return (N*I)/l;
	}

	@Override
	public double Magneticke_Pole_Uvnitr_Toroidni_Civky(double N, double I, double R) {
		if(R == 0 ){JOptionPane.showMessageDialog(mujKontejner, "R nesmi byt nula");
		return 0;}
		if(I< 0|| N< 0||R < 0){ JOptionPane.showMessageDialog(mujKontejner, "zadavate zaporny cisla");
			return 0;
		}
		return (N*I)/(2*Math.PI*R);
	}
	public double Magneticke_Pole_Uvnitr_Tenke_Civky(double N, double I,double D)
	{
		if(D == 0 ){JOptionPane.showMessageDialog(mujKontejner, "D nesmi byt nula");
		return 0;}
		if(I< 0|| N< 0||D < 0){ JOptionPane.showMessageDialog(mujKontejner, "zadavate zaporny cisla");
			return 0;
		}
		return (N*I)/D;
	}
}