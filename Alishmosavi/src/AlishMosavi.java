public class AlishMosavi {
    private String s1;
    private String s2;

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public boolean equal() {
        int length1 = s1.length();
        int length2 = s2.length();

        if (length1 != length2) {
            return false;
        } else if (length1 == length2 && (length1 % 2 == 1)) {
            if (s1.equals(s2)) {
                return true;
            } else {
                return false;
            }

        } else if (length1 == length2 && (length1 % 2 == 0)) {
            String a1 = s1.substring(0, (length1 / 2));
            String a2 = s1.substring(length1 / 2);
            String b1 = s2.substring(0, (length1 / 2));
            String b2 = s2.substring(length1 / 2);
            if (a1.length() == a2.length() && b1.length() == b2.length()) {
                setS1(a1);
                setS2(b1);
                boolean bool1 = equal();
                setS1(a2);
                setS2(b2);
                boolean bool2 = equal();
                setS1(a1);
                setS2(b2);
                boolean bool3 = equal();
                setS1(a2);
                setS2(b1);
                boolean bool4 = equal();

                if ((bool1 && bool2) || (bool3 && bool4)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
