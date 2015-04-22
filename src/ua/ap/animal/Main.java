package ua.ap.animal;

public class Main {

    public static void main(String[] args){

        Cat firstCat = new Cat("Billy", 1.0, 25.0);

        Cat secondCat = new Cat("Sparky", 1.8, 15);

        firstCat.print();
        secondCat.print();

        firstCat.FeedCat("meat", 3);
        firstCat.FeedCat("meat", 4);
        firstCat.FeedCat("milk", 1);
        secondCat.FeedCat("mILk", 3);
        secondCat.FeedCat("meat", 2);

        firstCat.print();
        secondCat.print();

    }
}
