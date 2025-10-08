# Ei Study

This repository contains Java exercises and study material focused on **Object-Oriented Design Patterns** and related programming concepts.  

## 📂 Project Structure  

```
Ei Study/
│── readme.md                 # Existing notes/documentation
│── exercise2/                # Chatroom application
│   ├── Main.java             # Entry point
│   ├── User.class
│   ├── ChatRoom.class
│   ├── Message.class
│
└── study/
    └── exercise1/            # Design pattern exercises
        ├── behavioral/
        │   ├── observer/     # Observer Pattern Example
        │   └── stratergy/    # Strategy Pattern Example
        │
        ├── creational/
        │   ├── factory/      # Factory Pattern Example
        │   └── singleton/    # Singleton Pattern Example
        │
        └── structural/
            ├── decorator/    # Decorator Pattern Example
            └── proxy/        # Proxy Pattern Example
```

## 🚀 How to Run  

1. **Clone the repo** (or extract the ZIP).  
   ```bash
   git clone <repo-url>
   cd "Ei Study"
   ```

2. **Compile the Java files** (from the root folder).  
   ```bash
   javac exercise2/*.java study/exercise1/*/*/*.java
   ```

3. **Run an exercise** (for example, the chatroom app).  
   ```bash
   java exercise2.Main
   ```

   Or run a specific design pattern demo, e.g.:  
   ```bash
   java study.exercise1.behavioral.observer.Observer
   ```

## 📘 Covered Topics  

- **Behavioral Patterns**
  - Observer
  - Strategy  

- **Creational Patterns**
  - Factory
  - Singleton  

- **Structural Patterns**
  - Decorator
  - Proxy  

- **Mini-Project**
  - Simple Chatroom with users and messages  

## 🛠 Requirements  

- Java JDK 8+  
- A terminal or IDE (IntelliJ / Eclipse / VS Code with Java extension)  

## ✨ Notes  

- This repo is meant for **learning and practice**.  
- Each folder represents a separate concept — you can compile and run them independently.  
- Some `.class` files are included, but you should recompile from `.java` files for a clean run.  
