package it.myImplementations.book.ch10.projects.class_projects.Store;

import org.jetbrains.annotations.NotNull;

public class Item <k extends String,v extends Comparable<v>>implements Comparable<Item<k,v>> {

    private k key;
    private v value;


    public Item(k key, v value) {
        this.key = key;
        this.value = value;
    }


    public k getKey() {
        return key;
    }

    public v getValue() {
        return value;
    }


    @Override
    public int compareTo(@NotNull Item o) {
        return value.compareTo((v) o.value);
    }


    @Override
    public boolean equals(Object obj) {
        // self check
        if (this == obj)
            return true;
        // null check
        if (obj == null)
            return false;
        // type check and cast
        if (getClass() != obj.getClass())
            return false;
        Item item = (Item) obj;
        // field comparison
        return key.equalsIgnoreCase(item.key);
    }


    @Override
    public String toString() {
        return "Item{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
