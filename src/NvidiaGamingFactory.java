public class NvidiaGamingFactory implements GamingFactory {

    @Override
    public GPU createGPU() {
        return new NvidiaGPU();
    }

    @Override
    public Monitor createMonitor() {
        return new NvidiaMonitor();
    }
}