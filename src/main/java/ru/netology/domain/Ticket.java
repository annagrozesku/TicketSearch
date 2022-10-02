package ru.netology.domain;
public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int coast;
    protected String from;
    protected String to;
    protected int travelTime;

    public Ticket(int id, int coast, String from, String to, int travelTime) {
        this.id = id;
        this.coast = coast;
        this.from = from;
        this.to = to;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public int getCoast() {
        return coast;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.coast < o.coast) {
            return -1;
        } else if (this.coast > o.coast) {
            return 1;
        } else {
            return 0;
        }
    }
}
