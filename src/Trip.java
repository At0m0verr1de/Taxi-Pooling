public class Trip {
    private String ID;
    private String destination;
    private String origin;
    private String date;
    private String time;

    public Trip(String destination, String origin, String date, String time) {
        this.destination = destination;
        this.origin = origin;
        this.date = date;
        this.time = time;

        intialize();
    }

    private void intialize() {
        this.ID = Double.toString(Math.random() * 100) + date;
    }

    public String getID() {
        return ID;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

}