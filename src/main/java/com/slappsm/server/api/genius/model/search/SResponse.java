package com.slappsm.server.api.genius.model.search;

import java.util.List;

public class SResponse {
    List<SRHit> hits;

    public List<SRHit> getHits() {
        return hits;
    }

    public void setHits(List<SRHit> hits) {
        this.hits = hits;
    }
}
