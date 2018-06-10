package com.yggdralisk.commonintents.contacts

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.ContactsContract.CommonDataKinds.Phone
import com.yggdralisk.commonintents.utils.ActivityUtils
import com.yggdralisk.commonintents.utils.PermissionsUtils

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class SelectSpecificContactDataIntent {
    companion object {
        private const val INTENT_ACTION = Intent.ACTION_PICK

        fun create(mimeType: String = Phone.CONTENT_TYPE): Intent = Intent(INTENT_ACTION).setType(mimeType)

        fun resolveActivity(pm: PackageManager): Boolean = ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION))
    }
}