package ua.ap.Homework3;

/**
 * @author  Alex Pinta
 * @version  %I%, %G%
 */
public class Main {
    public static void main(String args[]){

        Group newGroup = new Group();

        newGroup.add(new Students("MasHa", "Ivanova", 'f', 16, 1));
        newGroup.add(new Students("Dasha", "Ivanova", 'f', 17, 1));
        newGroup.add(new Students("Sergey", "Ivanov", 'm', 19, 1));
        newGroup.add(new Students("Mike", "Ivanov", 'm', 17, 1));
        newGroup.add(new Students("Vova", "Sidorov", 'm', 20, 1));

        newGroup.add(new Students("NatASHA", "Petrova", 'f', 17, 1));
        newGroup.add(new Students("NatAShA", "Ivanova", 'f', 17, 1));
        newGroup.add(new Students("Kirril", "Evstratov", 'm', 16, 1));
        newGroup.add(new Students("Ivan", "Yushkevich", 'm', 18, 1));
        newGroup.add(new Students("Petro", "Poroshenko", 'm', 17, 1));

        newGroup.add(new Students("test", "test", 'm', 17, 1));

        newGroup.printInfo();

        newGroup.remove(0);
        newGroup.remove(7);
        newGroup.remove(10);

        newGroup.printInfo();

        Students studentInGroup = newGroup.findByName("VOVA");
        if (studentInGroup != null) {
            System.out.println("The student was found!");
            System.out.println(studentInGroup.printInfo());
        } else {
            System.out.println("The student VOVA wasn't found!");
        }
    }
}
