public class SingleNode<T>{ 
    
    T Node;
    SingleNode<T> Next;
    
    //construtor 
    public SingleNode(T x){        
        
        Node=x;

    } 

    //construtor vazio 
    public SingleNode(){           



    }
    
    public SingleNode(T x, SingleNode<T> n){        

        Node = x;
        setNext(n);

    }

    public String toString(){

        return Node.toString();
    }

    
    
    public T element(){         

        return Node;

    } 
     
    public SingleNode<T> getNext(){     

        return Next;

    } 
     
    public void setElement(T x){           

        Node = x;

    } 
     
    public void setNext(SingleNode<T> n){     

        Next=n;

    } 
    

    

}