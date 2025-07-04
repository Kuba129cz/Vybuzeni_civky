package Balik.kubuv;

public interface Pocty {
	double Magneticke_Pole_V_Okoli_Primeho_Vodice(double I, double a);
	double Magneticke_Pole_Uvnitr_Vodice(double I, double a, double r) throws Exception;
	double Magneticke_Pole_Uvnitr_Zavitu(double I, double D);
	double Magneticke_Pole_Uvnitr_Dlohe_Civky(double N, double I, double l);
	double Magneticke_Pole_Uvnitr_Toroidni_Civky(double N, double I,double R);
	double Magneticke_Pole_Uvnitr_Tenke_Civky(double N, double I,double D);
}
