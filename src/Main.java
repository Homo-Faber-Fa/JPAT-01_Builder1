public class Main {
    public static void main(String[] args) {
        try {

            Person mom=new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(31)
                    .setAddress("Сидней")
                    .build();
            Person son=mom.newChildBuilder()
                    .setName("Антошка")
                    .build();
            System.out.println("У " + mom + " есть сын, " + son);

            if (mom.surname == null) throw new IllegalArgumentException("Не указана фамилия");
            if (mom.name == null) throw new IllegalArgumentException("Не указано имя");

        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
