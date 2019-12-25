class position{

    String letra;
    int positionX;
    int positionY;
    boolean marcado;
    
    public position(String a, int posiX,int posiY){

        letra = new String(a);
        positionX=posiX;
        positionY=posiY;
    }

    public position(int posiX,int posiY){

        this(null,posiX,posiY);
    }

    public position(String a){

        this(a,null,null);
    }

    public static void main(String[] args) {
        
    }
}