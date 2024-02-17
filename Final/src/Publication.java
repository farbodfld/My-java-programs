public interface Publication {
    public abstract void publish();
}

interface Book extends Publication{
    public abstract void read();
}

abstract class CourseBook implements Book{

    @Override
    public void publish() {
        System.out.println("Publishing course book");
    }
}

class ProgrammingBook extends CourseBook{

    @Override
    public void publish() {
        System.out.println("Publishing programming book");
    }

    @Override
    public void read() {
        System.out.println("Reading programming book");
    }
}

class DiscreteBook extends CourseBook{

    @Override
    public void publish() {
        System.out.println("Publishing discrete mathematics book");
    }

    @Override
    public void read() {
        System.out.println("Reading discrete mathematics book");
    }
}

class Test2{
    public static void display(Publication p){
        if (p instanceof CourseBook){
            p.publish();
        }else if (p instanceof ProgrammingBook){
            p.publish();
            ((ProgrammingBook) p).read();
        }else if (p instanceof DiscreteBook){
            p.publish();
            ((DiscreteBook) p).read();
        }
    }

    public static void main(String[] args){
        Publication p = new ProgrammingBook();
        Publication p2 = new DiscreteBook();

        display(p);
        display(p2);
    }
}