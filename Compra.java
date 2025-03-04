/**
 * @author Abel Sturm
 * @date 04/03/2022
 * @version 1.1
 */

package com.company;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Classe amb un programa per comprar en un supermercat, on es poden comprar diferenets porductes.
 */
public class Compra {
	/**
	 * La variable final NOM_SUPERMERCAT ens definira el nom del nostre supermercat.
	 */
	public static final String NOM_SUPERMERCAT = "SAPAMERCAT";
	/**
	 * La variable sc, ens permetra rebre input a traves del teclat.
	 */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Llista dels productes del nostre supermercat de tipus Alimentacio
	 */
	private List<Alimentacio> llista_ali;

	/**
	 * Llista dels productes del nostre supermercat de tipus Electronica
	 */
	private List<Electronica> llista_elec;

	/**
	 * Llista dels productes del nostre supermercat de tipus Textil
	 */
	private List<Textil> llista_textil;

	/**
	 * Constructor on assignem els productes a les arrays, privades, que utilitzarem.
	 */
	public Compra() {
		llista_ali = new ArrayList<Alimentacio>();
		llista_elec = new ArrayList<Electronica>();
		llista_textil = new ArrayList<Textil>();
	}

	/**
	 * Funcio principal del porgrama, que iniciara els menus del programa i anirar cridant diferents funcions segons l'opcio del usuari.
	 */
	public static void iniciarCompra() {
		/*
		REFACT: He utilitzat el metode d'Extraccio de metode, per refactorizar aquesta funcio i executar el programa
		des de la classe principal Main.class.
		*/
		int op,opP;
		Compra compra = new Compra();

		System.out.println("BENVINNGUT AL " + Compra.NOM_SUPERMERCAT);
		do {
			op = compra.menuPrincipal();
			switch(op) {
				case 1:
					do {
						opP =  compra.menuProducte();
						switch(opP) {
							case 1:
								System.out.println("Afegir aliment");
								compra.addAliment();
								break;
							case 2:
								System.out.println("Afegir tèxtil");
								compra.addTextil();
								break;
							case 3:
								System.out.println("Afegir electrònica");
								compra.addElectronica();
								break;
							default: break;
						}
					}while(opP!=0);
					break;
				case 2: compra.passarCaixa(); break;
				case 3:
					System.out.println("Carret");
					compra.printCarret();
					break;
				case 0:	System.out.println("Gràcies per la seva visita"); break;
				default: break;
			}

		}while(op!=0);

	}

	/**
	 * Funcio on mostrarem el menu d'incic, i retornara l'opcio que l'usuari tri-hi.
	 * @return Ens retornara una variable de tipus int.
	 */
	public int menuPrincipal() {
		int op;
		System.out.println("------------");
		System.out.println("-- INICI ---");
		System.out.println("------------");
		System.out.println("1) Introduir producte");
		System.out.println("2) Passar per caixa");
		System.out.println("3) Mostar carret de compra");
		System.out.println("0) Acabar");

		op = Integer.parseInt(sc.nextLine());
		return op;
	}

	/**
	 * Funcio on mostrarem el menu el producte, i etornara l'opcio que l'usuari tri-hi.
	 * @return Ens retornara una variable de tipus int.
	 */
	public int menuProducte() {
		int op;
		System.out.println("---------------");
		System.out.println("-- PRODUCTE ---");
		System.out.println("---------------");
		System.out.println("1) Alimentació");
		System.out.println("2) Tèxtil");
		System.out.println("3) Electrònica");
		System.out.println("0) Tornar");

		op = Integer.parseInt(sc.nextLine());
		return op;
	}

	/**
	 * Funcio per afegir productes al nostre supermercat del tipus Aliment
	 */
	public void addAliment() {
		String nom, codi;
		float preu;
		Calendar datac = new GregorianCalendar();
		String dateFormat = "dd/MM/yyyy";
		
		System.out.print("Nom producte:\t");
		nom = sc.nextLine();
		System.out.print("preu:\t");
		preu = Float.parseFloat(sc.nextLine());
		System.out.print("Codi de barres:\t");
		codi = sc.nextLine();
		System.out.print("Data de caducitat (dd/mm/aaaa):\t");
		LocalDate ld = readDate();
		llista_ali.add(new Alimentacio(preu,nom,codi,ld));
	}

	/**
	 * Funcio per afegir productes al nostre supermercat del tipus Textil
	 */
	public void addTextil() {
		String nom, compo, codi;
		float preu;
		
		System.out.print("Nom producte:\t");
		nom = sc.nextLine();
		System.out.print("preu:\t");
		preu = Float.parseFloat(sc.nextLine());
		System.out.print("Composició:\t");
		compo = sc.nextLine();
		System.out.print("Codi de barres:\t");
		codi = sc.nextLine();
		
		llista_textil.add(new Textil(preu,nom,codi,compo));	
	}

	/**
	 * Funcio per afegir productes al nostre supermercat del tipus Electornica
	 */
	public void addElectronica() {
		String nom,codi;
		float preu;
		int garantia;
		
		System.out.print("Nom producte:\t");
		nom = sc.nextLine();
		System.out.print("preu:\t");
		preu = Float.parseFloat(sc.nextLine());
		System.out.print("Garantia (dies):\t");
		garantia = Integer.parseInt(sc.nextLine());
		System.out.print("Codi de barres:\t");
		codi = sc.nextLine();
		
		llista_elec.add(new Electronica(preu,nom,codi,garantia));	
	}

	/**
	 * Funcio per llistar les tres llistes
	 */
	public void printCarret() {
		Map<String,Integer> llista = new HashMap<>();

		//busquem els productes d'alimentació amb el mateix codi de barres
		for(Alimentacio a : llista_ali) {
			if(!llista.containsKey(a.getCodibarres())) 	llista.put(a.getCodibarres(),1);
			else llista.put(a.getCodibarres(),llista.get(a.getCodibarres()) + 1);
		}
		llista.forEach((k,v)-> System.out.println(getNomProducte(k) + " -> " + (Integer) v));
		llista.clear(); //netejar map perquè es fa servir en la següent cerca

		//busquem els productes tèxtils amb el mateix codi de barres
		for(Textil a : llista_textil) {
			if(!llista.containsKey(a.getCodibarres())) llista.put(a.getCodibarres(),1);
			else llista.put(a.getCodibarres(),llista.get(a.getCodibarres()) + 1);
		}
		llista.forEach((k,v)-> System.out.println(getNomProducte(k) + " -> " + (Integer) v));
		llista.clear(); //netejar map perquè es fa servir en la següent cerca

		//busquem els productes d'electrònica amb el mateix codi de barres
		for(Electronica a : llista_elec) {
			if(!llista.containsKey(a.getCodibarres())) llista.put(a.getCodibarres(),1);
			else llista.put(a.getCodibarres(),llista.get(a.getCodibarres()) + 1);
		}
		llista.forEach((k,v)-> System.out.println(getNomProducte(k) + " -> " + (Integer) v));

		//Recorregut del Map sense usar lambda expression
		/*for(Map.Entry entry : llista.entrySet()) {
			System.out.println(getNomProducte((String) entry.getKey()) + "-" + entry.getValue());
		}*/

	}

	/**
	 * Funcio per mostrar el import total del usuari al supermercat.
	 */
	public void passarCaixa() {
		double total = 0;
		Set<Alimentacio> ali_uniq = new HashSet<Alimentacio>(llista_ali);
		Set<Producte> elec_uniq = new HashSet<Producte>(llista_elec);
		Set<Producte> textil_uniq = new HashSet<Producte>(llista_textil);
		int freq=0;

		LocalDate data = LocalDate.now();
		System.out.println("-----------------------------");
		System.out.println(Compra.NOM_SUPERMERCAT);
		System.out.println("-----------------------------");
		System.out.println("Data: " + data.toString());
		System.out.println("-----------------------------");

		for(Producte a : ali_uniq)  {
			freq = Collections.frequency(llista_ali, a);
			System.out.println(a.getNom() + "\t\t" + freq + " " + a.getPreu() + "\t" + a.getPreu() * freq);
			total += a.getPreu()*freq;
		}

		for(Producte e: elec_uniq) {
			freq = Collections.frequency(llista_elec, e);
			System.out.println(e.getNom() + "\t\t" + freq + " " + e.getPreu() + "\t" + e.getPreu() * freq);
			total += e.getPreu()*freq;
		}

		for(Producte t: textil_uniq) {
			freq = Collections.frequency(llista_textil, t);
			System.out.println(t.getNom() + "\t\t" + freq + " " + t.getPreu() + "\t" + t.getPreu() * freq);
			total += t.getPreu()*freq;
		}
		System.out.println("-----------------------------");
		System.out.format("Total: %.3f%n%n", total);

		//buidar llistes
		llista_ali.clear();
		llista_elec.clear();
		llista_textil.clear();
	}

	/**
	 * Funcio que ens retornara la data que toca amb el format que toca.
	 * @return Ens retorna una variable de tipus LocalDate.
	 */
	private LocalDate readDate() {
		LocalDate d = null;
		boolean dateOK = false;

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyy");
		while(!dateOK) {
			try {
				d = LocalDate.parse(sc.nextLine(), format);
				dateOK = true;
			} catch (DateTimeException e) {
				System.out.print("Torna a entrar la data: ");
				dateOK = false;
			}
		}
		return d;
	}

	/**
	 * Funcio que ens permetra obtindre el nom del producte segons el codiib.
	 * @param codib Es una variable de tipus Stirng.
	 * @return Ens retornara una variable de tipus Stirng.
	 */
	private String getNomProducte(String codib) {
		//Mirem a les tres llistes
		List<Producte> list = llista_ali.stream().filter(o -> o.getCodibarres().equals(codib)).distinct().collect(Collectors.toList());
		if(list.size()==0) list = llista_textil.stream().filter(o -> o.getCodibarres().equals(codib)).distinct().collect(Collectors.toList());
		if(list.size()==0) list = llista_elec.stream().filter(o -> o.getCodibarres().equals(codib)).distinct().collect(Collectors.toList());
		return list.get(0).getNom();
	}

	/**
	 * Funcio per comoparar preus. Mètode a realitzar per a la versió 2.1
	 */
	public void compararPreus(){
		Compra compra = new Compra();	
	}

}

