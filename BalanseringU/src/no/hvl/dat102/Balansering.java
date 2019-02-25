package no.hvl.dat102;

import java.io.*;

import no.hvl.dat102.kjedet.KjedetStabel;

public class Balansering {

	private KjedetStabel<Parentesinfo> stabel;

	public Balansering() {
		stabel = new KjedetStabel<Parentesinfo>();
	}

	private boolean passer(char opent, char lukket) {
		switch (opent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {

		int lengde = innDataStreng.length();
		int i = 0;
		char symbol;
		//boolean balansert = true;
		//treng eg den boolean balansert??? skal behandle resten av teksten... dette vil hoppe til neste linje

		while(i < lengde) { 
			symbol = innDataStreng.charAt(i);

			if (symbol == '(' || symbol == '{' || symbol == '[') {
				Parentesinfo pInfo = new Parentesinfo(linjenr, i, symbol);
				stabel.push(pInfo);

			} else if (symbol == ')' || symbol == '}' || symbol == ']'){

				if(stabel.erTom()) {
					//balansert = false;
					System.out.println("Lukkesymbol " + symbol + " på linje nr " + linjenr + ", teikn nr " + i + " manglar tilsvarande åpnesymbol.");

				} else {
					Parentesinfo openPInfo = stabel.pop();
					char open = openPInfo.getVenstreparentes();
					if(!passer(open, symbol)) {
						//balansert = false;
						System.out.println("Lukkesymbol " + symbol + " på linje nr " + linjenr + ", teikn nr " + i + " har feil åpnesymbol (" + open + ").");
					}

				}
			}
			i++;
		}

	}//

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ike filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 0;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				linjenr++; //begynner på linje 1?, eller 0?
				foretaBalansering(linje, linjenr);

				linje = tekstLeser.readLine();
			} // while

			while (!stabel.erTom()) { //må teste om dette her då det er slutten på teksten
				Parentesinfo pInfo = stabel.pop();
				System.out.println("Åpnesymbol " + pInfo.getVenstreparentes() + " på linje nr " + pInfo.getLinjenr() + ", teikn nr " + pInfo.getPosisjon() + " har ikkje tilsvarande lukkesymbol.");
			}
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}// metode

}// class
