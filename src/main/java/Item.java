//[Нельзя изменять класс]
abstract class Item {
    String name;
    int attack;
    int defence;
    Item(String name, int attack, int defence) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
    }
}
