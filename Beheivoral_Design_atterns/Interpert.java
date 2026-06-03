/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.software_modeling.Beheivoral_Design_atterns;

public class Interpert {

    interface Expression {

        boolean interpert(String context);
    }

    public class TerminalExpression implements Expression {

        String data;

        public TerminalExpression(String d) {
            this.data = d;
        }

        public boolean interpert(String c) {
            if (data.contains(c)) {
                return true;
            } else {
                return false;
            }
        }
    }
    public class Orexpression implements Expression {
        Expression ex1 = null;
        Expression ex2 = null;
        Orexpression(Expression e1, Expression e2) {
            this.ex1 = e1;
            this.ex2 = e2;
        }
        public boolean interpert(String s) {
            return ex1.interpert(s) || ex2.interpert(s);
        }
    }


   // Rule: Robert and John are male
   public  Expression getMaleExpression(){
      Expression robert = new TerminalExpression("Robert");
      Expression john = new TerminalExpression("John");
      return new Orexpression(robert, john);  
   }

   public  void main(String[] args) {
      Expression isMale = getMaleExpression();
      System.out.println("John is male? " + 
                         isMale.interpert("John"));
   }
}    

