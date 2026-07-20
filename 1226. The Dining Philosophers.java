import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    private Semaphore[] forks;
    private Semaphore limit;

    public DiningPhilosophers() {
        forks = new Semaphore[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }

       
        limit = new Semaphore(4);
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        limit.acquire();

        forks[left].acquire();
        forks[right].acquire();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        forks[left].release();
        forks[right].release();

        limit.release();
    }
}
