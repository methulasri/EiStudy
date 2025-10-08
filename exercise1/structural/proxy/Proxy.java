package exercise1.structural.proxy;

// Subject
interface Drone {
    void executeCommand(String command);
}

// Real Subject
class RealDrone implements Drone {
    private String id;

    public RealDrone(String id) {
        this.id = id;
        System.out.println("Drone " + id + " activated.");
    }

    @Override
    public void executeCommand(String command) {
        System.out.println("Drone " + id + " executing: " + command);
    }
}

// Proxy
class DroneProxy implements Drone {
    private RealDrone drone;
    private String id;
    private boolean authorized;

    public DroneProxy(String id, boolean authorized) {
        this.id = id;
        this.authorized = authorized;
    }

    @Override
    public void executeCommand(String command) {
        if (!authorized) {
            System.out.println("Unauthorized! Drone " + id + " command denied: " + command);
            return;
        }

        // Lazy initialization
        if (drone == null) {
            drone = new RealDrone(id);
        }

        System.out.println("Proxy logging command: " + command);
        drone.executeCommand(command);
    }
}

// Demo
public class Proxy {
    public static void main(String[] args) {
        Drone authorizedDrone = new DroneProxy("DR-01", true);
        Drone unauthorizedDrone = new DroneProxy("DR-02", false);

        authorizedDrone.executeCommand("Deliver Package to Zone A");
        unauthorizedDrone.executeCommand("Deliver Package to Zone B");
        authorizedDrone.executeCommand("Return to Base");
    }
}
