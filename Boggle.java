import java.io.File;

class Boggle{

    Dictionary Dictio;
    File BoggleDoc;
    Position[][] Matriz;
    LinkedList<LinkedList<Position>> WordsFound;
    LinkedList<Position> Word;

    public Boggle(){

        //Dictio = new Dictionary();
        Word = new LinkedList<>();

    }

    public Boggle(String a){

        Dictio = new Dictionary();
        BoggleDoc = new File(a);
        Word = new LinkedList<>();

    }

    public Boggle(String a,int row,int column ){

        Dictio = new Dictionary();
        BoggleDoc = new File(a);
        Matriz = new Position[row][column];
        Word = new LinkedList<>();


    }

    public void newMatriz(int row,int column ){

        Matriz = new Position[row][column];
    }

    

    public void buildMatriz(){

        int j=0;

        for (int i=0;i<Matriz[j].length;i++){

            for (int z=0;z<Matriz.length;z++){

                Matriz[i][z] = new Position(Character.toString ((char) 200+i));
                Matriz[i][z].setX(i);
                Matriz[i][z].setY(z);
                System.out.print(Matriz[i][z]+" , ");            
            }
            System.out.println();            

        }

    }
    
    public void solve(){

        buildMatriz();

        int j=0;

        
        for (int i=0;i<Matriz[j].length;i++){

            for (int z=0;z<Matriz.length;z++){

                System.out.println("--------------------------");
                findWords(i,z);
                System.out.println("--------------------------");

            }

        }
    }

    public void findWords(int row,int column){

        String WordString;      
        
        Word.add(Matriz[row][column]);
        Word.escrita();

        System.out.println(0 <= Matriz[row][column].getX() && Matriz[row][column].getX() < Matriz[row].length-1 && 0 <= Matriz[row][column].getY()+1 && Matriz[row][column].getY()+1 <= Matriz.length-1 && Matriz[row][column].marcado==false);
        
        WordString = listToString(Word);
        Matriz[row][column].setMarca();

        if ( 0 <= Matriz[row][column].getX() && Matriz[row][column].getX() < Matriz[row].length-1 && 0 <= Matriz[row][column].getY()+1 && Matriz[row][column].getY()+1 < Matriz.length-1 && Matriz[row][column].marcado==false) { 
            
            System.out.println("ola");

            findWords(Matriz[row][column].getX() ,Matriz[row][column].getY()+1); //N

        }

        if ( 0 <= Matriz[row][column].getX() && Matriz[row][column].getX() < Matriz[row].length-1 && 0 <= Matriz[row][column].getY()-1 && Matriz[row][column].getY()-1 < Matriz.length-1 && Matriz[row][column].marcado==false) { 
            
            findWords( Matriz[row][column].getX() ,Matriz[row][column].getY()-1); //S
            
        }

        if ( 0 <= Matriz[row][column].getX()+1 && Matriz[row][column].getX()+1 < Matriz[row].length-1 && 0 <= Matriz[row][column].getY() && Matriz[row][column].getY() < Matriz.length-1 && Matriz[row][column].marcado==false) { 
            
            
            findWords( Matriz[row][column].getX()+1 ,Matriz[row][column].getY()); //E
  
        }

        if ( 0 <= Matriz[row][column].getX()-1 && Matriz[row][column].getX()-1 < Matriz[row].length-1 && 0 <= Matriz[row][column].getY() && Matriz[row][column].getY() < Matriz.length-1 && Matriz[row][column].marcado==false) { 
            
            findWords( Matriz[row][column].getX()-1,Matriz[row][column].getY()); //W
  
        }

//-------------------------------------------------------------------------------------------



        if ( 0 <= Matriz[row][column].getX()+1 && Matriz[row][column].getX()+1 < Matriz[row].length-1 && 0 <= Matriz[row][column].getY()+1 && Matriz[row][column].getY()+1 < Matriz.length-1 && Matriz[row][column].marcado==false) { 
            
            findWords( Matriz[row][column].getX()+1 ,Matriz[row][column].getY()+1); // NE
  
        }

        if ( 0 <= Matriz[row][column].getX()-1 && Matriz[row][column].getX()-1 < Matriz[row].length-1 && 0 <= Matriz[row][column].getY()+1 && Matriz[row][column].getY()+1 < Matriz.length-1 && Matriz[row][column].marcado==false) { 
            
            findWords( Matriz[row][column].getX()-1 ,Matriz[row][column].getY()+1); // NW
  
        }

        if ( 0 <= Matriz[row][column].getX()+1 && Matriz[row][column].getX()+1 < Matriz[row].length-1 && 0 <= Matriz[row][column].getY()-1 && Matriz[row][column].getY()-1 < Matriz.length-1 && Matriz[row][column].marcado==false) { 
            
            findWords( Matriz[row][column].getX()+1 ,Matriz[row][column].getY()-1); // SE

        }

        if ( 0 <= Matriz[row][column].getX()-1 && Matriz[row][column].getX()-1 < Matriz[row].length-1 && 0 <= Matriz[row][column].getY()-1 && Matriz[row][column].getY()-1 < Matriz.length-1 && Matriz[row][column].marcado==false) { 
            
            findWords( Matriz[row][column].getX()-1 ,Matriz[row][column].getY()-1); // SW

        }
        Word.remove(Word.size();
        Word.escrita();

        System.out.println(WordString);
        


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
        Analise.newMatriz(3, 3);
        Analise.solve();

    }
}