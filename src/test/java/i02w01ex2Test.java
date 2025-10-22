import edu.io.Board;
import edu.io.Game;
import edu.io.Player;
import edu.io.token.GoldToken;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class i02w01ex2Test {
    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        Game game = new Game();
        Player player = new Player();
        game.join(player);
        board.placeToken(4, 4, new GoldToken());
    }

    @Test
    void getAvailableSquare_defaultStrategy_works() {
        board.getAvailableSquare(Board.PlacementStrategy.FIRST_AVAILABLE);
        Assertions.assertInstanceOf(Board.Coords.class, board.getAvailableSquare(Board.PlacementStrategy.FIRST_AVAILABLE));
    }

    @Test
    void getAvailableSquare_firstAvailable_shouldReturnFirstSquare() {
        board.getAvailableSquare(Board.PlacementStrategy.FIRST_AVAILABLE);
        Assertions.assertEquals(new Board.Coords(0, 0), board.getAvailableSquare(Board.PlacementStrategy.FIRST_AVAILABLE));
    }

    @Test
    void getAvailableSquare_random_shouldReturnRandomSquare() {
        board.getAvailableSquare(Board.PlacementStrategy.RANDOM);
        Assertions.assertInstanceOf(Board.Coords.class, board.getAvailableSquare(Board.PlacementStrategy.RANDOM));
    }

    @Test
    void getAvailableSquare_defaultStrategy_whenFieldIsFull_shouldThrowException() {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                board.placeToken(i, j, new GoldToken());
            }
        }
        Assertions.assertThrows(IllegalStateException.class, () -> board.getAvailableSquare(Board.PlacementStrategy.FIRST_AVAILABLE));
    }

    @Test
    void getAvailableSquare_randomStrategy_whenFieldIsFull_shouldThrowException() {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                board.placeToken(i, j, new GoldToken());
            }
        }
        Assertions.assertThrows(IllegalStateException.class, () -> board.getAvailableSquare(Board.PlacementStrategy.RANDOM));
    }
}
