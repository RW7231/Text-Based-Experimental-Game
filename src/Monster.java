public class Monster {

    public int Health, Attack, AC, Defense, Type, soulValue, CurrentRoll;

    public Monster(int Health, int Attack, int AC, int Defense, int Type, int soulValue){
        this.Health = Health;
        this.Attack = Attack;
        this.AC = AC;
        this.Defense = Defense;
        this.Type = Type;
        this.soulValue = soulValue;
        this.CurrentRoll = ((int) (Math.random() * 19) + 1) + Type;
    }

    public boolean monsterTime(int time){
        CurrentRoll -= time;
        if(CurrentRoll <= 0){
            System.out.println("Before you can act, the monster attacks!\n");
            CurrentRoll = ((int) (Math.random() * 19) + 1) + Type;
            return true;
        }
        return false;
    }

}
