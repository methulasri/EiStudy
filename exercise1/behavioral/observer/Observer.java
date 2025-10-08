package exercise1.behavioral.observer;

import java.util.*;
import java.util.function.Predicate;

// Subject (Placement Portal)
class PlacementPortal {
    private final List<Subscription> subscriptions = new ArrayList<>();

    // Subscribe with a filter
    void subscribe(Student student, Predicate<Job> filter) {
        subscriptions.add(new Subscription(student, filter));
    }

    void unsubscribe(Student student) {
        subscriptions.removeIf(s -> s.student.equals(student));
    }

    // Post a job and notify relevant students
    void postJob(Job job) {
        System.out.println("\n[New Job] " + job);
        for (Subscription sub : subscriptions) {
            if (sub.filter.test(job)) {
                sub.student.notify(job);
            }
        }
    }

    // Inner class for subscription
    private static class Subscription {
        Student student;
        Predicate<Job> filter;

        Subscription(Student student, Predicate<Job> filter) {
            this.student = student;
            this.filter = filter;
        }
    }
}

// Observer
class Student {
    private final String name;

    Student(String name) {
        this.name = name;
    }

    void notify(Job job) {
        System.out.println(name + " received notification: " + job);
    }
}

// Job class
class Job {
    String company, role, location;
    double ctc;

    Job(String company, String role, String location, double ctc) {
        this.company = company;
        this.role = role;
        this.location = location;
        this.ctc = ctc;
    }

    @Override
    public String toString() {
        return role + " at " + company + " | " + location + " | CTC=" + ctc + "L";
    }
}

// Demo
public class Observer {
    public static void main(String[] args) {
        PlacementPortal portal = new PlacementPortal();

        Student alice = new Student("Methula");
        Student bob = new Student("Babu");
        Student carol = new Student("swetha");

        // Alice wants Backend roles with CTC >= 8
        portal.subscribe(alice, job -> job.role.toLowerCase().contains("backend") && job.ctc >= 8);

        // Bob wants any job in Bengaluru
        portal.subscribe(bob, job -> job.location.equalsIgnoreCase("Bengaluru"));

        // Carol wants Internships anywhere
        portal.subscribe(carol, job -> job.role.toLowerCase().contains("intern"));

        portal.postJob(new Job("Acme Corp", "Backend Engineer", "Bengaluru", 9.0));
        portal.postJob(new Job("BrightAI", "Frontend Developer", "Pune", 7.0));
        portal.postJob(new Job("DeltaApps", "SDE Intern", "Remote", 10.0));
    }
}
