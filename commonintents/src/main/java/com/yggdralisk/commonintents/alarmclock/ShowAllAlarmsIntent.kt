package com.yggdralisk.commonintents.alarmclock

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.AlarmClock
import android.support.annotation.RequiresApi
import com.yggdralisk.commonintents.utils.ActivityUtils

/**
 * Created by Jan Stoltman on 6/9/18.
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)
class ShowAllAlarmsIntent {
    companion object {
        private const val INTENT_ACTION = AlarmClock.ACTION_SHOW_ALARMS

        fun create(message: String = "", length: Int, skipUI: Boolean = false): Intent = Intent(INTENT_ACTION)

        fun resolveActivity(pm: PackageManager) = ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION))
    }
}