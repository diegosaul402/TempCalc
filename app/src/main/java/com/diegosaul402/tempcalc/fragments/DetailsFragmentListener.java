package com.diegosaul402.tempcalc.fragments;

import com.diegosaul402.tempcalc.temps.TempEntity;

/**
 * Created by diego on 10/11/2016.
 */

public interface DetailsFragmentListener {
    void initList();
    void addToList(TempEntity tempEntity);
    void clearList();
}
