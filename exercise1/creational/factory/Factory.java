package exercise1.creational.factory;

interface VRDevice {
    void connect();
}

class Oculus implements VRDevice {
    @Override
    public void connect() { System.out.println("Connecting Oculus VR headset"); }
}

class HTCVive implements VRDevice {
    @Override
    public void connect() { System.out.println("Connecting HTC Vive VR headset"); }
}

class PlayStationVR implements VRDevice {
    @Override
    public void connect() { System.out.println("Connecting PlayStation VR headset"); }
}

class VRDeviceFactory {
    public static VRDevice createDevice(String type) {
        switch(type.toLowerCase()) {
            case "oculus": return new Oculus();
            case "htcvive": return new HTCVive();
            case "psvr": return new PlayStationVR();
            default: throw new IllegalArgumentException("Unknown VR device type");
        }
    }
}

public class Factory {
    public static void main(String[] args) {
        VRDevice device1 = VRDeviceFactory.createDevice("Oculus");
        VRDevice device2 = VRDeviceFactory.createDevice("HTCVive");
        VRDevice device3 = VRDeviceFactory.createDevice("PSVR");

        device1.connect();
        device2.connect();
        device3.connect();
    }
}
