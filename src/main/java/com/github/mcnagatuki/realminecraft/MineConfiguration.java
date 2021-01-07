package com.github.mcnagatuki.realminecraft;

public class MineConfiguration {
    private int power = 1;
    private BlockPosition pos1 = new BlockPosition(0, 0);
    private BlockPosition pos2 = new BlockPosition(0, 0);
    private double damage = 5.0;
    private double probability = 0.3;
    private boolean activated = false;

    public void setActivated(boolean flag) {
        this.activated = flag;
    }

    public boolean isActivated() {
        return this.activated;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getProbability() {
        return probability;
    }

    public BlockPosition getPos1() {
        return pos1;
    }

    public void setPos1(BlockPosition pos1) {
        this.pos1 = pos1;
    }

    public BlockPosition getPos2() {
        return pos2;
    }

    public void setPos2(BlockPosition pos2) {
        this.pos2 = pos2;
    }
}
