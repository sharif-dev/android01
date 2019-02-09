public class Game extends Thread {
    private Player p1;
    private Player p2;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void run() {
        while (true) {
            Log.i(MainActivity.TAG, "-------------------------------------------");
            Log.i(MainActivity.TAG, "RockPaperScissor ]]>> p1: " + p1.getWeapon());
            Log.i(MainActivity.TAG, "RockPaperScissor ]]>> p2: " + p2.getWeapon());
            try {
                synchronized (p1) {
                    p1.eraseWeapon();
                    p1.notify();
                    p1.wait();
                }
                synchronized (p2) {
                    p2.eraseWeapon();
                    p2.notify();
                    p2.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
