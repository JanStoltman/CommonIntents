package com.yggdralisk.commonintents.contacts

import android.content.Intent
import android.content.pm.PackageManager
import android.provider.ContactsContract.*
import com.yggdralisk.commonintents.utils.ActivityUtils

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class InsertContactIntent {
    companion object {
        private const val INTENT_ACTION = Intent.ACTION_INSERT
        private const val INSERT_CONTACT_MIME_TYPE = Contacts.CONTENT_TYPE

        fun create(): Intent = Intent(INTENT_ACTION).setType(INSERT_CONTACT_MIME_TYPE)

        fun resolveActivity(pm: PackageManager): Boolean = ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION))
    }
}