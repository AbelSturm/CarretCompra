/**
 * @author Abel Sturm
 * @date 04/03/2022
 * @version 1.1
 */

package com.company;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe per a la creacio del productes de tipus Alimentacio.
 */
public class Alimentacio extends Producte {

	/**
	 * Variable de tipus LocalDate
	 */
	private LocalDate d;

	/**
	 * Constructor del producte d'Alimentacio amb els diferents parametres, d'aquest producte.
	 * @param preu Es una variable de tipus float.
	 * @param nom Es una variable de tipus String.
	 * @param codi Es una variable de tipus String.
	 * @param datac Es una variable de tipus LocalDate.
	 */
	public Alimentacio(float preu, String nom, String codi, LocalDate datac) {
		super(preu, nom, codi);
		d = datac; //obtenim la data de caducitat
	}

	/**
	 * Metode per obtindre el preu del producte, que ens retornara un float.
	 */
	@Override
	public float getPreu() {
		/*
		REFACT: He utilitzat l'Inline Code i en comptes de tornar a calcular el preu, fem un return del preu amb els
		calculs oportuns.
		*/
		float preu = super.getPreu();
		long dif;
		dif = ChronoUnit.DAYS.between(d,LocalDate.now());

		//System.out.println("preu:" + preu);
		return preu - (float) (preu*(1/(dif+1)) + (preu*(0.1)));
	}


	/**
	 * Metode per passar el nom i el preu del producte a una unica String, que retorna uns Stirng.
	 */
	@Override
	public String toString() {
		return new String(getNom() + " " + getPreu());
	}
	


}
