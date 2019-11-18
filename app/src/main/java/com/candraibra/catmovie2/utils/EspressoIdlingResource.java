/*
 * *
 *  * Created by Candra Ibra Sanie on 11/18/19 10:57 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/15/19 11:11 AM
 *
 */

package com.candraibra.catmovie2.utils;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;

public class EspressoIdlingResource {
    private static final String RESOURCE = "GLOBAL";
    private static CountingIdlingResource espressoTestIdlingResource = new CountingIdlingResource(RESOURCE);

    public static void increment() {
        espressoTestIdlingResource.increment();
    }

    public static void decrement() {
        espressoTestIdlingResource.decrement();
    }

    public static IdlingResource getEspressoIdlingResource() {
        return espressoTestIdlingResource;
    }
}
