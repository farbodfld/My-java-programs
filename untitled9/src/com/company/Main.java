

class Main {

    static class book {
        private int isbn;
        book(int i){
            isbn = i;
        }
        int getisbn(){
            return isbn;
        }
        void setisbn(int i){
            isbn = i;
        }
    }

    class testbook {
        public static void main(String[] args) {
            book b1 = new book(124322);
            book b2 = new book(123);
            book b3 = b2;
            System.out.println("the isbn of b2 i " + b2.getisbn());
            // write your code here
        }
    }
}