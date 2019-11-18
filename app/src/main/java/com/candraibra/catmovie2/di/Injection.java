/*
 * *
 *  * Created by Candra Ibra Sanie on 11/18/19 10:57 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/18/19 10:24 AM
 *
 */

package com.candraibra.catmovie2.di;

import android.app.Application;

import com.candraibra.catmovie2.data.Repository;
import com.candraibra.catmovie2.service.NetworkCall;

public class Injection {
    public static Repository provideRepository(Application application) {
        NetworkCall networkCall = NetworkCall.getInstance(application);
        return Repository.getInstance(networkCall);
    }
}
