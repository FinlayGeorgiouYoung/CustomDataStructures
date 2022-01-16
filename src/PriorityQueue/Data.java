package PriorityQueue;

//Data class has 2 variables, which is data(a String) and priority(an int)
//the PriorityQueue will hold Data objects
public class Data {
    String data;
    int priority;

    //constructor takes a String as data and an int as the priority of the String to be used in the queue
    public Data(String data, int priority){
        this.data = data;
        this.priority = priority;
    }
}
