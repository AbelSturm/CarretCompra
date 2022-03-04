/**
 * @author Abel Sturm
 * @date 04/03/2022
 * @version 1.1
 */

package com.company;

/**
 * Classe per a la creacio del productes de tipus Electronica.
 */
public class Electronica extends Producte {
	/**
	 * Variable de tipus int.
	 */
	private int dies_garantia;

	/**
	 * Constructor del producte d'Electronica amb els diferents parametres, d'aquest producte.
	 * @param preu Es una variable de tipus float.
	 * @param nom Es una variable de tipus String.
	 * @param codi Es una variable de tipus String.
	 * @param diesg Es una variable de tipus int.
	 */
	public Electronica(float preu, String nom, String codi, int diesg) {
		super(preu, nom, codi);
		dies_garantia = diesg;
	}

	/**
	 * Metode per obtindre el preu del producte, que ens retornara un float.
	 * @return Ens retornara una variable de tipus float.
	 */
	@Override
	public float getPreu() {
		float preu = super.getPreu();
		return (float) (preu + preu*(dies_garantia/365)*0.1);
	}

	/**
	 * Metode per passar el nom i el preu del producte a una unica String, que retorna uns Stirng.
	 * @return Ens retornara una variable de tipus Stirng.
	 */
	@Override
	public String toString() {
		return getNom() + "," + getPreu();
	}
	
	
	

}
