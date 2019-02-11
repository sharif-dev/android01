package edu.sharif.prj01.rock_paper_scissor;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import edu.sharif.prj01.rock_paper_scissor.Msg;
import edu.sharif.prj01.rock_paper_scissor.Task;

public class Player extends Thread {
    private Weapon weapon;
    private CountDownLatch latch = null;
    private Msg msg;

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public Player(Msg msg) {
        this.msg = msg;
        this.eraseWeapon();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void eraseWeapon() {
        synchronized (this) {
            this.weapon = Weapon.NONE;
        }
    }

    @Override
    public void run() {
        while (true) {
            while(!msg.getTask().equals(Task.PLAY)) {
                try {
                    synchronized (msg) {
                        msg.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(new Random().nextInt(1000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (msg) {
                move();
                try {
                    msg.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void move() {
        Random rand = new Random();
        int move = rand.nextInt(3) + 1;
        synchronized (this) {
            switch (move) {
                case 1:
                    weapon = Weapon.ROCK;
                    break;
                case 2:
                    weapon = Weapon.PAPER;
                    break;
                case 3:
                    weapon = Weapon.SCISSOR;
                    break;
            }
            latch.countDown();
        }
    }
}
