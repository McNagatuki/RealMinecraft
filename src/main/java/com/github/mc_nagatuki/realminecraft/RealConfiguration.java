package com.github.mc_nagatuki.realminecraft;

public class RealConfiguration {
    private int power = 1;
    private int x1 = 0, z1 = 0, x2 = 0, z2 = 0;
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

    // ここを別のクラスにした方がいいかもしれない
    public void setPos1(int x, int z) {
        this.x1 = x;
        this.z1 = z;
    }

    public int getX1() {
        return this.x1;
    }

    public int getZ1() {
        return this.z1;
    }

    public void setPos2(int x, int z) {
        this.x2 = x;
        this.z2 = z;
    }

    public int getX2() {
        return this.x2;
    }

    public int getZ2() {
        return this.z2;
    }
}
