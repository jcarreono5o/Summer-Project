import java.util.Objects;
//keep track of previous station
public class Lines
{
    public final int station;
    public final String line;

    public Lines(int station, String line)
    {
        this.station = station;
        this.line = line;
    }

    public boolean equals(Object other)
    {
        if (this == other) return true;
        if (!(other instanceof Lines)) return false;
        Lines stationLine = (Lines) other;
        return station == stationLine.station && Objects.equals(line, stationLine.line);
    }
    public int hashCode() {
        return Objects.hash(station, line);
    }
    //any lines of same value have same hash code
}
