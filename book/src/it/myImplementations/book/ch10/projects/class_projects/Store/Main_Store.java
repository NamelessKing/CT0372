package it.myImplementations.book.ch10.projects.class_projects.Store;

public class Main_Store {

    public static void main(String[] args) {


        System.out.println();
        System.out.println();
        System.out.println();


        Storage<Item<String,Integer>> storage = new Storage<>();
        storage.add(new Item<>("Uno",1));
        storage.add(new Item<>("due",22));
        storage.add(new Item<>("tre",3));
        storage.add(new Item<>("quatro",4));


        System.out.println("ORDINAMENTO DI DEFOULT CON IL COMPARATORE FATTO NELLA CLASSE ITEM CHE IMPLEMENTA COMPARABLE");
        storage.itemArrayList.sort((o1, o2) -> o1.getKey().compareToIgnoreCase(o2.getKey()));
        System.out.println(storage);


        System.out.println();


        System.out.println("ORDINAMENTO CON UN COMPARATORE FATTO DA ME");
        storage.itemArrayList.sort((o1, o2) -> o1.getKey().compareToIgnoreCase(o2.getKey()));
        System.out.println(storage);


        System.out.println();

        System.out.println("STAMPA IN BASE A UNA CONDIZIONE CHE PASSO TRAMITE LAMBDA");
        System.out.println(storage.printConditionaly(
                (o) -> ((Item) o ).getKey().contains("e")
        ));


        System.out.println();


        System.out.println("USO DI \"COLLECTION\".FOREACH(lambda) ");
        Storage<Item<String,Integer>> storage2 = new Storage<>();

        storage.forEach((item) -> {
            if(item.getValue() < 22)
                storage2.add(item);
        });

        System.out.println(storage2);



        System.out.println();


        System.out.println("USO DI STREAM");
        Storage<Item<String,Integer>> storage3 = new Storage<>();

        storage.itemArrayList.stream()
                .filter((item) -> item.getValue() < 4)
                .forEach(storage3::add);

        System.out.println(storage3);


        System.out.println();

        System.out.println("RIMUOVERE DATI");
        storage2.itemArrayList.removeIf(
                (item) -> item.getValue() <= 3
        );

        System.out.println(storage2);



        System.out.println();

        System.out.println("RIMUOVERE DATI CON IL MIO METODO");

        Storage<Item<String,Integer>> storage4 = new Storage<>();
        storage4.add(new Item<>("Uno",1));
        storage4.add(new Item<>("due",22));
        storage4.add(new Item<>("tre",3));
        storage4.add(new Item<>("quatro",4));

        Storage<Item<String,Integer>> storage5 = new Storage<>();

        storage4.performActions(
                (o) -> ((int)(((Item) o).getValue())) >= 3,
                (o) -> storage5.add((Item)o)
        );

        System.out.println(storage5);











    }
}
