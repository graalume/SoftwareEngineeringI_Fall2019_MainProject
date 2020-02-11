package models;
//import ninja.NinjaDocTester;
import org.junit.Test;
import static org.junit.Assert.*;

public class testStat{
        @Test
        public  void    testScoreNum(){
            Stat testedScore = new Stat();
            testedScore.setScore(testedScore.score + 1);    //Test for set score
            assertEquals(1, testedScore.score);

        }

        @Test
        public void     testReturnScore(){
            Stat testedScore = new Stat();
            testedScore.setScore(testedScore.score + 1);    //Test for getScore
            testedScore.getScore();
            assertEquals(1, testedScore.getScore());
        }

        @Test
        public void     testReturnWin(){                    //Test for getWin
            Stat testedScore = new Stat();
            testedScore.getWin();
            assertEquals(false, testedScore.getWin());      //is_win is set to false by default

        }

        @Test
        public void     testSetWin(){                       //Test for setWin
            Stat testedScore = new Stat();
            testedScore.setWin(testedScore.is_win = true);
            assertEquals(true, testedScore.is_win);

        }

        @Test
        public void     testGetLose(){                        //Test for getLose
            Stat  testedScore = new Stat();
            testedScore.getLose();
            assertEquals(false, testedScore.getLose());         //is_lose is set to false by default

        }

        @Test
        public void     testSetLose(){                      //Test for setLose
            Stat  testedScore = new Stat();
            testedScore.setLose(testedScore.is_lose = true);
            assertEquals(true, testedScore.is_lose);

        }

        @Test
        public void     testGetNoMove(){                    //Test for getNoMove
            Stat    testedScore = new Stat();
            testedScore.getnoMove();
            assertEquals(false, testedScore.getnoMove());   //getNomove is set to false by default
        }

        @Test
        public void     testSetNoMove(){                    //Test for setNoMove
            Stat    testedScore = new Stat();
            testedScore.setnoMove(testedScore.noMove = true);
            assertEquals(true, testedScore.noMove);
        }

}
