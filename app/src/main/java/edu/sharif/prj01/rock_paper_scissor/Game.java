package edu.sharif.prj01.rock_paper_scissor;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

import edu.sharif.prj01.MainActivity;
import edu.sharif.prj01.rock_paper_scissor.Msg;
import edu.sharif.prj01.rock_paper_scissor.Player;

public class Game extends Thread {
    private Player p1;
    private Player p2;
    private Msg msg;
    private int remainingTurns = 10;

    public Game(Player p1, Player p2, Msg msg) {
        this.p1 = p1;
        this.p2 = p2;
        this.msg = msg;
    }

    @Override
    public void run() {
        while (remainingTurns > 0) {
            CountDownLatch latch = new CountDownLatch(2);
            p1.setLatch(latch);
            p2.setLatch(latch);
            msg.setTask(Task.PLAY);
            synchronized (msg) {
                msg.notifyAll();
            }
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(MainActivity.TAG, "RockPaperScissor ]]>> " + p1.getWeapon() + " " + p2.getWeapon());
            msg.setTask(Task.READY);
            remainingTurns--;
        }
    }
}
