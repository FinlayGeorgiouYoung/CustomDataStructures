package WordTree;

import java.util.*;


//The WordTree class consists of a root node. When words are added to the WordTree the Characters of the word will be added one by one to the children of the current node starting with the root
//Each Node has a HashMap which stores the Character's and the Node's of each child. The Character is the key and the Node is the value
//Each Node also has a boolean called 'prefix' which is set to true if a word is a prefix, and a String called 'wordMade' which will be set to the word that is stored in the WordTree when the last Node/Character of that word is reached
public class WordTree {

    private Node root;

    //constructor creates an empty WordTree by setting root to a new Node.
    public WordTree(){
        root = new Node();
    }




    //onlyLetters is a private method which you pass a String into as a parameter and check if it contains only letters
    //if the String passed doesn't contain only letters then false will be returned, otherwise true will
    private boolean onlyLetters(String word){
        //loops through the String passed and checks if each Character is a letter.
        for(int i=0; i<word.length(); i++){
            if (!Character.isLetter(word.charAt(i))){
                return false;
            }
        }
        return true;
    }





    //addWord is a method which you pass a String into. The method adds a word into a WordTree
    //it returns a boolean. True is returned if the word is added successfully and false if not.
    boolean addWord(String word){
        //the word passed is set to lower case and assigned a variable so the addition of words into the WordTree is case insensitive
        String lowerCaseWord = word.toLowerCase();

        //if the word doesn't contain only letters then an appropriate message will be printed and false will be returned
        if(!onlyLetters(word)){
            System.out.println("Word: \"" + word + "\" doesn't contain only letters");
            return false;
        }

        //have the current node start of as the root node
        Node current = root;

        //loops through the characters of the word passed into the method
        for(int i=0; i<lowerCaseWord.length(); i++){

            //if the current character doesn't exist as a child of the current node then add it as a child
            if(!current.children.keySet().contains(lowerCaseWord.charAt(i))){
                current.children.put(lowerCaseWord.charAt(i), new Node());
            }

            //current is set to the Node with the current character as it's key
            current = current.children.get(lowerCaseWord.charAt(i));

            //if the word already exists then an error message will be printed and false will be returned
            if(current.wordMade.equals(lowerCaseWord)){
                System.out.println("\"" + word + "\" could not be added as it already exists");
                return false;
            }
        }
        //if the current Node has children and the word passed has been looped through, then set prefix of the Node to true
        if(!current.children.isEmpty()){
            current.prefix = true;
        }

        //set the wordMade variable of the current Node to the word passed
        current.wordMade = lowerCaseWord;

        return true;
    }






    //find is a method which you pass a String into as a parameter. The method shows whether a word is present in the WordTree or not
    //it returns a boolean. True if the word is found and false if not
    boolean find(String word){

        //if the word doesn't contain only letters then an appropriate message will be printed and false will be returned
        if(!onlyLetters(word)){
            System.out.println("Word: \"" + word + "\" doesn't contain only letters");
            return false;
        }

        //the word passed is set to lower case and assigned a variable as all of the words added to the WordTree are converted to lowercase
        String lowerCaseWord = word.toLowerCase();

        //the current Node is set to the root node
        Node current = root;
        boolean wordFound = false;

        //loops through the word passed and at each iteration the current Node is changed if the current Character is a child of the Node
        //then if that Node's wordMade variable is equal to the lowercase version of the word passed then wordFound is set to true
        for(int i=0; i<lowerCaseWord.length(); i++){
            //if the current Character is a child of the current Node...
            if(current.children.keySet().contains(lowerCaseWord.charAt(i))){
                //the current Node is set to the Node with the Character equal to the current Character
                current = current.children.get(lowerCaseWord.charAt(i));
                //if the current Node's wordMade variable is equal to the lowercase version of the word passed then wordFound is set to true
                if (current.wordMade.equals(lowerCaseWord)){
                    wordFound = true;
                }
            }
            //if the current Character isn't a child of the current Node then wordFound is set to false
            //and the loop is broken as we know the WordTree doesn't contain the word passed
            else {
                wordFound = false;
                break;
            }
        }
        //wordFound is returned
        return wordFound;
    }






    private String currentWord;
    //getWords is a method which you pass a char into as a parameter
    //The method returns a list of words starting with the Character passed
    List<String> getWords(char c){
        currentWord = "";
        //converts the character passed to lowercase and assigns it to a variable
        char charLowercase = Character.toLowerCase(c);
        ArrayList<String> words = new ArrayList<>();

        //if the Character doesn't contain only letters then an appropriate message will be printed and false will be returned
        if(!Character.isLetter(c)){
            System.out.println("A non letter character was entered as an argument to getWords");
            return words;
        }

        //if the root has the Character as a child...
        if(root.children.keySet().contains(charLowercase)){
            //if the child of the root with the same Character as the one passed is a prefix then add the Character to the words list
            //deals with one letter words
            if(root.children.get(charLowercase).wordMade.length() != 0){
                words.add("" + charLowercase);
            }
            //the current word adds the Character passed to the String
            currentWord += charLowercase;
            //getWordsTraverse is then called to traverse the WordTree, adding all words with the Character passed as the starting letter to the words ArrayList
            //Node which represents the passed Character is passed into the method as the currentNode, so it will only iterate through the children of that Node
            getWordsTraverse(root.children.get(charLowercase), words, charLowercase , charLowercase);
        }
        //words ArrayList is then sorted in alphabetical order and returned
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }



    //getWordsTraverse is a private method where you pass a Node, an ArrayList of Strings and 2 characters
    //the method is a recursive method which adds words starting with a specific Character contained in the WordTree to an ArrayList
    private void getWordsTraverse(Node currentNode, ArrayList<String> words, char startingCharacter, char currentCharacter){
        //if the current node has children...
        if (!currentNode.children.isEmpty()) {
            //loops through the children of the current Node
            for (Map.Entry<Character, Node> entry : currentNode.children.entrySet()) {
                //the current child's Character is added to the currentWord String
                currentWord += entry.getKey();
                //if the current child's Node is the end of a word then add the currentWord to words
                if (entry.getValue().wordMade.length() != 0){
                    words.add(currentWord);
                }

                //the method is then called again (recursively) with the current child's Node passed as the Node and the current Child's Character passed as the currentCharacter
                getWordsTraverse(entry.getValue(), words, startingCharacter, entry.getKey());

                //currentWord is reset back to a String with the current character and if the starting character isn't at the start of currentWord then it is added
                currentWord = "" + currentCharacter;
                if (currentWord.charAt(0) != startingCharacter){
                    currentWord = startingCharacter + currentWord;
                }
            }
        }
    }






    private boolean stopDeleting;
    //delete is a method which you pass a word into as a parameter. The method deletes the word entered from the WordTree
    //The method returns a boolean. True will be returned if the word passed is successfully deleted and false if not
    boolean delete(String word){
        stopDeleting = false;

        //if the entered word isn't only letters then false will be returned and an appropriate message will be printed
        if(!onlyLetters(word)){
            System.out.println("Word: \"" + word + "\" doesn't contain only letters");
            return false;
        }

        //checks the tree to see if the input word exists. If not the method will return false
        Node current = root;
        for(int i=0; i<word.length(); i++){
            if(!current.children.keySet().contains(word.charAt(i))){
                return false;
            }
            current = current.children.get(word.charAt(i));
        }


        //if the word entered is a one letter word, then the wordMade value for the characters node will be set to empty
        //and the node will be removed from the root's children if the node had no children.
        if(word.length() == 1){
            root.children.get(word.charAt(0)).wordMade = "";
            if (root.children.get(word.charAt(0)).children.isEmpty()){
                root.children.remove(word.charAt(0));
            }
        }
        //uses the deleteTraverse method to traverse through the tree and delete the input currentWord from the tree
        else {deleteTraverse(root, word.toLowerCase(), 0);}

        return true;
    }



    //deleteTraverse is a private method where you pass a Node, a String and an int
    //the method is a recursive method which deletes the word entered from the WordTree
    private void deleteTraverse(Node current, String word, int pos){
        //if the pos is less than the word length and the current node has a child with a Character equal to the Character in position of the pos value
        //then the method is called again (recursively) with that child's Node passed as the Node and the pos incremented by 1 is passed as the pos
        if(pos < word.length() && current.children.keySet().contains(word.charAt(pos))){
            deleteTraverse(current.children.get(word.charAt(pos)), word, pos+1);
        }

        //if the current Node's wordMade variable is equal to the word passed, then set wordMade to an empty String
        if(current.wordMade.equals(word)){
            current.wordMade = "";
        }

        //if the current Node is a prefix, then set stopDeleting to true
        if (current.prefix){
            stopDeleting = true;
        }

        //if the current Node has more than one child or the current Node's wordMade variable isn't equal to the word passed and isn't equal to an empty String, and stopDeleting is false
        //then remove the Character of the word in position pos from the children of the current Node
        if((current.children.size() > 1 || (current.wordMade != word && current.wordMade != "")) && stopDeleting == false){
            current.children.remove(word.charAt(pos));
            stopDeleting = true;
        }
    }


}


class Node{
    //each Node holds a HashMap of it's children, with a Character as the key and a Node as the value
    HashMap<Character, Node> children;
    //wordMade holds the word that is formed in the WordTree if the current Node is the last character of a word
    String wordMade;
    //prefix is used to determine whether a word created from a collection of Nodes is a prefix or not
    boolean prefix;
    //Node constructor creates an empty Node
    public Node(){
        children = new HashMap<>();
        wordMade = "";
        prefix = false;
    }
}