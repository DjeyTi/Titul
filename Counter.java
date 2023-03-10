class Counter implements AutoCloseable {
    private int i = 0;

    protected void add() {
        this.i++;
    }

    protected void setCounter(int i) {
        this.i = i;
    }

    protected int getCounter() {
        return i;
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }
}
