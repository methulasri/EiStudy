package exercise1.creational.singleton;

class MissionControl {
    private static MissionControl instance;

    private MissionControl() {
        System.out.println("Mission Control initialized.");
    }

    public static MissionControl getInstance() {
        if (instance == null) {
            instance = new MissionControl();
        }
        return instance;
    }

    public void launchRocket(String rocketName) {
        System.out.println("🚀 Launching rocket: " + rocketName);
    }

    public void monitorSatellite(String satelliteName) {
        System.out.println("🛰️ Monitoring satellite: " + satelliteName);
    }

    public void sendCommand(String command) {
        System.out.println("📡 Sending command: " + command);
    }
}

// Demo
public class Singleton {
    public static void main(String[] args) {
        MissionControl control1 = MissionControl.getInstance();
        MissionControl control2 = MissionControl.getInstance();

        control1.launchRocket("Apollo 11");
        control2.monitorSatellite("Hubble Telescope");
        control1.sendCommand("Adjust trajectory");

        System.out.println(control1 == control2); // true
    }
}

