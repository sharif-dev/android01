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
            try {
                while (p1.getWeapon().equals(Weapon.NONE)) {
                    synchronized (p1) {
                        p1.wait();
                    }
                }
                while (p2.getWeapon().equals(Weapon.NONE)) {
                    synchronized (p2) {
                        p2.wait();
                    }
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(MainActivity.TAG, "-------------------------------------------");
            Log.i(MainActivity.TAG, "RockPaperScissor ]]>> p1: " + p1.getWeapon());
            Log.i(MainActivity.TAG, "RockPaperScissor ]]>> p2: " + p2.getWeapon());
            synchronized (p1) {
                p1.eraseWeapon();
                p1.notify();
            }
            synchronized (p2) {
                p2.eraseWeapon();
                p2.notify();
            }
        }
    }
}
