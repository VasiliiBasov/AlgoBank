package ru.algobank.algo.step02;

import java.util.Objects;

public final class ImmutablePoint {
    private final int x;
    private final int y;

    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof  ImmutablePoint)) return false;
        ImmutablePoint that = (ImmutablePoint) o;
        return x == that.x && y == that.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    public String toString() {
        return "Point(x=" + x + ", y=" + y + ")";
    }

    public static void main(String[] args) {
        ImmutablePoint p1 = new ImmutablePoint(5, 6);
        ImmutablePoint p2 = new ImmutablePoint(5, 6);
        ImmutablePoint p3 = new ImmutablePoint(2, 8);
        System.out.println("p1: " + p1 + " p2: " + p2 + " p3: " + p3);
        System.out.println("p1 equals p2? " + p1.equals(p2));
        System.out.println("p1 equals p3? " + p1.equals(p3));
        System.out.println("p1 hash  ==  p2? " + (p1.hashCode()==p2.hashCode()));
        System.out.println("p1 hash  ==  p3? " + (p1.hashCode()==p3.hashCode()));
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
}
