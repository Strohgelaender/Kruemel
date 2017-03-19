import java.io.Serializable;

/**
 * Created by Jonas on 18.03.2017.
 */
public class PlayerNames implements Serializable
{
    private static final long serialVerionUID = 1L;

    public String[] names;

    PlayerNames(int listSize)
    {
        names = new String[listSize];

        for (int i = 0; i < names.length; i++)
        {
            names[i] = "---";
        }
    }

    public void newPlayerName(String name)
    {
        /**
         * Checks if the name already exsits
         * when not then it gets add to the list
         */

        boolean newName = true;

        for (int i = 0; i < names.length; i++)
        {
            //checks if there isn't already a player with the name
            if (name == names[i])
            {
                //the player name already exist
                newName = false;
            }
        }

        if (newName)
        {
            //It's a new name
            for (int i = names.length - 2; i >= 0; i--)
            {
                //write it on top of the list
                names[i + 1] = names[i];

                if (i == 0)
                {
                    names[i] = name;
                }
            }
        }
    }

}
