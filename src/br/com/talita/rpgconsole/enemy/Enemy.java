package br.com.talita.rpgconsole.enemy;

import br.com.talita.rpgconsole.hero.Hero;

public class Enemy {
    
    private String name;
    private Integer level;
    private Integer hp;
    private Integer atk;
    
    public Enemy(String name, Integer level){
        this.name = name;
        this.level = level;
        
        this.hp = 20*level;
        this.atk = 1*level;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Integer getHp(){
        return this.hp;
    }
    
    public void takeDamage(Integer damage){
        this.hp -= damage;
    }

    public void attack(Hero hero) {
        hero.takeDamage(this.atk); //hero take damge for attack enemy
    }
}
