public interface Shape {
    int getArea();

    int compareTo(Object object);
}

class Circle implements Shape,java.lang.Comparable  {
    int radios;

    public int getArea() {
        return (3 * (radios * radios));
    }

    public int compareTo(Object object) {
        if (object instanceof Circle) {
            Circle circle = (Circle) object;
            if (this.getArea() > circle.getArea())
                return 1;
            else if (this.getArea() < circle.getArea()) {
                return -1;
            } else
                return 0;
        } else {
            Rectangle rectangle = (Rectangle) object;
            if (this.getArea() > rectangle.getArea())
                return 1;
            else if (this.getArea() < rectangle.getArea()) {
                return -1;
            } else
                return 0;
        }

    }

    class Rectangle implements Shape,java.lang.Comparable  {
        int height, width;

        public int getArea() {
            return height * width;
        }

        public int compareTo(Object object) {
            if (object instanceof Circle) {
                Circle circle = (Circle) object;
                if (this.getArea() > circle.getArea())
                    return 1;
                else if (this.getArea() < circle.getArea()) {
                    return -1;
                } else
                    return 0;
            } else {
                Rectangle rectangle = (Rectangle) object;
                if (this.getArea() > rectangle.getArea())
                    return 1;
                else if (this.getArea() < rectangle.getArea()) {
                    return -1;
                } else
                    return 0;
            }
        }

        class Utility {
            void removeRepetition(Shape[] shape_arr) {
                for (int i = 0; i < shape_arr.length; i++) {
                    for (int j = i + 1; j < shape_arr.length; j++) {
                        if (shape_arr[i].compareTo(shape_arr[j]) == 0) {
                            int n = j + 1;
                            while (n < shape_arr.length){
                                shape_arr[n-1]=shape_arr[n];
                                n++;
                            }
                            shape_arr[shape_arr.length-1]=null;
                        }
                    }
                }
            }
        }
    }

}