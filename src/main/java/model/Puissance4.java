package model;
import controller.GameController;

public class Puissance4 {

    private int size;
    private int longueur;
    private Cell[][] cells;
    private Player player1;
    private Player player2;

    /**
     * Constructueur de la classe
     * @param size largeur du tableau
     * @param longueur longueur du tableau
     * @param player1 Premier jouer à ouer
     * @param player2 deuxième joueur à jouer.
     *
     */

    public Puissance4(Integer size, Integer longueur, Player player1, Player player2){
        if(longueur == null || longueur < 0){
            throw new IllegalArgumentException("La longueur du tableau doit être un entier positif.");
        }
        if(size == null || size < 0){
            throw new IllegalArgumentException("La largeur du tableau doit être un entier positif.");
        }

        if(player1.getRepresentation() == null || player1.getRepresentation().isBlank()){
            throw new IllegalArgumentException("Les joueurs doivent avoir un signe");
        }
        if(player2.getRepresentation() == null || player2.getRepresentation().isBlank()){
            throw new IllegalArgumentException("Les joueurs doivent avoir un signe");
        }

        this.player1 = player1;
        this.player2 = player2;
        this.size = size; //largeur
        this.longueur = longueur;

        //Remplissage du tableau
        this.cells = new Cell[this.size][this.longueur];
        for(int i = 0; i < this.size; i++){
            for(int j=0; j < this.longueur; j++){
                this.cells[i][j] = new Cell("   ");
            }
        }
    }

    /**
     * Affiche le tableau
     */

    public void displayBoard(){
        GameController gameController = new GameController();
        gameController.displayBoard(this.size, this.cells, this.longueur);
    }

    /**
     * Teste si une condition de victoire a été atteinte
     * @return true si une condition de victoire est vraie, false sinon.
     */

    public boolean hasWon(){

        //colones
        //Pour chaque colonne, on va de 0 à 2 et on compare les 4 prochaines cases, (2+4=6 donc on ne va pas plus loin)
        for(int col = 0; col<7; col++){
            for(int row = 0; row < 3; row ++){
                if(!this.cells[row][col].getRepresentation().equals("   ")){
                    if(this.cells[row][col].getRepresentation().equals(this.cells[row + 1][col].getRepresentation())){
                        if(this.cells[row + 1][col].getRepresentation().equals(this.cells[row + 2][col].getRepresentation())){
                            if(this.cells[row + 2][col].getRepresentation().equals(this.cells[row + 3][col].getRepresentation())){
                                return true;
                            }
                        }
                    }
                }
            }
        }

        //lignes
        //même principe que pour les colonnes, on s'arrête à 3 car les lignes font 7 cases et pas 6.
        for(int row = 0; row < 6; row ++){
            for(int col = 0; col < 4; col ++){
                if(!this.cells[row][col].getRepresentation().equals("   ")){
                    if(this.cells[row][col].getRepresentation().equals(this.cells[row][col + 1].getRepresentation())){
                        if(this.cells[row][col + 1].getRepresentation().equals(this.cells[row][col + 2].getRepresentation())){
                            if(this.cells[row][col + 2].getRepresentation().equals(this.cells[row][col + 3].getRepresentation())){
                                return true;
                            }
                        }
                    }
                }
            }
        }

        //diagonales descendantes
        //même principe que précédemment, comme il s'agit de diagonales déscendantes, on regarde les colonnes suivantes, (col+1, col+2)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                if (!cells[row][col].getRepresentation().equals("   ")) {
                    if (cells[row][col].getRepresentation().equals(cells[row + 1][col + 1].getRepresentation()) &&
                            cells[row + 1][col + 1].getRepresentation().equals(cells[row + 2][col + 2].getRepresentation()) &&
                            cells[row + 2][col + 2].getRepresentation().equals(cells[row + 3][col + 3].getRepresentation())) {
                        return true;
                    }
                }
            }
        }

        //diagonales montantes
        //même principe qu'avant, on bouge sur les lignes précedentes (row-1/row-2) car les diagonales sont dans l'autre sens.
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (!cells[row][col].getRepresentation().equals("   ")) {
                    if (cells[row][col].getRepresentation().equals(cells[row - 1][col + 1].getRepresentation()) &&
                            cells[row - 1][col + 1].getRepresentation().equals(cells[row - 2][col + 2].getRepresentation()) &&
                            cells[row - 2][col + 2].getRepresentation().equals(cells[row - 3][col + 3].getRepresentation())) {
                        return true;
                    }
                }
            }
        }
        return false; //return false si aucune condition possible de victoire n'a été atteinte.
    }

    /**
     *Fait tourner le jeu
     * @param player1 Le premier joueur qui joue
     * @param player2 Le deuxième joueur qui joue.
     *
     */
    public void play(Player player1, Player player2){
        GameController gameController = new GameController();

        /*
        le code suivant alterne entre le premier et le deuxième joueur,
        pour commencer par le premier joueur on donne donc player2 au currentPlayer car le code va l'inverser ensuite.
         */
        Player currentPlayer = player2;
        boolean hasWon = hasWon(); //teste l'état du jeu

        boolean inputError = false; //teste une erreur d'input utilisateur, on met false par défaut.
        while(!hasWon){ //boucle du jeu, s'arrête quand un joueur gagne
            hasWon = hasWon(); //prise en compte du nouvel état du jeu au début dela boucle

            if(!inputError){ //passe d'un joueur à l'autre si l'input utilisateur est bon
                if(currentPlayer == player1){
                    currentPlayer = player2;
                }
                else {
                    currentPlayer = player1;
                }
            }

            inputError = false; //remet input error sur false pour éviter une boucle infinie en cas de mauvaise entrée.
            displayBoard(); //affichage du tableau
            gameController.choixP4(); //choix donné au joueur
            int playerChoice = gameController.inputInteger(); //récupération de l'input du joueur
            if(playerChoice<0 || playerChoice > 6){ //contrôle que la saisie est bonne, et affiche un message d'erreur sinon
                gameController.mauvaiseSaisie();
                inputError = true;
            }
            else
            {
                for (int row = 5; row >= 0; row--) { //Vérifie depuis le bas quelle est la case la plus haute qui n'est pas encore remplie pour y mettre le symbole du joueur.
                    String last = cells[row][playerChoice].getRepresentation();
                    if(last.equals("   ")){
                        cells[row][playerChoice].setRepresentation(currentPlayer.getRepresentation());
                        hasWon = hasWon();
                        break; //On arrête la boucle lorsque la bonne case est atteinte.
                    }
                }
            }
        }
    }
}
