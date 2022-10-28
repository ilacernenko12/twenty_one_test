class Character {
    private final String name;		//Здоровье персонажа
    private Item[] items;			//Вещи персонажа
    private int health;				//Кол-во здоровья персонажа
    private boolean isAlive = true;	//Признак жизни персонажа (true - жив, false - мертв)
    private int count = 0;
    Character(String name, int health){
        this.name = name;
        this.health = health;
        this.items = new Item[0];
    }

    public void onAttack(Character enemy) {
        int damage = 0;
        if (getDefence()>enemy.getAttack() || getDefence()== enemy.getAttack()){
            damage = 0;
        } else {
            damage = enemy.getAttack() - getDefence();
        }
        this.health -= damage;
        if (this.health < 0) {
            System.out.println(name + " мертв. Атака невозможна.");
        } else if (this.health == 0){
            System.out.println(name + " был атакован " + enemy.name + " на " + damage + ". Осталось жизней: 0. Mage умер.");
        } else {
            System.out.println(name + " был атакован " + enemy.name + " на " + damage + ". Осталось жизней: " + this.health);
        }
    }

    private int getAttack() {
        int attack = 0;
        for (int i = 0; i < items.length; i++) {
            attack+=items[i].attack;
        }
        return attack;
    }

    private int getDefence(){
        int defence = 0;
        for (int i = 0; i < items.length; i++) {
            defence+=items[i].defence;
        }
        return defence;
    }

    public void addItem(Item item) {
        boolean q = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals(item.name)){
                q=true;
            }
        }
        if (q){
            System.out.println("Персонаж не может несколько раз экипировать одну и ту же вещь");
        }else {
            Item[] items1 = this.items;
            this.items = new Item[items1.length + 1];
            for (int i = 0; i < items1.length; i++) {
                this.items[i] = items1[i]; //
            }
            this.items[this.items.length - 1] = item;
            count++;
            System.out.println(this.name + " экипировал " + item.name + ". Кол-во вещей: " + count);
        }
    }

    public void removeItem(Item item) {
        Item [] items2 = new Item[items.length-1];
        boolean a = false;
        for (int i = 0; i < items.length; i++) {
            if ((item.name.equals(items[i].name))){
                a = true;
            }
        }
        if (!a){
            System.out.println("Предмета " + item.name + " нет у " + this.name);
        } else {
            for (int i = 0,  c = 0; i < items.length; i++) {
                if (!(item.name.equals(items[i].name))){
                    items2[c] = items[i];
                    c++;
                }
            }
            this.items = items2;
            count--;
            System.out.println(item.name + " удален у " + this.name + ". Осталось предметов: " + count);
        }
    }

    public Item generateItem(Class clasz, String name, int attack, int defence){
        Item item = null;
        if (Sword.class.equals(clasz)) {
            item = new Sword(name, attack, defence);
        } else if (Mantle.class.equals(clasz)) {
            item = new Mantle(name, attack, defence);
        } else if (Body.class.equals(clasz)) {
            item = new Body(name, attack, defence);
        } else if (Staff.class.equals(clasz)) {
            item = new Staff(name, attack, defence);
        }
        return item;
    }
}
