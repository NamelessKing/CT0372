package it.myImplementations.class_exercises.Comparisons;

public class User implements Comparable<User>{
    
    private String userName;
    private int age;

    public User(String userName, int age) {
        if(age<0)
            throw new IllegalArgumentException("The age annot be negative");
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return "Username: "+userName+"\tAge:"+age;
    }
    
    @Override
    public int compareTo(User o){
        if(this.age<o.age)
            return -1;
        if(this.age>o.age)
            return 1;
        return 0;
    }
    
}
