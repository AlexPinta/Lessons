package ua.ap.Homework3;

/**
 * @author  Alex Pinta
 * @version  %I%, %G%
 */
public class Group {

    private Students[] groupOfStudents = new Students[10];

    public boolean add(Students students){
        try {
            for (int i = 0; i < groupOfStudents.length; i++){
                if (groupOfStudents[i] == null) {
                    groupOfStudents[i] = students;
                    return true;
                }
            }
            throw new MyThrow(MyThrow.ExceptionOperation.ADD);
        } catch (MyThrow e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("Any problem!");
        }
        return false;
    }

    public boolean remove(int index) {
        try {
            try {
                groupOfStudents[index] = null;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new MyThrow(MyThrow.ExceptionOperation.REMOVE);
            }
        } catch (MyThrow e) {
            System.out.println(e.toString());
            return false;
        } catch (Exception e) {
            System.out.println("Any problem!");
        }
        return true;
    }

    public Students findByName(String name){
        name = name.toLowerCase();

        for (int i = 0; i < groupOfStudents.length; i++) {
            try {
                if (name.equalsIgnoreCase(groupOfStudents[i].getName().toLowerCase())== true) {
                    return groupOfStudents[i];
                }
            } catch (NullPointerException e) {
                continue;
            }

        }

        return null;
    }

    public void printInfo(){
        for (int i = 0; i < groupOfStudents.length; i++) {
            try {
                System.out.println((i+1) + ": " + groupOfStudents[i].printInfo());
            } catch (NullPointerException e) {

            }
        }
        System.out.println("");
    }
}
