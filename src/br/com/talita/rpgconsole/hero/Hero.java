package br.com.talita.rpgconsole.hero;

import br.com.talita.rpgconsole.enemy.Enemy;

public class Hero {
    
    private String name;
    private Integer  level;
    private Integer hp;
    private Integer atk;
    
    public Hero(String name){ //contruct
        this.name = name;
        this.level = 1;
        this.hp = 10;
        this.atk = 2;        
    }

    public String getName() {
       return this.name;
    }
    
    public Integer getHp(){
        return this.hp;
    }
    
    public void takeDamage(Integer damage){
        this.hp -= damage;
    }

    public void attack(Enemy enemy) { //ATK ENEMY
        enemy.takeDamage(this.atk);
    }
  
}
