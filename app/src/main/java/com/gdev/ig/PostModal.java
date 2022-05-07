package com.gdev.ig;

import java.util.ArrayList;

public class PostModal {
    int total;
    int totalHits;
    ArrayList<Hits> hits;

    public PostModal(int total, int totalHits, ArrayList<Hits> hits) {
        this.total = total;
        this.totalHits = totalHits;
        this.hits = hits;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public ArrayList<Hits> getHits() {
        return hits;
    }
}
