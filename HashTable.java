import java.util.*;

class HashTable<T>{  //fazer os extends dos varios tipos de solve collisions

    public T[] tabela;
    public T[] newTabela;
    int size;
    int newSize;

    public int size(){

        return size;
    }

    
    public HashTable(int num){

        size=num;
        tabela = (T[])new Object[num];
    }

    public int ocupados(){

        int count=0;
        
        for(T position: tabela){

            
            if (position==null){
                count++;
            }

        }

        return size-count;

    }   

    public float factorCarga(){

        float result=(float)ocupados()/size;

        return result;

    }

    protected int NewProcPos(T s){

        int result =s.hashCode()%newSize;
        int count=1;
        
        if (result<0){
            result=0-result;
        }

        if(s.equals(newTabela[result])){

            return result;

        }

        while(newTabela[result]!=null){

            result = (result + funcAuxiliar(count))%newSize;
            if (result<0){
                result=0-result;
            }
            count++;
        } 
        
        return result;
        

    }

    public int procPos(T s){

        int result =s.hashCode()%size;
        int count=1;

        if (result<0){
            result=0-result;
        }
        
        if(s.equals(tabela[result])){

            return result;

        }

        while(tabela[result]!=null){

            result = (result + funcAuxiliar(count))%size;
            if (result<0){
                result=0-result;
            }
            count++;

            if(s.equals(tabela[result])){

                return result;
    
            }
        } 

        System.out.println(result);
        
        return result;
        

    }

    int funcAuxiliar(int num){

        return num*num;
    }

    public void alocarTabela(int dim){

        newTabela = (T[])new Object[dim];

    }

    public  T procurar(T x){

        int Hash=procPos(x);

        if (tabela[Hash]==null){
            
            return null;
        
        }

        return tabela[Hash];

    }

    public  void tornarVazia(){

        for(int i=0;i<tabela.length;i++){

               tabela[i]=null;

        }

    }

    public  void remove(T x){

        int Hash=procPos(x);

        if (x.equals(tabela[Hash])){
        
            tabela[Hash]=null;
        
        }

        
    }

    public  void insere (T x){

        int Hash=procPos(x);
        tabela[Hash]=x;

        if(factorCarga()>0.6){
            rehash();
        }

    }

    public  void newInsere (T x){

        if(x==null){

        }else{

            int Hash=NewProcPos(x);
            newTabela[Hash]=x;
        }

    }

    public void print(){

        System.out.print("[");

        for(T position: tabela){

            System.out.print(position+", ");


        }
        System.out.println("]");

    }


    public void rehash(){

        System.out.println("rehashing");

        List<Integer> primes = new ArrayList<>();

        for (int i = size; i < 2.5*size; i++) {
            boolean isPrimeNumber = true;

            // check to see if the number is prime
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break; // exit the inner for loop
                }
            }

            // print the number if prime
            if (isPrimeNumber) {
                primes.add(i);
            }
        }
        
        newSize=primes.remove(primes.size()-1);
        alocarTabela(newSize);

        for(T position: tabela){

            newInsere(position);
            

        }

        tabela=newTabela;
        newTabela=null;
        size=newSize;
        newSize=0;

    }
    

    public static void main(String[] args) {
        
        HashTable<String> livro = new HashTable(11);
        livro.insere("ola");
        livro.insere("ole");
        livro.insere("oli");
        livro.insere("olo");
        livro.insere("olu");
        livro.insere("nossa");
        livro.insere("senhora");



        livro.print();
        System.out.println(livro.ocupados());
        System.out.println(livro.factorCarga());


    }
} 