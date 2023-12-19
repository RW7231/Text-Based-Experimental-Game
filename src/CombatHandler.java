public class CombatHandler {

    Character player;
    Monster foe;

    public CombatHandler(Character player, Monster foe){
        this.player = player;
        this.foe = foe;
    }

    public boolean combatMode(Inputter inputter){

        int playerStam = player.maxStamina;

        while(true){
            System.out.println("You are faced with a monster which intends to take your life \n" +
                    "What shall you do?\n" +
                    "1. Light Attack\n" +
                    "2. Heavy Attack\n" +
                    "3. Take a moment to catch your breath\n" +
                    "4. Run while you can\n");

            int playerChoice = inputter.selection(4);

            switch(playerChoice){
                case 1:
                    if(playerStam >= 10){
                        if(doesAttackHit(foe.AC)){
                            System.out.println("You strike your foe, dealing " + playerAttack(player.attack) + " damage\n");
                        } else{
                            System.out.println("You swing at your foe, but miss your mark\n");
                        }
                        playerStam -= 10;
                    }else{
                        System.out.println("You are too tired for this action\n");
                    }
                    break;
                case 2:
                    if(playerStam >= 20){
                        if(doesAttackHit(foe.AC)){
                            System.out.println("You strike your foe, dealing " + playerAttack((int) (player.attack * 1.5)) + " damage\n");
                        } else{
                            System.out.println("You swing at your foe, but miss your mark\n");
                        }
                        playerStam -= 20;
                    }else{
                        System.out.println("You are too tired for this action\n");
                    }
                    break;
                case 3:
                    playerStam += 30;
                    break;
                case 4:
                    if(playerStam <= 50){
                        System.out.println("You don't have enough endurance to outrun this thing!\n");
                    } else if (doWeRun()) {
                        System.out.println("You start to run,,, and you think you did it! \n");
                        return true;
                    }
                    break;
                default:
                    System.out.println("This is not a valid choice\n");
            }

            if(foe.Health <= 0){
                player.souls += foe.soulValue;
                return true;
            }
        }
    }

    private boolean doesAttackHit(int AC){
        int roll = (int) (Math.random() * 19) + 1;

        return (roll > AC);
    }

    private boolean doWeRun(){
        return true;
    }

    private int playerAttack(int attack){
        int totalDamage = (int) ((float) attack / foe.Defense) * attack;

        foe.Health -= totalDamage;

        return totalDamage;
    }

    private int monsterAttack(){
        int totalDamage = (int) ((float) foe.Attack / player.Defense) * foe.Attack;

        player.currentHealth -= totalDamage;

        return totalDamage;
    }
}
