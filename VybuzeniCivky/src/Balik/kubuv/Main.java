package Balik.kubuv;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;//pro tlacitko
import java.awt.event.*;//pro tlacitko,textfield
import java.io.BufferedReader;
import java.io.FileReader;

public class Main implements ActionListener, ListSelectionListener{
	JLabel mujLabel2;
	JTextField mujTextBox;
	JTextField mujTextBox2;
	int cisla;
	JList<String> mujListik;
	JScrollPane mujKontejnerLisovac;
	String jmena[] = {"Magnetické pole v okolí pøímého vodièe", "Magnetické pole uvnitø vodièe", "Magnetické pole uvnitø závitu", "Magnetické pole uvnitø tenké cívky",
			"Magnetické pole uvnitø dlouhé cívky", "Magnetické pole uvnitø toroidní cívky"};
	JFrame mujKontejner;
	JLabel mujLabel3;
	JLabel mujLabel4;
	JLabel vysh;
	int ind = -1; // index
	JTextField mujTextBox3;
	Vypocty vypoc;
	JTextArea mujTextik;
	boolean cteni = true;
	JButton mojeTlacitko3 ;
	String predchoziText;
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Main();
			}
		});
	}
	Main()
	{
		try{
		mujKontejner = new JFrame("Aplikace na vybuzení cívky");
		ZavriOkno zo = new ZavriOkno(mujKontejner);
		vypoc = new Vypocty(mujKontejner);
		mujKontejner.addWindowListener(zo);
		mujKontejner.setLayout(new FlowLayout()); // rozvrzeni okna
		mujKontejner.setSize(700, 300);
		mujKontejner.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		//zaèínám tvoøit
		JLabel mujLabel = new JLabel("Vybuzení cívky zvol vzorec");
		mujKontejner.add(mujLabel, BorderLayout.EAST);
		mujLabel2 = new JLabel("Zatim neprovedena akce");
		mujKontejner.add(mujLabel2);	
		
		JButton mojeTlacitko1 = new JButton("Vypocti");
		JButton mojeTlacitko2 = new JButton("historie");
		 mojeTlacitko3 = new JButton("reset");
		
		mojeTlacitko3.setVisible(false);
	mojeTlacitko1.addActionListener(this);
	mojeTlacitko2.addActionListener(this);
	mojeTlacitko3.addActionListener(this);
		
		mujKontejner.add(mojeTlacitko1);
		mujKontejner.add(mojeTlacitko2);
		mujKontejner.add(mojeTlacitko3);
		
		mujTextBox = new JTextField(13); //zalozeni textfieldu
		mujTextBox.setActionCommand("mojeTP");
		mujTextBox.addActionListener(this);
		mujKontejner.add(mujTextBox);
		
		mujTextBox2 = new JTextField(13);
		mujTextBox2.addActionListener(this);
		mujKontejner.add(mujTextBox2);
		
		mujTextBox3 = new JTextField(13);
		mujTextBox3.addActionListener(this);
		mujKontejner.add(mujTextBox3);
		mujTextBox3.setVisible(false);
		
		//list
		mujListik = new JList<String>(jmena);
		mujListik.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //nastavi vyber se zeznamu jedne polozky
		mujKontejnerLisovac = new JScrollPane(mujListik); //nasloucha
		mujKontejnerLisovac.setPreferredSize(new Dimension(240,120));
		mujListik.addListSelectionListener(this);
		mujKontejner.add(mujKontejnerLisovac);
		
		mujTextBox.setVisible(false);
		mujTextBox2.setVisible(false);
		
		mujLabel3 = new JLabel();
		mujLabel4 = new JLabel();
		vysh = new JLabel();
		
		mujTextik = new JTextArea();
		
		mujKontejner.add(vysh);
		mujKontejner.add(mujTextik);
		
		
		mujKontejner.setVisible(true);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(mujKontejner, "je nam lito, ale nekde se naskytla nejaka chybka");
			}
		}
	 
		
		public void actionPerformed(ActionEvent ae)
		{
			try{
				if(ae.getActionCommand().equals("reset")){
					Zapis.napis();
					mujTextik.setText("");
				//	String predchoziText = "";
					cteni = false;
					mujTextik.setVisible(false);
				}
				else{
				if(ae.getActionCommand().equals("historie")){
					if(cteni == true)
						{	
					nactiSoubor();
						}cteni = false;
						mujTextik.setVisible(true);
						mojeTlacitko3.setVisible(true);
					}else{
						cteni = true;
						mujTextik.setVisible(true);
						mojeTlacitko3.setVisible(false);
			if(this.ind == -1)JOptionPane.showMessageDialog(mujKontejner, "Zvolte index v seznamu, prosim");
			else{		
			switch(this.ind)
			{
			case 0: {
				double I = Double.parseDouble(mujTextBox.getText());
				double a = Double.parseDouble(mujTextBox2.getText());
				vysh.setText(String.format("H= %.2f",vypoc.Magneticke_Pole_V_Okoli_Primeho_Vodice(I, a) ));
				Zapis.napis(jmena[ind],I,"proud(I): ", a, "delka(a)",vysh.getText());
			}break;
			case 1 :{
				double I = Double.parseDouble(mujTextBox.getText());
				double a = Double.parseDouble(mujTextBox2.getText());
				double r = Double.parseDouble(mujTextBox3.getText());
				vysh.setText(String.format("H= %.2f", vypoc.Magneticke_Pole_Uvnitr_Vodice(I, a, r)));
				Zapis.napis(jmena[ind],I,"proud(I): ", a, "delka(a)",r, "polomer(r):", vysh.getText());
			}break;
			case 2 :{
				double I = Double.parseDouble(mujTextBox.getText());
				double D = Double.parseDouble(mujTextBox2.getText());
				vysh.setText(String.format("H= %.2f", vypoc.Magneticke_Pole_Uvnitr_Zavitu(I, D)));
				Zapis.napis(jmena[ind],I,"proud(I): ", D, "delka(a)",vysh.getText());
			}break;
			case 3 :{
				double N = Double.parseDouble(mujTextBox.getText());
				double I = Double.parseDouble(mujTextBox2.getText());
				double D = Double.parseDouble(mujTextBox3.getText());
				vysh.setText(String.format("H= %.2f", vypoc.Magneticke_Pole_Uvnitr_Tenke_Civky(N, I, D)));
				Zapis.napis(jmena[ind],N, "pocet zavitu(N): ",I, "velikost proudu(I): ", D, "delka(D): " ,vysh.getText());
			}break;
			case 4 :{
				double N = Double.parseDouble(mujTextBox.getText());
				double I = Double.parseDouble(mujTextBox2.getText());
				double l = Double.parseDouble(mujTextBox3.getText());
				vysh.setText(String.format("H= %.2f", vypoc.Magneticke_Pole_Uvnitr_Dlohe_Civky(N, I, l)));
				Zapis.napis(jmena[ind], N, "Pocet zavitu(N): ",I,"velikost proudu(I): ",l,"delka(l)",vysh.getText());
			}break;
			case 5 :{
				double N = Double.parseDouble(mujTextBox.getText());
				double I = Double.parseDouble(mujTextBox2.getText());
				double R = Double.parseDouble(mujTextBox3.getText());
				vysh.setText(String.format("H= %.2f", vypoc.Magneticke_Pole_Uvnitr_Toroidni_Civky(N, I, R)));
				Zapis.napis(jmena[ind],N,"pocet zavitu(N): ", I, "velikost proudu(I)",R,"polomer toroidu(R): ",vysh.getText());
			}break;
			}	
	}}}}catch(ArithmeticException e)
			{
		JOptionPane.showMessageDialog(mujKontejner, "delite nulou");
			}
			catch(Exception e)
			{
		JOptionPane.showMessageDialog(mujKontejner, "do textoveho pole zadavejte jen cisla");
			}
			}
		
		@Override
		public void valueChanged(ListSelectionEvent le) {
			int index;
			mojeTlacitko3.setVisible(false);
			index = mujListik.getSelectedIndex();
			if(index !=-1){
				mujTextBox.setVisible(true);
				mujTextBox2.setVisible(true);
				mujLabel2.setText("Aktualni vyber: " + jmena[index]);
				zobrazObraz(index);
				zobrazRovnici(index);
				if(index == 0 || index == 2)mujTextBox3.setVisible(false);
				else
					mujTextBox3.setVisible(true);
			switch(index)
			{
			case 0: {
				
				mujTextBox.setText("zadejte proud(I)");
				mujTextBox2.setText("zadejte delku(a)");
			}break;
			case 1:{
				mujTextBox.setText("zadejte proud(I)");
				mujTextBox2.setText("zadejte delku(a)");
				mujTextBox3.setText("zadejte polomer(r)");
			}break;
			case 2:
			{
				mujTextBox.setText("zadejte proud(I)");
				mujTextBox2.setText("zadejte delku(D)");
			}break;
			case 3:
			{
				mujTextBox.setText("zadejte pocet zavitu(N)");
				mujTextBox2.setText("zadejte delku(I)");
				mujTextBox3.setText("zadejte delku(D)");
			}break;
			case 4:
			{
				mujTextBox.setText("zadejte pocet zavitu(N)");
				mujTextBox2.setText("zadejte proud(I)");
				mujTextBox3.setText("zadejte delku(l)");
			}break;
			case 5:
			{
				mujTextBox.setText("zadejte pocet zavitu(N)");
				mujTextBox2.setText("zadejte proud(I)");
				mujTextBox3.setText("polomer toroidu(R)");
			}break;
			}
			}
			else{
				mujLabel2.setText("Zvolte jmeno");			
		}this.ind = index;
			}
		private void zobrazObraz(int index) {
			try{
				mujLabel3.setIcon(Obrazky.ukazObraz(index));
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	mujKontejner.add(mujLabel3);
			
		}
		private void zobrazRovnici(int index)
		{
			mujKontejner.add(mujLabel4);
			try{
				mujLabel4.setIcon(Obrazky.ukazRovnici(index));
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		private void nactiSoubor()
		{
			try (BufferedReader br = new BufferedReader(new FileReader("vysledky.txt")))
			{
			        String s;
			        while ((s = br.readLine()) != null)
			        {
			        	    predchoziText = mujTextik.getText();      
			        	    mujTextik.setText(predchoziText + "\n\r" + s);
			        }
			        mujTextik.setEditable(false);
			}
			catch (Exception e)
			{
			        System.err.println("Chyba pøi èetení ze souboru.");
			}
		}
}
