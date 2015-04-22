package ua.ap.animal;

public class Cat {
    private String name;
    private double weight;
    private double levelOfSatisfy;

    Cat(String name, double  weight, double  levelOfSatisfy){
        this.name               = name;
        this.weight             = weight;
        this.levelOfSatisfy     = levelOfSatisfy;
    }
    Cat(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLevelOfSatisfy() {
        return levelOfSatisfy;
    }

    public void setLevelOfSatisfy(int levelOfSatisfy) {
        this.levelOfSatisfy = levelOfSatisfy;
    }


    //feed cat
    public void FeedCat(String kindOfFood, double weightOfFood){

        if (kindOfFood.compareToIgnoreCase("MILK") == 0) {
            weight += (double) 3/100*weightOfFood;
            levelOfSatisfy += 2.3;
        }
        else if (kindOfFood.compareToIgnoreCase("MEAT") == 0) {
            weight += (double) 15.3/100*weightOfFood;
            levelOfSatisfy += 5.1;
        }
        else weight += 0.01;

    }

    public void print(){
        System.out.println("I'm a cat....");
        System.out.println("My name is: " + name);
        System.out.println("My weight is: " + weight);
        if (levelOfSatisfy >= 30)
            System.out.println("Life is beautiful!");
        else if (levelOfSatisfy >= 10 && levelOfSatisfy < 30 )
            System.out.println("I.m ok!");
        else if (levelOfSatisfy >= 5 && levelOfSatisfy < 10 )
            System.out.println("Life is crappy!");
        else if (levelOfSatisfy >= 0 && levelOfSatisfy < 5 )
            System.out.println("Hey you! Are you kidding me?");
    }
}
