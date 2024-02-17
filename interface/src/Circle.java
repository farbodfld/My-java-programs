/*
public class Circle implements shape , java.lang.Comparable{
    double radios;

    @Override
    public int getarea() {
        return (int) (3*(radios*radios));
    }

    @Override
    public int compareTo(Object object){
        if(object instanceof Circle || object instanceof Rectangle){
            if(((shape) object).getarea()>getarea())
                return -1;
        }
        else if(((shape) object).getarea()<getarea())
            return 1;

        return 0;
    }
}

class Rectangle implements shape , java.lang.Comparable{
    double radios;

    @Override
    public int getarea() {
        return (int) (3*(radios*radios));
    }

    @Override
    public int compareTo(Object object){
        if(object instanceof Circle || object instanceof Rectangle){
            if(((shape) object).getarea()>getarea())
                return -1;
        }
        else if(((shape) object).getarea()<getarea())
            return 1;

        return 0;
    }
}

interface shape {
    int getarea();
}*/
