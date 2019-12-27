public class LinkedList<T> implements Iterable<T>{ 
    
    int size;
    SingleNode<T> Header;
    LinkedListIterator<T> list;
    
    public LinkedList(){          

        size=0;
        Header = new SingleNode<T>();
        list = new LinkedListIterator<T>(Header);

    } 
    
    public java.util.Iterator<T> iterator(){            
        
        return list;
    
    } 
    
    public int size(){    

       return size; 
    
    } 
    
    public boolean isEmpty(){    

        if (size==0){

            return true;

        }else{

            return false;

        }
    
    } 
    
    public SingleNode<T> header(){    

        
        return Header;

    }

    public void clear() {
        
        Header = new SingleNode<T>();
        list = new LinkedListIterator<T>(Header);
    
    }

    
    
    public void add(int i, T x){            

        SingleNode<T> Atual =new SingleNode<T>();
        
        size++;
        Atual=list.NodeAtual;
        for (int z=0;z<i;z++){      
            list.next();
            Atual=list.NodeAtual;
        }
        SingleNode<T> newNode = new SingleNode<T>(x,Atual.getNext());
        Atual.setNext(newNode);
        list.NodePrev=Atual;
        list.NodeAtual=newNode;

        list = new LinkedListIterator<T>(this.header());

    } 

    public void add(T x){            

        SingleNode<T> Atual =new SingleNode<T>();
        
        size++;
        Atual=list.NodeAtual;
        for (int z=0;z<size;z++){      
            list.next();
            Atual=list.NodeAtual;
        }
        SingleNode<T> newNode = new SingleNode<T>(x,Atual.getNext());
        Atual.setNext(newNode);
        list.NodePrev=Atual;
        list.NodeAtual=newNode;

        list = new LinkedListIterator<T>(this.header());

    } 

    public void set(int i, T x){            

        SingleNode<T> Atual =new SingleNode<T>();
        
        for (int z=0;z<i+1;z++){      
            list.next();
            Atual=list.NodeAtual;
        }

        Atual.setElement(x);




        list = new LinkedListIterator<T>(this.header());

    } 
    
    public SingleNode<T> remove(T x){            

        SingleNode<T> Atual =new SingleNode<T>();
        T search;
        
        for (int z=0;z<size;z++){      
            list.next();
            Atual=list.NodeAtual;
            search=Atual.element();
            if (search.equals(x)){

                size--;
                list.remove();
                list = new LinkedListIterator<T>(this.header());

                return Atual;
                

            }
            
        }

        list = new LinkedListIterator<T>(this.header());

        return Atual;
    
       

    }     

    public T get(int i){

        SingleNode<T> Atual =new SingleNode<T>();
        
        for (int z=0;z<i+1;z++){      
            list.next();
            Atual=list.NodeAtual;
        }

        list = new LinkedListIterator<T>(this.header());


        return Atual.element();

    }

    public void remove(int ind){            

        SingleNode<T> Atual =new SingleNode<T>();
        
        size--;
        for (int z=0;z<=ind;z++){      
            list.next();
            Atual=list.NodeAtual;
        }
        list.remove();
        list = new LinkedListIterator<T>(this.header());

    }   

    public void escrita(){

        System.out.print("[");
        while (list.hasNext()) {
            
            System.out.print(list.next());
            if (list.hasNext())
            System.out.print(", ");
        }
        System.out.println("]");

        list = new LinkedListIterator<T>(this.header());

    }
    
    public static void main(String[] args) {
        
        LinkedList<Integer> lista = new LinkedList<>();
        
        lista.add(0,2);

        lista.add(0,4);

        lista.add(new Integer(5));

        lista.escrita();


    }

}