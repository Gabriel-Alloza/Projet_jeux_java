package Model;

public class Cell {

    private String representation;

    /**
     *
     * @param representation
     *
     * Constructueur de la classe
     */
    public Cell(String representation) {
        this.representation = representation; //Attribue une représentation, (un contenu), à la case
    }

    /**
     * Affiche le contenu de la case
     * @return
     */
    public  String getRepresentation(){
        return representation;
    }

    /**
     *
     * @param representation
     *
     * Permet de changer le contenu de la case.
     */
    public  void setRepresentation(String representation){
        this.representation = representation;
    }


}
