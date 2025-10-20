package model;

public class Cell {

    private String representation;

    /**
     * Constructueur de la classe
     * @param representation Contenu visuel de la case
     *
     */
    public Cell(String representation) {
        if(representation == null){
            throw new IllegalArgumentException("La case ne peut pas rien contenir");
        }
        this.representation = representation; //Attribue une représentation, (un contenu), à la case
    }

    /**
     * Affiche le contenu de la case
     * @return Le contenu de la case
     */
    public  String getRepresentation(){
        return representation;
    }

    /**
     * Permet de changer le contenu de la case.
     * @param representation Une chaîne de caractères sensée être le nouveau contenu de la case.
     *
     */
    public  void setRepresentation(String representation){
        this.representation = representation;
    }


}
