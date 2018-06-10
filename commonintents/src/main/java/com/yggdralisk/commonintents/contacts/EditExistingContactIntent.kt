package com.yggdralisk.commonintents.contacts

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.yggdralisk.commonintents.utils.ActivityUtils
import com.yggdralisk.commonintents.utils.PermissionsUtils

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class EditExistingContactIntent {
    companion object {
        private const val INTENT_ACTION = Intent.ACTION_EDIT

        fun create(contactUri: Uri): Intent = Intent(INTENT_ACTION).setData(contactUri)

        fun resolveActivity(pm: PackageManager): Boolean = ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION))
    }
}