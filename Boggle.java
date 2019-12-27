import java.io.File;

class Boggle{

    Dictionary Dictio;
    File BoggleDoc;
    Position[][] Matriz;
    LinkedList<LinkedList<String>> WordsFound;

    public Boggle(){

        Dictio = new Dictionary();

    }

    public Boggle(String a){

        Dictio = new Dictionary();
        BoggleDoc = new File(a);

    }

    public Boggle(String a,int row,int column ){

        Dictio = new Dictionary();
        BoggleDoc = new File(a);
        Matriz = new Position[row][column];

    }

    public void newMatriz(int row,int column ){

        Matriz = new Position[row][column];
    }

    

    public void buildMatriz(){


    }
    
    public void solve(){

    }


    public static void main(String[] args) {
        
        Boggle Analise = new Boggle();

    }
}