import java.io.File;
import java.util.Scanner; 
import java.io.FileNotFoundException;  

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

    public void setFile(String a){

        BoggleDoc = new File(a);

    }

    public File getFile(){

        return BoggleDoc;

    }

    public void buildMatriz(){

        try{
            
            //File FileDictionary= new File("C:\\Users\\hijor\\IdeaProjects\\Programming\\src\\allWords.txt"); //Para o Abel
            Scanner scan = new Scanner(BoggleDoc);
            int counter=0;
            int j=0;


                String data = scan.nextLine();
                
                for (int i=0;i<Matriz[j].length;i++){

                    for (int z=0;z<Matriz.length;z++){
        
                        String letra = String.valueOf(data.charAt(counter));
                        counter++;
                        Matriz[i][z] =  new Position(letra,i , z);
                        System.out.print(Matriz[i][z]);
                    }
                    System.out.println();

                }
        
            scan.close();

        }catch (FileNotFoundException e) {
            
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    
    public void solve(){

        System.out.println("---------------------");
        buildMatriz();
        System.out.println("---------------------");

        int j=0;        
        
        for (int i=0;i<Matriz[j].length;i++){

            for (int z=0;z<Matriz.length;z++){

                findWords(i,z,"");
            }

        }
    }

    public void findWords(int row,int column,String Anterior){    

        //recursividade esta bem,porem nao sabemos se WordsFound anota as encontradas
        
        int j=0;

        if ( 0 <= row && row < Matriz[j].length && 0 <= column && column< Matriz.length && Matriz[row][column].marcado==false) { 
        
            String WordString = Anterior.concat(Matriz[row][column].getLetter().toLowerCase());
            
            Position novoPosition = Matriz[row][column];
            Word.add(novoPosition);
            Matriz[row][column].setMarca();
            
            if (Dictio.wordExists(WordString)){

                LinkedList<Position> novo = new LinkedList<>();
                
                for(int i=0;i<Word.size();i++){

                    Position newPosition = Word.get(i);
                    novo.add(newPosition);

                }
                WordsFound.add(novo);
            }



            findWords( Matriz[row][column].getX() ,Matriz[row][column].getY()+1,WordString);


            findWords( Matriz[row][column].getX() ,Matriz[row][column].getY()-1,WordString); //S

            findWords( Matriz[row][column].getX()+1 ,Matriz[row][column].getY(),WordString); //E

            findWords( Matriz[row][column].getX()-1,Matriz[row][column].getY(),WordString); //W
            
            findWords( Matriz[row][column].getX()+1 ,Matriz[row][column].getY()+1,WordString); // NE

            findWords( Matriz[row][column].getX()-1 ,Matriz[row][column].getY()+1,WordString); // NW

            findWords( Matriz[row][column].getX()+1 ,Matriz[row][column].getY()-1,WordString); 

            findWords( Matriz[row][column].getX()-1 ,Matriz[row][column].getY()-1,WordString); // SW

            Word.remove(Word.size-1);
            Matriz[row][column].clearMarca();



        }
    


    

    }

    public void solution(){
        
        if (WordsFound==null){
            
            System.out.println("Execute solve() primeiro");
        
        }else{ 
            
            for(int i=0;i<WordsFound.size();i++){

                WordsFound.get(i).print();
                System.out.println();

            }

        }
    }

        /*

            [seldom, semen, seoul, so, soul, soon, some, sum, sumo, summon, 
            sum, sumo, sumo, sue, sue, suet, elm, em, emu, emus, lot, lumen, 
            lumen, do, dome, dome, domes, dot, dote, doe, dole, doles, dolmen, 
            omen, ominous, us, use, mod, mold, mole, moles, mu, mum, mule,
            mules, muse, me, met, memo, memo, men, me, meld, omen, old, ole,
            olm, omen, oink, on, one, me, met, memo, men, moo, moos, moose, 
            monk, monkey, money, mould, mouse, mu, mum, mule, mules, muse, mink, 
            minke, mine, mould, mouse, moo, moon, em, emu, emus, em, emu, emus, 
            ten, tyke, to, tome, tome, tomes, toe, told, in, ink, inky, ion, 
            im, ne, net, no, noose, key, ken, ye, yet, yen]

        */


    public String listToString(LinkedList<Position> word){

        String save = new String("");
            
        for(int i=0;i<word.size();i++){

            save=save+word.get(i).getLetter();

        }
        
        return save;

    }


    public static void main(String[] args) {
        
        Boggle Analise = new Boggle("Boggle.txt");
        Analise.newMatriz(4, 4);
        Analise.solve();
        Analise.solution();


    

    }
}