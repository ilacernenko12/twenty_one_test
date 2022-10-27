public class Main {
    //[Нельзя изменять метод]
    public static void main(String[] args)
    {
        // Создаются персонажи
        Character warrior = new Character("Warrior", 100);
        Character mage = new Character("Mage", 90);

        //
        Sword sword = new Sword("Меч света", 24, 1);
        warrior.addItem(sword);
        warrior.addItem(sword);
        warrior.removeItem(sword);
        warrior.addItem(new Body("Доспех смерти", 0, 10));
        warrior.removeItem(sword);
        warrior.addItem(sword);

        mage.addItem(new Staff("Посох ярости", 20, 2));
        mage.addItem(new Mantle("Мантия страха", 0, 4));

        warrior.onAttack(mage);
        warrior.onAttack(mage);
        warrior.onAttack(mage);

        mage.onAttack(warrior);
        mage.onAttack(warrior);
        mage.onAttack(warrior);
        mage.onAttack(warrior);
        mage.onAttack(warrior);
        mage.onAttack(warrior);

        warrior.addItem(warrior.generateItem(Sword.class, "Меч рефлексии", 6, 1));
        //warrior.addItem(warrior.generateItem(Body.class, "Тело рефлексии", 0, 4));
    }
}
