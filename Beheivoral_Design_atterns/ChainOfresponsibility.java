/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.software_modeling.Beheivoral_Design_atterns;

public class ChainOfresponsibility {

    public class chain {

    }

    abstract class handler {

        handler nexthandler;

        handler(handler h) {
            this.nexthandler = h;
        }

        public void handlerequest(int number) {
            if (nexthandler != null) {
                nexthandler.handlerequest(number);
            }
        }

    }

    class Negativehandler extends handler {

        Negativehandler(handler h) {
            super(h);
        }

        public void handlerequest(int number) {
            if (number < 0) {
                System.out.println("Yes it is negative");
            } else {
                super.handlerequest(number);
            }
        }
    }

    class Zerohandler extends handler {

        Zerohandler(handler h) {
            super(h);
        }

        public void handlerequest(int number) {
            if (number == 0) {
                System.out.println("Yes it is negative");
            } else {
                super.handlerequest(number);
            }
        }
    }

    class Posativehandler extends handler {

        Posativehandler(handler h) {
            super(h);
        }

        public void handlerequest(int number) {
            if (number > 0) {
                System.out.println("Yes it is positave");
            } else {
                super.handlerequest(number);
            }
        }
    }

    public class chainn {

        public handler chain;

        chainn() {
            buildchain();
        }

        public void buildchain() {
            chain = new Negativehandler(
                    new Zerohandler(
                            new Posativehandler(null)));
        }

        public void process(int request) {
            chain.handlerequest(request);
        }
    }

    public void main(String[] args) {

        
        chainn chain = new chainn();
        chain.process(-100);
        
        
        
        
    }
}
