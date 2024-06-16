package com.example.workmanagerapp;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {

    Data data = getInputData();
    int countingLomit = data.getInt("max_limit", 0);


    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        for (int i = 0; i < countingLomit; i++){
            Log.i("MyWorker", "doWork: " + i);
        }

        Data dataToSend = new Data.Builder()
                .putString("msg","Task Done Successfully").build();


        return Result.success(dataToSend);
    }
}
