import javax.swing.*;
import java.io.*;

/**
 * Created by Jonas on 18.03.2017.
 */
public class Main
{
    static PlayerNames playerNames;
    static HighscoresList highscoresList;

    public static void main(String[] args)
    {

        File playerNamesFile = new File("playerNames.dat");
        if (playerNamesFile.exists() && !playerNamesFile.isDirectory())
            playerNames = (PlayerNames) Main.deserialize("playerNames.dat");
        else
            playerNames = new PlayerNames(10);

        File highscoresListFile = new File("highscoresList.dat");
        if (highscoresListFile.exists() && !highscoresListFile.isDirectory())
            highscoresList = (HighscoresList) Main.deserialize("highscoresList.dat");
        else
            highscoresList = new HighscoresList(10);
        /*
        playerNames = new PlayerNames(10);
        highscoresList = new HighscoresList(10);
        */
        String name = JOptionPane.showInputDialog("Geben Sie ihren Namen ein: ");
        playerNames.newPlayerName(name);
        Main.serialize(playerNames, "playerNames.dat");
        int points = Integer.MAX_VALUE;
        while (points == Integer.MAX_VALUE) {
            try {
                points = 0;
                points = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie ihre Punktzahl ein: "));
            } catch (NumberFormatException e) {
                points = Integer.MAX_VALUE;
            }
        }
        highscoresList.checkNewHighscore(name, points);
        Main.serialize(highscoresList, "highscoresList.dat");

        System.out.println("Player names: ");
        for (String i : playerNames.names)
        {
            System.out.println(i);
        }

        System.out.println("\nHighscores: ");
        for (Highscore i : highscoresList.highscores)
        {
            System.out.println(i);
        }
    }


    private static void serialize(Serializable objectToSerialize, String serializationFileName) {

        //Opens the stream where the data will be put
        ObjectOutputStream oos = null;
        try
        {
            FileOutputStream fos = new FileOutputStream(serializationFileName);

            //ObjectOutputStream is the stream used to serialize the object
            oos = new ObjectOutputStream(fos);
            oos.writeObject(objectToSerialize);
            oos.flush();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (oos != null)
            {
                try
                {
                    oos.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Serializable deserialize(String serializationFileName) {
        Serializable deserializedInstance = null;
        ObjectInputStream ois = null;
        try
        {
            FileInputStream fis = new FileInputStream(serializationFileName);

            //ObjectInputStream is the stream used to deserialize the object
            ois = new ObjectInputStream(fis);

            deserializedInstance = (Serializable) ois.readObject();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } finally
        {
            if(ois != null)
            {
                try
                {
                    ois.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return deserializedInstance;
    }

}
