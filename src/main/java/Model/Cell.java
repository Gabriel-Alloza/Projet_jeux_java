package Model;

public class Cell {

    private String representation;

    /**
     *
     * @param representation
     */
    public Cell(String representation) {
        this.representation = representation; //Attribue une représentation, (un contenu), à la case
    }

    public  String getRepresentation(){
        return representation; //Premet d'afficher le contenu de la case
    }

    /**
     *
     * @param representation
     */
    public  void setRepresentation(String representation){
        this.representation = representation; //Permet de changer le contenu de la case.
    }


}
