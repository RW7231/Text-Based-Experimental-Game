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
                    "4. Evade\n" +
                    "5. Parry\n" +
                    "6. Run while you can\n");

            System.out.println("Your Current Stats:\n" +
                    "Health: " + player.currentHealth + "/" + player.maxHealth + "\n" +
                    "Stamina: " + playerStam + "/" + player.maxStamina + "\n");

            System.out.println("Debug: Time until monster turn\n" + foe.CurrentRoll);

            int playerChoice = inputter.selection(6);

            switch(playerChoice){
                case 1:
                    if(playerStam >= 10){
                        monsterTurn(1);
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
                        monsterTurn(2);
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
                    monsterTurn(5);
                    playerStam += 30;
                    break;
                case 4:
                    if(playerStam >= 10){
                        if(foe.monsterTime(5)){
                            System.out.println("But you anticipated this, you easily jump out of the way!\n");
                        } else{
                            System.out.println("You evade away from the monster, but no attack comes...\n");
                        }
                        playerStam -= 10;
                    } else{
                        System.out.println("You are too tired to jump out of the way!\n");
                    }

                    break;
                case 5:
                    if(playerStam >= 10){
                        if(foe.monsterTime(1)){
                            System.out.println("You perfectly deflect your foe's blow, knocking them off balance!\n");
                            foe.CurrentRoll = foe.CurrentRoll*2;
                        } else{
                            System.out.println("You tense up, raising your defenses in anticipation for an attack... but nothing happens\n");
                        }
                        playerStam -= 10;
                    } else{
                        System.out.println("You are too tired to protect yourself!\n");
                    }
                    break;
                case 6:
                    if(playerStam <= 50){
                        System.out.println("You don't have enough endurance to outrun this thing!\n");
                    } else if (doWeRun()) {
                        monsterTurn(10);
                        if(player.currentHealth >= 1){
                            System.out.println("You start to run,,, and you think you did it! \n");
                            return true;
                        } else{
                            System.out.println("You start to run... but something is wrong...\n");
                        }
                    }
                    break;
                default:
                    System.out.println("This is not a valid choice\n");
            }

            if (player.currentHealth <= 0) {
                System.out.println("You collapse in a pool of your own blood");
                return false;
            } else if(foe.Health <= 0){
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

    private void monsterTurn(int time){
        if(foe.monsterTime(time)){
            if(doesAttackHit(player.AC)){
                System.out.println("The monster attacks you for " + monsterAttack() + " damage!\n");
            } else{
                System.out.println("But you manage to evade at last minute!");
            }
        }
    }
}
