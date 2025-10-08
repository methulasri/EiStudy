package exercise2;


import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

// User class
class User {
    private String username;
    private String userId;

    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return username;
    }
}

// Message class
class Message {
    private User sender;
    private String text;
    private LocalDateTime timestamp;

    public Message(User sender, String text) {
        this.sender = sender;
        this.text = text;
        this.timestamp = LocalDateTime.now();
    }

    public User getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + sender.getUsername() + "]: " + text;
    }
}

// ChatRoom class
class ChatRoom {
    private String roomId;
    private List<User> activeUsers;

    public ChatRoom(String roomId) {
        this.roomId = roomId;
        this.activeUsers = new ArrayList<>();
    }

    public String getRoomId() {
        return roomId;
    }

    public List<User> getActiveUsers() {
        return activeUsers;
    }

    public void addUser(User user) {
        activeUsers.add(user);
    }

    public void removeUser(User user) {
        activeUsers.remove(user);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create users
        User user1 = new User("u1", "Alice");
        User user2 = new User("u2", "Bob");
        User user3 = new User("u3", "Charlie");

        // Create a chat room
        ChatRoom room = new ChatRoom("Room123");

        // Add users to chat room
        room.addUser(user1);
        room.addUser(user2);
        room.addUser(user3);

        // Display active users
        System.out.println("Active users in " + room.getRoomId() + ": " + room.getActiveUsers());
    }
}

