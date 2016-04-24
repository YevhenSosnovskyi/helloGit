package chess;

import chess.moves.PossibleMovesFactory;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PossibleMovesTest {

    private GameState gameState;
    private PossibleMovesFactory possibleMovesFactory;
    private String[][] movesToRichTestBoard = new String[][]{
            {"e2","e4"},
            {"d7","d6"},
            {"h2","h4"},
            {"d8","h4"}
    };
/*
Board for testing;

      a   b   c   d   e   f   g   h
    +---+---+---+---+---+---+---+---+
  8 | R | N | B |   | K | B | N | R | 8
    +---+---+---+---+---+---+---+---+
  7 | P | P | P | P |   | P |   | P | 7
    +---+---+---+---+---+---+---+---+
  6 |   |   |   |   | P |   |   |   | 6
    +---+---+---+---+---+---+---+---+
  5 |   |   |   |   |   |   |   |   | 5
    +---+---+---+---+---+---+---+---+
  4 |   |   |   |   | p |   |   | Q | 4
    +---+---+---+---+---+---+---+---+
  3 |   |   |   |   |   |   |   |   | 3
    +---+---+---+---+---+---+---+---+
  2 | p | p | p | p |   | p | p |   | 2
    +---+---+---+---+---+---+---+---+
  1 | r | n | b | q | k | b | n | r | 1
    +---+---+---+---+---+---+---+---+
      a   b   c   d   e   f   g   h
*/


    @Before
    public void setUp(){
        possibleMovesFactory=new PossibleMovesFactory();
        gameState=new GameState();
        gameState.reset();
        for(int i=0;i<movesToRichTestBoard.length;i++) {
            gameState.move(new Move(new Position(movesToRichTestBoard[i][0]), new Position(movesToRichTestBoard[i][1])));
            gameState.switchCurrentPlayer();
        }

    }
    @Test
    public void testBehaviour() throws Exception {

        assertEquals("2 possible moves from b2", possibleMovesFactory.getPossibleMoves(new Position("b2"),gameState, false).size(),2);
        assertEquals("2 possible moves from c2", possibleMovesFactory.getPossibleMoves(new Position("c2"),gameState, false).size(),2);
        assertEquals("2 possible moves from d2", possibleMovesFactory.getPossibleMoves(new Position("d2"),gameState, false).size(),2);
        assertEquals("1 possible moves from e2", possibleMovesFactory.getPossibleMoves(new Position("e4"),gameState, false).size(),1);
        assertEquals("2 possible moves from f2", possibleMovesFactory.getPossibleMoves(new Position("f2"),gameState, false).size(),2);
        assertEquals("2 possible moves from g2", possibleMovesFactory.getPossibleMoves(new Position("g2"),gameState, false).size(),2);

        assertEquals("0 possible moves from a1", possibleMovesFactory.getPossibleMoves(new Position("a1"),gameState, false).size(),0);
        assertEquals("2 possible moves from b1", possibleMovesFactory.getPossibleMoves(new Position("b1"),gameState, false).size(),2);
        assertEquals("0 possible moves from c1", possibleMovesFactory.getPossibleMoves(new Position("c1"),gameState, false).size(),0);
        assertEquals("4 possible moves from d1", possibleMovesFactory.getPossibleMoves(new Position("d1"),gameState, false).size(),4);
        assertEquals("1 possible moves from e1", possibleMovesFactory.getPossibleMoves(new Position("e1"),gameState, false).size(),1);
        assertEquals("5 possible moves from f1", possibleMovesFactory.getPossibleMoves(new Position("f1"),gameState, false).size(),5);
        assertEquals("1 possible moves from g1", possibleMovesFactory.getPossibleMoves(new Position("g1"),gameState, false).size(),3);
        assertEquals("1 possible moves from h1", possibleMovesFactory.getPossibleMoves(new Position("h1"),gameState, false).size(),3);
    }

    @Test
    public void testBehaviourMyKingSafe() throws Exception {

        assertEquals("2 possible moves from a2", possibleMovesFactory.getPossibleMoves(new Position("a2"),gameState, true).size(),2);
       assertEquals("2 possible moves from b2", possibleMovesFactory.getPossibleMoves(new Position("b2"),gameState, true).size(),2);
        assertEquals("2 possible moves from c2", possibleMovesFactory.getPossibleMoves(new Position("c2"),gameState, true).size(),2);
       assertEquals("2 possible moves from d2", possibleMovesFactory.getPossibleMoves(new Position("d2"),gameState, true).size(),2);
        assertEquals("1 possible moves from e2", possibleMovesFactory.getPossibleMoves(new Position("e4"),gameState, true).size(),1);
        assertEquals("0 possible moves from f2", possibleMovesFactory.getPossibleMoves(new Position("f2"),gameState, true).size(),0);
        assertEquals("2 possible moves from g2", possibleMovesFactory.getPossibleMoves(new Position("g2"),gameState, true).size(),2);

        assertEquals("0 possible moves from a1", possibleMovesFactory.getPossibleMoves(new Position("a1"),gameState, true).size(),0);
        assertEquals("2 possible moves from b1", possibleMovesFactory.getPossibleMoves(new Position("b1"),gameState, true).size(),2);
        assertEquals("0 possible moves from c1", possibleMovesFactory.getPossibleMoves(new Position("c1"),gameState, true).size(),0);
        assertEquals("4 possible moves from d1", possibleMovesFactory.getPossibleMoves(new Position("d1"),gameState, true).size(),4);
        assertEquals("1 possible moves from e1", possibleMovesFactory.getPossibleMoves(new Position("e1"),gameState, true).size(),1);
        assertEquals("5 possible moves from f1", possibleMovesFactory.getPossibleMoves(new Position("f1"),gameState, true).size(),5);
        assertEquals("1 possible moves from g1", possibleMovesFactory.getPossibleMoves(new Position("g1"),gameState, true).size(),3);
        assertEquals("1 possible moves from h1", possibleMovesFactory.getPossibleMoves(new Position("h1"),gameState, true).size(),3);
    }

}
