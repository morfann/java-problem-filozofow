public class Filozof implements Runnable {

  private final Object lewyWidelec;
  private final Object prawyWidelec;

  Filozof (Object lewy, Object prawy) {
      this.lewyWidelec = lewy;
      this.prawyWidelec = prawy;
  }

  private void wykonajAkcje(String akcja) throws InterruptedException {
      System.out.println(Thread.currentThread().getName() + " " + akcja);
      Thread.sleep(((int) (Math.random() * 100)));
  }

  @Override
  public void run() {
      try {
          while (true) {
              wykonajAkcje(System.nanoTime() + ": Mysli");
              synchronized (lewyWidelec) {
                  wykonajAkcje(System.nanoTime() + ": Podniosl lewy widelec");
                  synchronized (prawyWidelec) {
                      wykonajAkcje(System.nanoTime() + ": Podniosl prawy widelec - je"); 
                      wykonajAkcje(System.nanoTime() + ": Odlozyl prawy widelec");
                  }
                  wykonajAkcje(System.nanoTime() + ": Odlozyl lewy widelec. Wraca do myslenia");
              }
          }
      } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
      }
  }
}