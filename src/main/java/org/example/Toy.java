package org.example;

import java.util.Objects;

public class Toy implements Comparable<Toy>{

    private int toyId;
    private String toyTitle;
    private int toyVictoryFrequensy;

    public Toy(int toyId,String toyTitle,int toyVictoryFrequensy){
        this.toyId = toyId;
        this.toyTitle = toyTitle;
        this.toyVictoryFrequensy = toyVictoryFrequensy;

    }

    public int getToyId(){
        return toyId;
    }

    public String getToyTitle() {
        return toyTitle;
    }

    public int getToyVictoryFrequensy() {
        return toyVictoryFrequensy;
    }

    public void setToyVictoryFrequensy(int toyVictoryFrequensy) {
        this.toyVictoryFrequensy = toyVictoryFrequensy;
    }
    public String getInfo(){
        return String.format("ID: %d, Title: %s", toyId, toyTitle);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Toy toy = (Toy) o;
        return toyTitle.equals(toy.toyTitle);

    }

    @Override
    public int hashCode() {
        return Objects.hash(toyTitle);
    }



    @Override
    public int compareTo(Toy o) {
        return Integer.compare(this.toyVictoryFrequensy, o.toyVictoryFrequensy);
    }
}

