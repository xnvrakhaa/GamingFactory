public class NvidiaGPUCreator extends GPUCreator {

    @Override
    public GPU createGPU() {
        return new NvidiaGPU();
    }
}