class H2O {

    Semaphore hydrogen = new Semaphore(2);
    Semaphore oxygen = new Semaphore(0);

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen)
            throws InterruptedException {

        hydrogen.acquire();

        releaseHydrogen.run();

        if (hydrogen.availablePermits() == 0) {
            oxygen.release();
        }
    }

    public void oxygen(Runnable releaseOxygen)
            throws InterruptedException {

        oxygen.acquire();

        releaseOxygen.run();

        hydrogen.release(2);
    }
}