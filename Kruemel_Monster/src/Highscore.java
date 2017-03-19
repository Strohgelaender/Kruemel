import java.io.Serializable;

/**
 * Created by Jonas on 18.03.2017.
 */
public class Highscore implements Serializable
{
    private static final long serialVerionUID = 3L;

    String name;
    int points;

    Highscore() {
        name = "---";
        points = 0;
    }

    Highscore(int points)
    {
        name = "Jonas";
        this.points = points;
    }

    Highscore(String name, int points) {
        this.name = name;
        this.points = points;
    }

    void setName(String name) { this.name = name; }
    void setPoints(int points) { this.points = points; }

    String getName()
    {
        return name;
    }
    int getPoints() { return points; }

    @Override
    public String toString()
    {
        return "name: " + name + "; points: " + points;
    }
}
