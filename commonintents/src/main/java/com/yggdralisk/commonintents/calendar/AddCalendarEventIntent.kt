package com.yggdralisk.commonintents.calendar

import android.content.Intent
import android.content.pm.PackageManager
import android.provider.CalendarContract
import android.provider.CalendarContract.Events
import com.yggdralisk.commonintents.utils.ActivityUtils

/**
 * Created by Jan Stoltman on 6/9/18.
 */
class AddCalendarEventIntent {
    companion object {
        const val CALENDAR_EVENT_MIME_TYPE = "vnd.android.cursor.dir/event"

        fun create(title: String, beginTime: Long, endTime: Long, allDay: Boolean = false,
                   description: String? = null, location: String? = null, emails: Array<String>? = null): Intent {
            val intent = Intent(Intent.ACTION_INSERT)
                    .setData(Events.CONTENT_URI)
                    .setType(CALENDAR_EVENT_MIME_TYPE)
                    .putExtra(Events.ALL_DAY, allDay)
                    .putExtra(Events.TITLE, title)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime)
                    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime)

            location?.let { intent.putExtra(Events.EVENT_LOCATION, location) }
            emails?.let { intent.putExtra(Intent.EXTRA_EMAIL, emails) }
            description?.let { intent.putExtra(Events.DESCRIPTION, description) }

            return intent
        }

        fun resolveActivity(pm: PackageManager) = ActivityUtils.resolveActivity(pm,
                Intent(Intent.ACTION_INSERT).setData(Events.CONTENT_URI).setType(CALENDAR_EVENT_MIME_TYPE))
    }
}