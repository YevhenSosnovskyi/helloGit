package chess;


import org.junit.Before;
import org.junit.Test;


import static junit.framework.Assert.assertEquals;

public class CheckTest {

    private GameState gameState;

    private GameController gameController;
    private GameView gameView;






    @Before
    public void setUp(){
        gameState=new GameState();
        gameState.reset();
        gameView=new GameView(System.out);
        gameController=new GameController(gameState,gameView);
        }


    @Test
    public void testFoolsMate() throws Exception {
        String[][] foolMate = new String[][]{
                {"f2","f3"},
                {"e7","e5"},
                {"g2","g4"},
                {"d8","h4"}
        };


        for (int i = 0; i < foolMate.length; i++) {
            gameController.run ("move "+foolMate[i][0]+" "+foolMate[i][1]);
        }
        assertEquals("It must be Checkmate", gameView.getMessage(), "Checkmate!");
//        gameController.run("list");


    }

    @Test
    public void testRussianFoolsMate() throws Exception {
        String[][] foolMate = new String[][]{
                {"e2","e3"},
                {"e7","e5"},
                {"f1","c4"},
                {"d7","d6"},
                {"d1","f3"},
                {"b8","c6"},
                {"f3", "f7"}

        };


        for (int i = 0; i < foolMate.length; i++) {
            gameController.run ("move "+foolMate[i][0]+" "+foolMate[i][1]);
 //           gameController.run("list");
        }

 //       gameController.run("list");
        assertEquals("It must be Checkmate", gameView.getMessage(), "Checkmate!");


    }

    @Test
    public void testCheckKnight() throws Exception {
        String[][] knightFantasticAttack = new String[][]{
                {"b1","c3"},
                {"a7","a6"},
                {"c3","d5"},
                {"a6","a5"},
                {"d5","f6"}
        };


        for (int i = 0; i < knightFantasticAttack.length; i++) {
            gameController.run ("move "+knightFantasticAttack[i][0]+" "+knightFantasticAttack[i][1]);
        }
        assertEquals("It must be Check", gameView.getMessage(), "Check!");


    }
}