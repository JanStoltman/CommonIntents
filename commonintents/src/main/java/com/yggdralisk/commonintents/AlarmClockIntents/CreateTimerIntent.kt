package com.yggdralisk.commonintents.AlarmClockIntents

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.AlarmClock
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

/**
 * Created by Jan Stoltman on 6/9/18.
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)
class CreateTimerIntent {
    companion object {
        fun create(message: String = "", length: Int, skipUI: Boolean = false): Intent =
                Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                        .putExtra(AlarmClock.EXTRA_LENGTH, length)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, skipUI)


        fun resolveActivity(pm: PackageManager) =
                Intent(AlarmClock.ACTION_SET_ALARM).resolveActivity(pm)

        fun checkPermission(context: Context): Boolean =
                ContextCompat.checkSelfPermission(context, Manifest.permission.SET_ALARM) != PackageManager.PERMISSION_DENIED

        fun askForPermission(activity: Activity, requestCode: Int) =
                ActivityCompat.requestPermissions(activity, arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),
                        requestCode);
    }
}