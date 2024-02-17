public interface edible {
    String howtoeat();
}
class animal{}

class chiken extends animal implements edible{
   public String howtoeat(){
       String s = "fried it first";
       return s;
    }
}
class tiger{
    int speed = 90;
    int weight = 56;
}
abstract class fruite implements edible{ }
class apple extends fruite{
    public String howtoeat(){
        String s = "aplle juice ";
        return s;
    }
}
class orange extends fruite{
    public String howtoeat(){
        String s = "orange juice ";
        return s;
    }
}
class test2{
    public static void main(String[] args){
        Object[] objecs = {new tiger(), new chiken(), new apple(), new orange()};
        for (Object x : objecs){
            if (x instanceof edible)
                System.out.println(((edible) x).howtoeat());
        }
    }
}