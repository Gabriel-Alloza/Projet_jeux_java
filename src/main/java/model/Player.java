package model;

public class Player {

    private String representation;

    /**
     * Constructeur de la classe
     * @param representation Le symbole du joueur.
     */
    public Player(String representation){
        if(representation == null || representation.isBlank()){
            throw new IllegalArgumentException("Le signe ne peut pas être vide");
        }
        this.representation = representation; //Attribue une representation (un symbole) au joueur
    }

    /**
     * Renvoie la représentation, (le symbole) du joueur
     * @return le symbole du joueur
     */

    public String getRepresentation(){
        return this.representation;
    }

}
