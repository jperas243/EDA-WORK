import java.io.File;

class Boggle{

    Dictionary Dictio;
    File BoggleDoc;
    Position[][] Matriz;
    LinkedList<LinkedList<Position>> WordsFound;
    LinkedList<Position> Word;

    public Boggle(){

        Dictio = new Dictionary();
        Word = new LinkedList<>();
        WordsFound = new LinkedList<>();
    }

    public Boggle(String a){

        Dictio = new Dictionary();
        BoggleDoc = new File(a);
        Word = new LinkedList<>();
        WordsFound = new LinkedList<>();

    }

    public Boggle(String a,int row,int column ){

        Dictio = new Dictionary();
        BoggleDoc = new File(a);
        Matriz = new Position[row][column];
        Word = new LinkedList<>();
        WordsFound = new LinkedList<>();


    }

    public void newMatriz(int row,int column ){

        Matriz = new Position[row][column];
    }

    

    public void buildMatriz(){

        //adaptar para ler o ficheiro e construir, 

        int v=0;
        int j=0;

        for (int i=0;i<Matriz[j].length;i++){

            for (int z=0;z<Matriz.length;z++){

                Matriz[i][z] = new Position(Character.toString ((char) 65+i+z+v));
                Matriz[i][z].setX(i);
                Matriz[i][z].setY(z);
                System.out.print(Matriz[i][z]+" , ");            
            }
            System.out.println(); 
            v++;           

        }

    }
    
    public void solve(){

        buildMatriz();

        int j=0;

        
        
        
        for (int i=0;i<Matriz[j].length;i++){

            for (int z=0;z<Matriz.length;z++){

                System.out.println("--------------------------");
                findWords(i,z,"");
                System.out.println("--------------------------");
            }

        }
    }

    public String findWords(int row,int column,String Anterior){    

        //recursividade esta bem,porem nao sabemos se WordsFound anota as encontradas
        
        int j=0;

        if ( 0 <= row && row < Matriz[j].length && 0 <= column && column< Matriz.length && Matriz[row][column].marcado==false) { 
        
            String WordString = Anterior.concat(Matriz[row][column].getLetter());
            System.out.println(WordString);
            Word.add(Matriz[row][column]);
            Matriz[row][column].setMarca();
            
            if (Dictio.wordExists(WordString)){

                LinkedList<Position> novo= new LinkedList<>(); 
                Word.copyTo(novo);
                WordsFound.add(novo);
            }

            findWords(Matriz[row][column].getX() ,Matriz[row][column].getY()+1,WordString);
            findWords( Matriz[row][column].getX() ,Matriz[row][column].getY()-1,WordString); //S
            findWords( Matriz[row][column].getX()+1 ,Matriz[row][column].getY(),WordString); //E
            findWords( Matriz[row][column].getX()-1,Matriz[row][column].getY(),WordString); //W
            
            findWords( Matriz[row][column].getX()+1 ,Matriz[row][column].getY()+1,WordString); // NE
            findWords( Matriz[row][column].getX()-1 ,Matriz[row][column].getY()+1,WordString); // NW
            findWords( Matriz[row][column].getX()+1 ,Matriz[row][column].getY()-1,WordString); // SE
            findWords( Matriz[row][column].getX()-1 ,Matriz[row][column].getY()-1,WordString); // SW

            Word.remove(Word.size()-1);
            Matriz[row][column].clearMarca();

            return WordString;
    
        }else{

            return Anterior;

        }

    

    }

    public void solution(){
        
        if (WordsFound==null){
            System.out.println("Execute solve() primeiro");
        }else{ 
            WordsFound.print();
        }
    }


    public String listToString(LinkedList<Position> word){

        String save = new String("");
            
        for(int i=0;i<word.size();i++){

            save=save+word.get(i).getLetter();

        }
        
        return save;

    }


    public static void main(String[] args) {
        
        Boggle Analise = new Boggle();
        Analise.newMatriz(4, 4);
        Analise.buildMatriz();
        Analise.solution();
    }
}