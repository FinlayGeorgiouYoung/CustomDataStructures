package PriorityQueue;

public class Main {

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        PriorityQueue pqEmpty = new PriorityQueue();

//testing addtopq method
        System.out.println("Testing addtopq method:");
        System.out.println(" ");

        pq.addtopq("hi", 2);
        System.out.println("\"hi\" has been added to 'pq'");

        pq.addtopq("bye", 1);
        System.out.println("\"bye\" has been added to 'pq'");

        pq.addtopq("no", 12);
        System.out.println("\"no\" has been added to 'pq'");

        pq.addtopq("yes", 4);
        System.out.println("\"yes\" has been added to 'pq'");

        pq.addtopq("maybe", 20);
        System.out.println("\"maybe\" has been added to 'pq'");

        pq.addtopq("hello", 3);
        System.out.println("\"hello\" has been added to 'pq'");

        pq.addtopq("goodbye", 15);
        System.out.println("\"goodbye\" has been added to 'pq'");
        System.out.println(" ");

        try {
            pq.addtopq("greetings", 0);
        } catch (RuntimeException e) {
            System.out.println("\"greetings\" couldn't be added to 'pq' as the priority was out of the 1 to 20 range");
        }

        try {
            pq.addtopq("farewell", 21);
        } catch (RuntimeException e) {
            System.out.println("\"farewell\" couldn't be added to 'pq' as the priority was out of the 1 to 20 range");
        }
        System.out.println(" ");


        System.out.println("'pq' contents: " + pq.toString());
        System.out.println(" ");


//testing toString method
        System.out.println("Testing toString method: ");
        System.out.println("'pq' contents: " + pq.toString());
        System.out.println("'pqEmpty' contents: " + pqEmpty.toString());
        System.out.println(" ");


//testing front method
        System.out.println("Testing front method:");

        System.out.println("'pq' contents: " + pq.toString());
        System.out.println("'pqEmpty' contents: " + pqEmpty.toString());

        System.out.println("calling front for 'pq': \"" + pq.front() + "\" returned");
        try {
            System.out.println("calling front for 'pqEmpty': \"" + pqEmpty.front() + "\" returned");
        } catch (QueueException e) {
            System.out.println("front couldn't be called for 'pqEmpty' as it is empty");
        }
        System.out.println(" ");


//testing frontpri method
        System.out.println("Testing frontpri method: ");

        System.out.println("'pq' contents: " + pq.toString());
        System.out.println("'pqEmpty' contents: " + pqEmpty.toString());

        System.out.println("calling frontpri for 'pq': " + pq.frontpri() + " returned");
        try {
            System.out.println("calling frontpri for 'pqEmpty': " + pqEmpty.frontpri() + " returned");
        } catch (QueueException e) {
            System.out.println("frontpri couldn't be called for 'pqEmpty' as it is empty");
        }
        System.out.println(" ");


//testing deleteFront method
        System.out.println("Testing deleteFront method:");

        System.out.println("'pq' contents: " + pq.toString());
        System.out.println("'pqEmpty' contents: " + pqEmpty.toString());

        System.out.println("\"" + pq.front() + "\" has been deleted from 'pq'");
        pq.deleteFront();
        System.out.println("'pq' contents: " + pq.toString());

        try {
            pqEmpty.deleteFront();
        } catch (QueueException e) {
            System.out.println("deleteFront couldn't be called for 'pqEmpty' as it is empty");
        }
        System.out.println(" ");


//testing isEmpty method
        System.out.println("Testing isEmpty method: ");

        System.out.println("'pq' contents: " + pq.toString());
        System.out.println("'pqEmpty' contents: " + pqEmpty.toString());

        if (pq.isEmpty()) {
            System.out.println("'pq' is empty");
        } else {
            System.out.println("'pq' is not empty");
        }
        if (pqEmpty.isEmpty()) {
            System.out.println("'pqEmpty' is empty");
        } else {
            System.out.println("'pqEmpty' is not empty");
        }
        System.out.println(" ");


    }
}
