package exercise1.structural.decorator;

// Component
interface AIAssistant {
    void performTask();
}

// Concrete Component
class BasicAssistant implements AIAssistant {
    @Override
    public void performTask() {
        System.out.println("Basic Assistant: Responding to simple queries");
    }
}

// Decorator
abstract class AssistantDecorator implements AIAssistant {
    protected AIAssistant assistant;

    public AssistantDecorator(AIAssistant assistant) {
        this.assistant = assistant;
    }

    @Override
    public void performTask() {
        assistant.performTask();
    }
}

// Concrete Decorators
class LanguageTranslator extends AssistantDecorator {
    public LanguageTranslator(AIAssistant assistant) { super(assistant); }

    @Override
    public void performTask() {
        super.performTask();
        System.out.println("+ Translating languages in real-time");
    }
}

class EmotionDetector extends AssistantDecorator {
    public EmotionDetector(AIAssistant assistant) { super(assistant); }

    @Override
    public void performTask() {
        super.performTask();
        System.out.println("+ Detecting user emotions");
    }
}

class SmartScheduler extends AssistantDecorator {
    public SmartScheduler(AIAssistant assistant) { super(assistant); }

    @Override
    public void performTask() {
        super.performTask();
        System.out.println("+ Scheduling meetings intelligently");
    }
}

class VoiceModulator extends AssistantDecorator {
    public VoiceModulator(AIAssistant assistant) { super(assistant); }

    @Override
    public void performTask() {
        super.performTask();
        System.out.println("+ Modulating voice to match context");
    }
}

// Demo
public class Decorator {
    public static void main(String[] args) {
        AIAssistant assistant = new BasicAssistant();

        // Add features dynamically
        assistant = new LanguageTranslator(assistant);
        assistant = new EmotionDetector(assistant);
        assistant = new SmartScheduler(assistant);
        assistant = new VoiceModulator(assistant);

        // Perform all tasks
        assistant.performTask();
    }
}

