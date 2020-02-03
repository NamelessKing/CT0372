package it.myImplementations.class_exercises.Comparisons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] argv){
        var users = new ArrayList<User>();
        users.add(new User("Mario",30));
        users.add(new User("Luigi",32));
        users.add(new User("Peach",26));
        users.add(new User("Luigi 2",31));
        users.add(new User("Peach 2",24));
        users.add(new User("Luigi 3",19));
        users.add(new User("Peach 3",21));
        users.add(new User("Toad",4));
        
        Collections.sort(users);
        for(User user : users)
            System.out.println(user);
        
        System.out.println("------------------------");
        
        UserNameComparator cmp = new UserNameComparator();
		
        Collections.sort(users,cmp);
        for(User user : users)
            System.out.println(user);
        System.out.println(cmp.getCounter());
        
        cmp.resetCounter();
        
        Collections.sort(users,cmp);
        for(User user : users)
            System.out.println(user);
        System.out.println(cmp.getCounter());
        
        Collections.sort(users,new Comparator<User>(){
            public int compare(User u1, User u2) {
                return u2.getAge()-u1.getAge();
            }
        });
        for(User user : users)
            System.out.println(user);
        
        Collections.sort(users,(u1,u2)->u2.getAge()-u1.getAge());
        for(User user : users)
            System.out.println(user);
    }
    
}
