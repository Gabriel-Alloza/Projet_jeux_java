import Model.Player;
import Model.Puissance4;
import Model.TicTacToe;
import View.View;
import View.InteractionUtilisateur;

public class Main {
    public static void main(String[] args) {
        InteractionUtilisateur interaction = new InteractionUtilisateur();
        View view = new View();
        view.j1();
        String representation1 = interaction.Inputsymbol();
        Player player1 = new Player(representation1);
        view.j2();
        String representation2 = interaction.Inputsymbol();
        Player player2 = new Player(representation2);

        TicTacToe ticTacToe = new TicTacToe(3, player1, player2);
        Puissance4 puissance4 = new Puissance4(6, 7,player1, player2);

        puissance4.play(player1, player2);
        ticTacToe.play();
    }
}
