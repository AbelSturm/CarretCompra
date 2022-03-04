/**
 * @author Abel Sturm
 * @date 04/03/2022
 * @version 1.1
 */

package com.company;

/**
 * Classe per a la creacio del productes de tipus Textil.
 */
public class Textil extends Producte {
	/**
	 * Variable de tipus String.
	 */
	private String composicio;

	/**
	 * Variable de tipus String.
	 */
	private String codificacio;

	/**
	 * Constructor del producte d'Electronica amb els diferents parametres, d'aquest producte.
	 * @param preu Es una variable de tipus float.
	 * @param nom Es una variable de tipus String.
	 * @param codi Es una variable de tipus String.
	 * @param compo Es una variable de tipus String.
	 */
	public Textil(float preu, String nom, String codi, String compo) {
		super(preu, nom, codi);
		composicio = compo;
		codificacio = preu + codi;
	}

	/**
	 * Metode per obtindre la composico del producte.
	 * @return Ens retorna una variable de tipus Stirng.
	 */
	public String getComposicio() {
		return composicio;
	}

	/**
	 * Metode per posar la composico del producte.
	 * @param composicio Es una variable de tipus String.
	 */
	public void setComposicio(String composicio) {
		this.composicio = composicio;
	}

	/**
	 * Metode per passar el nom i el preu del producte a una unica String, que retorna uns Stirng.
	 * @return Ens retornara una variable de tipus Stirng.
	 */
	@Override
	public String toString() {
		/*
		REFACT: He utilitzat el metode de Substitució d'algoritme, crec i he eliminat la part de codi redundant,
		en comptes de retornar "new Stirng(....)" retornem només el nom i preu.
		*/
		return getNom() + " " + getPreu();
	}

	/**
	 * Metode per obtindre el codi, aquesta funció no s'està usant.
	 * @return Ens retorna una variable de tipus Stirng.
	 */
	public String getCode (){
		return codificacio;
	}

}
