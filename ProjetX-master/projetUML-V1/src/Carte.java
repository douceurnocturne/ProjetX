import java.util.Dictionary;

public class Carte {

	private Dictionary base_de_donnee_im;
	private Dictionary base_de_donnee_lieu;
	private Dictionary base_de_donnee_fav;

	public Carte(){

	}

	public void Zoom(){

	}
	public void Ajouter_Image(Image i){

	}
	public void Supprimer_image(Image i){

	}
	public void Modifier_image(Image i){

	}
	public void Rechercher_image(String s){

	}
	public void Rechercher_localisation(String s){

	}
	public void Afficher(){

	}
	public void Fermer(){

	}
	public void reinitialiser_carte(){

	}
	public void Centrer(double gps){

	}
	public Dictionary GetBDimage(){
		return this.base_de_donnee_im;

	}
	public Dictionary GetBDlocalisation(){
		return this.base_de_donnee_lieu;

	}
	public Dictionary GetBDfavori(){
		return this.base_de_donnee_fav;

	}
	
}
