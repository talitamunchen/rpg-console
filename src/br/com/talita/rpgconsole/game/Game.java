package br.com.talita.rpgconsole.game;
import br.com.talita.rpgconsole.enemy.Enemy;
import br.com.talita.rpgconsole.hero.Hero;

public class Game {
    
    private Boolean isGameOver;
    private InputHandler inputHandler;
    
    private Hero hero;
    private Enemy enemy;
    
    /** CONTRUCTOR METHOD - inciialize variabe gameOver */
    public Game(){ 
        isGameOver = false;
        inputHandler = new InputHandler();
    } 
    public void gameLoop(){
        hero = createNewHero();
        enemy = createNewEnemy();
        
        while (isGameOver == false){
            System.out.println("Game Loop.");
            
            //verification of hp
            if(hero.getHp() <= 0){
                System.out.println(hero.getName() + " died. You losed!");
                isGameOver = true;
            }else{
                //how plays?
                System.out.println(hero.getName() + "(HP: " + hero.getHp() + "). Your turn!"); //name of heroo
                System.out.println("'x' to quit.");
                System.out.println("'a' attack.");

                //take caracter
                Character c = inputHandler.getChar(); //read char "c"
                if (c.equals('x')){ //
                    isGameOver = true;
                }else if(c.equals('a')){
                    hero.attack(enemy);
                    if(enemy.getHp() <= 0){
                        System.out.println(enemy.getName() + " died!");
                        enemy = createNewEnemy(); //if enemy died, create a new enemy
                    }else{ //if enemy not died, enemy attack hero
                        enemy.attack(hero);
                    }
                }
            }
        }       
    }
    
    private Hero createNewHero(){
        System.out.println("Enter hero name: ");
        String heroName = inputHandler.getString(); //name of hero
        return new Hero(heroName); //instance new hero
    }

    private Enemy createNewEnemy() {
        String name = "Skeleton";
        System.out.println("A " + name + " appeared!");
        Integer level = 1;
        return new Enemy(name, level);
    }
}
