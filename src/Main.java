public class Main {

    public static void main(String[] args) {

        GamingFactory nvidiaFactory = new NvidiaGamingFactory();

        GPU nvidiaGPU = nvidiaFactory.createGPU();
        Monitor nvidiaMonitor = nvidiaFactory.createMonitor();

        System.out.println("=== NVIDIA Gaming Setup ===");
        nvidiaGPU.showInfo();
        nvidiaMonitor.showInfo();

        System.out.println();

        GamingFactory amdFactory = new AMDGamingFactory();

        GPU amdGPU = amdFactory.createGPU();
        Monitor amdMonitor = amdFactory.createMonitor();

        System.out.println("=== AMD Gaming Setup ===");
        amdGPU.showInfo();
        amdMonitor.showInfo();
    }
}