public class AMDGamingFactory implements GamingFactory {

    @Override
    public GPU createGPU() {
        return new AMDGPU();
    }

    @Override
    public Monitor createMonitor() {
        return new AMDMonitor();
    }
}