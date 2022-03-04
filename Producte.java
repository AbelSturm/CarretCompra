/**
 * @author Abel Sturm
 * @date 04/03/2022
 * @version 1.1
 */

package com.company;

/**
 * Classe per a la creacio de diferents productes.
 */
public abstract class Producte {

	/**
	 * Variable de tipus float.
	 */
	private float preu;

	/**
	 * Variable de tipus String.
	 */
	private String nom;

	/**
	 * Variable de tipus String.
	 */
	private String codibarres;

	/**
	 * Constructor del producte amb els seus parametres.
	 * @param preu Es una varaible de tipus float.
	 * @param nom Es una varaible de tipus String.
	 * @param codi Es una varaible de tipus String.
	 */
	public Producte(float preu, String nom, String codi) {
		this.preu = preu;
		this.nom = nom;
		codibarres = codi;
	}

	/**
	 * Metode per obrindre el preu del producte.
	 * @return Ens retorna una variable de tipus float.
	 */
	public float getPreu() {
		return preu;
	}

	/**
	 * Metode per posar el preu al producte.
	 * @param preu Es una varialbe de tipus float.
	 */
	public void setPreu(float preu) {
		this.preu = preu;
	}

	/**
	 * Metode per obtindre el nom del producte.
	 * @return Ens retornara una variable de tipus Stirng.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Metode per a posar-li nom al producte.
	 * @param nom Es una variable de tipus String.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Metode per obtindre el Codi de Barres.
	 * @return Ens retorna una varialbe de tipus String.
	 */
	public String getCodibarres() {
		return codibarres;
	}

	/**
	 * Metode per posar el Codi de Barres.
	 * @param codibarres Es una variable de tipus String.
	 */
	public void setCodibarres(String codibarres) {
		this.codibarres = codibarres;
	}

	/**
	 * Metode per comprobar si tenim dos productes iguals.
	 * @param obj Es una variable de tipus Object.
	 * @return Ens retorna una variable de tipius boolean.
	 */
	@Override
	public boolean equals(Object obj) {
		/*
		REFACT: He utilitzat l'Inline Code i he eliminat una variable booleana i
		en comptes de retornar la booleana es retorna true o false.
		*/
		if(obj == null) {
			return false;
		}
		else {
			Producte p = (Producte) obj;
			if (codibarres.equals(p.getCodibarres()) && getPreu() == p.getPreu()) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	/**
	 * Metode per obtindre el hasCode a partir del codi de barres.
	 * @return Ens retornara una variable de tipus int.
	 */
	@Override
	public int hashCode() {
		/*
		REFACT:He utilitzat l'Inline Code i he eliminat la variable int i en comptes de retornar aquesta variable,
		retornem directament el codi de barres amb el hasCode.
		*/
		return codibarres.hashCode();
	}
	
	
	

}
