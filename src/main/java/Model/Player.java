package Model;

public class Player {

    private String representation;

    /**
     * Constructeur de la classe
     * @param representation
     */
    public Player(String representation){
        if(representation == null || representation.isBlank()){
            throw new IllegalArgumentException("Le signe ne peut pas être vide");
        }
        this.representation = representation; //Attribue une representation (un symbole) au joueur
    }

    /**
     * Renvoie la représentation, (le symbole) du joueur
     * @return
     */

    public String getRepresentation(){
        return this.representation;
    }

}
