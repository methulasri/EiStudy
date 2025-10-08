package exercise1.behavioral.stratergy;

import java.util.*;

// Context: StudentEvaluation
class StudentEvaluation {
    private EvaluationStrategy strategy;

    public StudentEvaluation(EvaluationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(EvaluationStrategy strategy) {
        this.strategy = strategy;
    }

    public double evaluate(Student student) {
        return strategy.evaluate(student);
    }
}

// Strategy Interface
interface EvaluationStrategy {
    double evaluate(Student student);
}

// Concrete Strategies
class CodingSkillStrategy implements EvaluationStrategy {
    @Override
    public double evaluate(Student student) {
        return student.codingSkill * 0.7 + student.communicationSkill * 0.3;
    }
}

class GPAWeightedStrategy implements EvaluationStrategy {
    @Override
    public double evaluate(Student student) {
        return student.gpa * 0.8 + student.codingSkill * 0.2;
    }
}

class CommunicationFirstStrategy implements EvaluationStrategy {
    @Override
    public double evaluate(Student student) {
        return student.communicationSkill * 0.6 + student.codingSkill * 0.4;
    }
}

// Student class
class Student {
    String name;
    double gpa;
    double codingSkill;      // 0-10
    double communicationSkill; // 0-10

    Student(String name, double gpa, double codingSkill, double communicationSkill) {
        this.name = name;
        this.gpa = gpa;
        this.codingSkill = codingSkill;
        this.communicationSkill = communicationSkill;
    }

    @Override
    public String toString() {
        return name + " (GPA: " + gpa + ", Coding: " + codingSkill + ", Comm: " + communicationSkill + ")";
    }
}

// Demo
public class Stratergy {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 9.0, 8.5, 7.0),
                new Student("Bob", 8.5, 9.0, 6.5),
                new Student("Carol", 9.2, 7.5, 8.5)
        );

        StudentEvaluation evaluation = new StudentEvaluation(new CodingSkillStrategy());

        System.out.println("=== Evaluating students for Backend Company ===");
        students.forEach(s -> System.out.println(s + " => Score: " + evaluation.evaluate(s)));

        evaluation.setStrategy(new GPAWeightedStrategy());
        System.out.println("\n=== Evaluating students for Academia-Oriented Company ===");
        students.forEach(s -> System.out.println(s + " => Score: " + evaluation.evaluate(s)));

        evaluation.setStrategy(new CommunicationFirstStrategy());
        System.out.println("\n=== Evaluating students for Client-Facing Company ===");
        students.forEach(s -> System.out.println(s + " => Score: " + evaluation.evaluate(s)));
    }
}
