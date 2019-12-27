class Position{

    String letra;
    int positionX;
    int positionY;
    boolean marcado;
    
    public Position(String a, int posiX,int posiY){

        letra = new String(a);
        positionX=posiX;
        positionY=posiY;
    }

    public Position(int posiX,int posiY){

        this(null,posiX,posiY);
    }

    public Position(String a){

        letra=a;
    }

    public void setCoords(int posiX,int posiY){

        positionX=posiX;
        positionY=posiY;
    }

    public void setX(int posiX){

        positionX=posiX;

    }

    public int getY(){

        return positionY;

    }

    public int getX(){

        return positionX;

    }

    public void setY(int posiY){

        positionY=posiY;

    }

    public void setLetter(String a){

        letra=a;

    }

    public String setLetter(){

        return letra;

    }

    public String toString(){

        return "("+letra+":("+positionX+","+positionY+")"+")";
    }

    public static void main(String[] args) {
        
        Position posi = new Position("A", 2, 0);
        System.out.println(posi.toString());

    }
}