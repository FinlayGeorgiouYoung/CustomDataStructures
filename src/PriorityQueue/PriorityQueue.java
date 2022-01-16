package PriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;


public class PriorityQueue implements Queue<Integer, String> {

    //a LinkedList of objects of type Data are used to hold the data of the PriorityQueue
    //Data objects have two variables, a String('data') and an Integer('priority')
    private LinkedList<Data> contents;

    //Constructor creates a new LinkedList
    public PriorityQueue() {
        contents = new LinkedList<>();
    }


    @Override
    //the addtopq method takes a String and an Integer(priority) as a parameter and creates a Data object from the input String and Integer(priority)
    //this Data object is then added to the LinkedList called contents
    public void addtopq(String str, Integer priority) {
        //if a priority that's not 1 to 20 is passed as a parameter an exception is thrown
        if (priority < 1 || priority > 20) {
            throw new RuntimeException("Priority out of 1 to 20 range");
        }

        //a new Data object is created using the parameters passed and this is added to the LinkedList called contents
        contents.addLast(new Data(str, priority));

        //once the new Data object is added to the contents LinkedList, it is sorted in ascending order by the Data objects' priorities using a comparator
        contents.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return Integer.compare(o1.priority, o2.priority);
            }
        });
    }

    @Override
    //the deleteFront method removes the Data object with the highest priority from the PriorityQueue
    public void deleteFront() {
        //calls isEmpty method to check if the PriorityQueue instance is empty
        //if it is, a QueueException is thrown
        if (isEmpty()) {
            throw new QueueException("deleteFront method");
        }

        //Uses the removeFirst method from the LinkedList class to remove the first Data object in the contents LinkedList
        //Due to the LinkedList being sorted each time an item is added,
        //the first item Data object in the LinkedList will always be the one with the highest priority
        contents.removeFirst();
    }

    @Override
    //the front method returns the data of the first Data object in the PriorityQueue
    public String front() {
        //calls isEmpty method to check if the PriorityQueue instance is empty
        //if it is, a QueueException is thrown
        if (isEmpty()) {
            throw new QueueException("deleteFront method");
        }

        //Uses the getFirst method from the LinkedList class to get the first Data object in the contents LinkedList
        //once the first Data object is obtained the data of that object is returned
        //Due to the LinkedList being sorted each time an item is added,
        //the first item Data object in the LinkedList will always be the one with the highest priority
        return contents.getFirst().data;
    }

    //the frontpri method returns the priority of the first Data object in the PriorityQueue
    public int frontpri() {
        //calls isEmpty method to check if the PriorityQueue instance is empty
        //if it is, a QueueException is thrown
        if (isEmpty()) {
            throw new QueueException("deleteFront method");
        }

        //Uses the getFirst method from the LinkedList class to get the first Data object in the contents LinkedList
        //once the first Data object is obtained the priority of that object is returned
        //Due to the LinkedList being sorted each time an item is added,
        //the first item Data object in the LinkedList will always be the one with the highest priority
        return contents.getFirst().priority;
    }

    @Override
    //the isEmpty method checks to if the PriorityQueue is empty by checking if the contents LinkedList is empty
    public boolean isEmpty() {
        return contents.isEmpty();
    }

    @Override
    //the toString method returns a String of all of the Data objects in the PriorityQueue, showing each of their data and priorities
    public String toString() {
        //if the PriorityQueue is empty then "<>" will be returned
        if (isEmpty()) {
            return "<>";
        }


        StringBuffer sb = new StringBuffer("<\"");
        //loops through the Data objects up to one before the last one of the priority queue by looping through the contents LinkedList
        for (int i = 0; i < contents.size() - 1; i++) {
            String currentString = contents.get(i).data;
            int currentPriority = contents.get(i).priority;
            //appends the data and the priority of the current Data object to the StringBuffer sb
            sb.append(currentString + "\":" + currentPriority + ", \"");
        }
        //appends the data and priority of the last Data object as the formatting is different
        sb.append(contents.getLast().data + "\":" + contents.getLast().priority + ">");

        //returns the StringBuffer sb as a String
        return String.valueOf(sb);
    }
}