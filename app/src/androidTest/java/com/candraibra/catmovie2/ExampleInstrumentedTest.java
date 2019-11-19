/*
 * *
 *  * Created by Candra Ibra Sanie on 11/19/19 7:33 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/19/19 7:32 AM
 *
 */

package com.candraibra.catmovie2;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.candraibra.catmovie2.debug", appContext.getPackageName());
    }
}
