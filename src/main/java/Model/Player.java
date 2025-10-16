package Model;

public class Player {

    private String representation;

    public Player(String representation){
        this.representation = representation; //Attribue une representation (un symbole) au joueur
    }

    public String getRepresentation(){
        return this.representation; //Renvoie la représentation du joueur
    }

}
