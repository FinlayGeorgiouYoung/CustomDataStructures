package WordTree;

public class Main {

    public static void main(String[] args) {
        WordTree tree = new WordTree();
        tree.addWord("Hello");
        tree.addWord("helsinki");
        tree.addWord("hi");
        tree.addWord("hiloi");
        tree.addWord("Finlay");
        tree.addWord("hi23");

        if (tree.find("Helsinki")){
            System.out.println("helsinki found");
        }

        if(tree.delete("helsinki")){
            System.out.println("helsinki deleted");
        }

        if (tree.find("helsinki")){
            System.out.println("helsinki found");
        }
        else {
            System.out.println("helsinki not found");
        }

        if (tree.find("hello")){
            System.out.println("hello found");
        }

        tree.addWord("hallo");
        tree.addWord("hebby");
        tree.addWord("hell");
        tree.addWord("hx");
        tree.addWord("hye");
        System.out.println(tree.getWords('h'));

        tree.delete("hell");
        tree.delete("hx");
        tree.delete("hiloi");
        tree.delete("hye");
        System.out.println(tree.getWords('h'));


        tree.addWord("by");
        tree.addWord("Bye");
        tree.addWord("big");
        tree.addWord("b");
        tree.addWord("beautiful");
        tree.addWord("beau");
        tree.addWord("bottom");
        System.out.println(tree.getWords('b'));

        tree.delete("beau");
        tree.delete("bye");
        tree.delete("b");
        System.out.println(tree.getWords('b'));

        System.out.println(tree.getWords('2'));





    }
}
