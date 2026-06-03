/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.software_modeling.Beheivoral_Design_atterns;

public class Command {

    interface command {

        public void execute();
    }

    // Concreter class 
    public class LightOncommand implements command {

        light l;

        public LightOncommand(light l) {
            this.l = l;
        }

        public void execute() {
            l.lighton();
        }
    }
    public class LightOffcommand implements command {

        light l;

        public LightOffcommand(light l) {
            this.l = l;
        }

        public void execute() {
            l.lightoff();
        }
    }
    // Invoker
    public class remotecontrol{
        command c;
        public void setcommand(command c){
            this.c = c;
        }
        public void pressbutton(){
            this.c.execute();
        }
    }
    // Reciever
    public class light {

        public void lighton() {
            System.out.println("Lign on now");
        }

        public void lightoff() {
            System.out.println("Lign off now");
        }
    }

    public void main(String[] args) {
        light l = new light();
        LightOffcommand loff = new LightOffcommand(l);
        
        remotecontrol r = new remotecontrol();
        r.setcommand(loff);
        r.pressbutton();
        
    }
}
