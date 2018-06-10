package com.yggdralisk.commonintents.contacts

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.ContactsContract
import android.provider.ContactsContract.*
import android.provider.MediaStore
import com.yggdralisk.commonintents.utils.ActivityUtils
import com.yggdralisk.commonintents.utils.PermissionsUtils

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class SelectContactIntent {
    companion object {
        private const val INTENT_ACTION = Intent.ACTION_PICK
        private const val SELECT_CONTACT_MIME_TYPE = Contacts.CONTENT_TYPE

        fun create(): Intent = Intent(INTENT_ACTION).setType(SELECT_CONTACT_MIME_TYPE)

        fun resolveActivity(pm: PackageManager): Boolean = ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION))
    }
}