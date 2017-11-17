package ru.job4j.max;

public class Max {
    public int max(int first, int second) {
        int ret = 0;
        ret = first > second ? first : second;
        return ret;
    }

    public int max(int first, int second, int third) {
        return max (max (first,second), third);
    }
}


