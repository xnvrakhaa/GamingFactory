public class AMDGPUCreator extends GPUCreator {

    @Override
    public GPU createGPU() {
        return new AMDGPU();
    }
}