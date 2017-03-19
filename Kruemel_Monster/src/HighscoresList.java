import java.io.Serializable;

/**
 * Created by Jonas on 18.03.2017.
 */
public class HighscoresList implements Serializable
{
    private static final long serialVerionUID = 2L;

    public Highscore[] highscores;

    HighscoresList(int listSize)
    {
        highscores = new Highscore[listSize];

        //TEMP
        highscores[0] = new Highscore(250);
        highscores[1] = new Highscore(225);
        highscores[2] = new Highscore(200);
        highscores[3] = new Highscore(175);
        highscores[4] = new Highscore(150);
        highscores[5] = new Highscore(125);
        highscores[6] = new Highscore(100);
        highscores[7] = new Highscore(75);
        highscores[8] = new Highscore(50);
        highscores[9] = new Highscore(25);
    }

    public void checkNewHighscore(String name, int points)
    {
        /**
         * checks if the score is good enough for the highscores list
         */

        for (int i = 0; i < highscores.length; i++)
        {
            if (points >= highscores[i].getPoints())
            {
                //score is higher or the same then one of the scores in the highscores list
                setNewHighscore(name, points, i+1);
                return;
            }
        }
    }

    private void setNewHighscore(String name, int points, int placeOfSmallerValue)
    {
        /**
         * Moves every highscore (the last one gets overrided) under the new highscore one place down
         * Places the new highscore in the highscores list
         */

        for (int i = highscores.length - 2; i >= placeOfSmallerValue - 1; i--)
        {
            highscores[i + 1] = highscores[i];
        }

        highscores[placeOfSmallerValue - 1] = new Highscore(name, points);
    }
}
