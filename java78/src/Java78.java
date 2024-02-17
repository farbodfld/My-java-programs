class test3{
    class Human {
    }

    interface Java8Interface {
        boolean isInfected(Human adamizad);

        default boolean isHealthy(Human adamizad) {
            return !(this.isInfected(adamizad));
        }
    }

    class Java8Class implements Java8Interface {
        public boolean isInfected(Human adamizad) {
            return this.isInfected(adamizad);
        }
    }

    public static class java8 {
        public static void main(String[] args) {
            Java8Interface j8 = ((Human adamizad) -> true);

        }
    }
}