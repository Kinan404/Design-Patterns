package com.mycompany.software_modeling.Beheivoral_Design_atterns;

public class Iterator {

    interface iterator {

        public boolean hasNext();

        public Object next();
    }

    interface container {

        iterator getIterator();
    }

    public class NameRepository implements container {

        public String names[] = {"Ali", "Sara", "John", "Robert"};

        public iterator getIterator() {
            return new NameIterator();
        }

        class NameIterator implements iterator {

            int index;

            public boolean hasNext() {
                return index < names.length;
            }

            public Object next() {
                if (this.hasNext()) {
                    return names[index++];
                }
                return null;
            }
        }    
      
    }
    public void main(String[] args) {
        
        NameRepository res = new NameRepository();
        for(iterator ite = res.getIterator(); ite.hasNext();){
            System.out.println("Name is " + (String)ite.next());
        }
        
        
        
        
    }

}
