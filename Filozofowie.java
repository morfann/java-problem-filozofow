public class Filozofowie {

    public static void main(String[] args) throws Exception {

        Filozof[] filozofowie = new Filozof[5];
        Object[] widelce = new Object[filozofowie.length];

        for (int i = 0; i < widelce.length; i++) {
            widelce[i] = new Object();
        }

        for (int i = 0; i < filozofowie.length; i++) {

            Object lewyWidelec = widelce[i];
            Object prawyWidelec = widelce[(i + 1) % widelce.length];

            if (i == filozofowie.length - 1) {
                filozofowie[i] = new Filozof(prawyWidelec, lewyWidelec);
            } else {
                filozofowie[i] = new Filozof(lewyWidelec, prawyWidelec);
            }

            Thread t = new Thread(filozofowie[i], "Filozof " + (i + 1));
            t.start();
        }
    }
}