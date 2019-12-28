public void findWords(int row,int column){

    String WordString;      
    
    Word.add(Matriz[row][column]);
    Word.escrita();

    System.out.println(0 <= Matriz[row][column].getX() && Matriz[row][column].getX() < Matriz[row].length-1 && 0 <= Matriz[row][column].getY()+1 && Matriz[row][column].getY()+1 <= Matriz.length-1 && Matriz[row][column].marcado==false);
    
    WordString = listToString(Word);
    Matriz[row][column].setMarca();

    if ( 0 <= Matriz[row][column].getX() && Matriz[row][column].getX() < Matriz[row].length-1 && 0 <= Matriz[row][column].getY()+1 && Matriz[row][column].getY()+1 < Matriz.length-1 && Matriz[row][column].marcado==false) { 
        
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
    Word.remove(Word.size());
    Word.escrita();

    System.out.println(WordString);
    
    //a função nao volta a trás...

}