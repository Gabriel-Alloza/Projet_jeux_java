import Model.Player;
import Model.Puissance4;
import Model.TicTacToe;
import View.View;
import View.InteractionUtilisateur;

public class Main {
    public static void main(String[] args) {
        InteractionUtilisateur interaction = new InteractionUtilisateur();
        View view = new View();

        //Attribue un signe choisit par l'utilisateur au player 1
        view.j1();
        String representation1 = interaction.inputsymbol();
        Player player1 = new Player(representation1);

        //Même chose pour le player2 (ui pourra ou non être artificiel)
        view.j2();
        String representation2 = interaction.inputsymbol();
        Player player2 = new Player(representation2);

        //Lace un jeu de puissance4 4.
        Puissance4 puissance4 = new Puissance4(6, 7,player1, player2);
        puissance4.play(player1, player2);

        //Lance un jeu de tictactoe
        TicTacToe ticTacToe = new TicTacToe(3, player1, player2);
        ticTacToe.play();
    }
}
