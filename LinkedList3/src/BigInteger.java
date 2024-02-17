public class BigInteger {
    String decimal;
    public BigInteger(String val){
        val = decimal;
    }
    /**
     * Returns a BigInteger whose value is the absolute
     * value of this  BigInteger.
     */
   // public BigInteger abs(){}

    /**
     * Returns a BigInteger whose value is
     * (this + val).
     */
   // public BigInteger add(BigInteger val){}

    /**
     * Returns a BigInteger whose value is (this - val).
     */
   // public BigInteger subtract(BigInteger value){}

    /**
     * Returns a BigInteger whose value is (this * val).
     */
   // public BigInteger multiply(BigInteger value){}

    /**
     * Compares this BigInteger with o for equality.
     * if o is not BigInteger, return false
     */
    public boolean equals(Object o){
        if(decimal == o){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Returns the decimal String representation
     * of this BigInteger.
     */
    public String toString(){
        String str = "";
        for (int i = 0; i < decimal.length(); i++) {
            str += decimal;
        }
        return str;
    }

   /* public static final BigInteger ONE;
    public static final BigInteger TEN;
    public static final BigInteger ZERO; */

}

class test{
    public static void main(String[] args){

        /**
         example of construct by String
         */
        BigInteger b1 = new BigInteger("+1234");
        System.out.println(b1.toString()); //1234

        BigInteger b2 = new BigInteger("3333");
        System.out.println(b2.toString()); //3333

        BigInteger b3 = new BigInteger("-10");
        System.out.println(b3.toString()); //-10


        /**
         * example of add
         */
       // BigInteger bz = b3.add(BigInteger.TEN);
      //  System.out.println(bz.toString()); // -10 + 10 = 0

        /**
         * example of other operations
         */
       // System.out.println( b2.add(b3.abs()).toString() ); //3343
        //b3.abs() will compute to 10
        // b2+10 will be 3343

       // System.out.println(new BigInteger("7").multiply(new BigInteger("-4")).toString()); //-28

       // System.out.println(new BigInteger("74").subtract(new BigInteger("-34")).toString()); //108


        System.out.println(b1.equals(b2)); // b1!=b2 ==> false

       // System.out.println(bz.equals(BigInteger.ZERO)); // both zero ==> true

       // System.out.println(bz.equals(0)); // return false, because 0 is Integer not BigInteger
    }

}