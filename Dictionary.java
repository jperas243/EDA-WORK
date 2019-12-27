import java.io.File;
import java.util.Scanner; 
import java.io.FileNotFoundException;  

class Dictionary{

    HashTable<String> words;

    public Dictionary(){

        words = new HashTable<>(60000);
        build();

    }

    public boolean wordExists(String s){

        if (this.words.procurar(s)!=null){ 
            return true;
        }

        return false;

    }

    public void print(){

        words.print();
    }

    public void build(){

        try{
            
            File FileDictionary= new File("allWords.txt");
            //File FileDictionary= new File("C:\\Users\\hijor\\IdeaProjects\\Programming\\src\\allWords.txt"); //Para o Abel
            Scanner scan = new Scanner(FileDictionary);
            
            while (scan.hasNextLine()) {

                String data = scan.nextLine();
                words.insere(data);
                System.out.println(words.procurar(data));
        
            }
            scan.close();

        }catch (FileNotFoundException e) {
            
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
    
        Dictionary livro = new Dictionary();
        System.out.println(livro.wordExists("game"));
        
    }

}