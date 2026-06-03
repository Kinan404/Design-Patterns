package com.mycompany.software_modeling.Beheivoral_Design_atterns;

import java.util.ArrayList;
import java.util.List;

public class Medator {

    interface ChatMediator {

        public void sendMessage(String msg, User user);

        void addUser(User user);
    }

    public abstract class User {

        protected ChatMediator medator;
        protected String name;

        public User(String n, ChatMediator m) {
            this.name = n;
            this.medator = m;
        }

        public abstract void send(String msg);

        public abstract void receive(String msg);
    }

    public class ChatMediatorImpl implements ChatMediator {

        private List<User> users;

        public ChatMediatorImpl() {
            this.users = new ArrayList<>();
        }

        public void addUser(User user) {
            this.users.add(user);
        }

        public void sendMessage(String msg, User user) {
            for (User u : users) {
                if (u != user) {
                    u.receive(msg);
                }
            }
        }
    }

    public class UserImpl extends User {

        public UserImpl(ChatMediator med, String name) {
            super(name, med);
        }

        @Override
        public void send(String msg) {
            System.out.println(this.name + ": Sending Message=" + msg);
            this.medator.sendMessage(msg, this);
        }

        @Override
        public void receive(String msg) {
            System.out.println(this.name + ": Received Message:" + msg);

        }

    }

    public void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        User user1 = new UserImpl(mediator, "Pankaj");
        User user2 = new UserImpl(mediator, "Lisa");
        User user3 = new UserImpl(mediator, "Saurabh");
        User user4 = new UserImpl(mediator, "David");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);
        user1.send("Hi All");
    }
}
