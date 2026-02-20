package net.reformed.SanityAwakening.sanity;

public interface ISanity {
    int get();

    int getSanity();
    void setSanity(int value);

    void addSanity(int value);
    void removeSanity(int amount);

    int getMaxSanity();
}