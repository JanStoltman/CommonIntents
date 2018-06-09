package com.yggdralisk.commonintentsapp

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yggdralisk.commonintents.AlarmClockIntents.SetAlarmIntent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SetAlarmIntent.create("", 0, 0)
    }
}
