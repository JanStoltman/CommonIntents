package com.yggdralisk.commonintents.file

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import com.yggdralisk.commonintents.utils.ActivityUtils
import com.yggdralisk.commonintents.utils.PermissionsUtils
import com.yggdralisk.commonintents.utils.maybeAddCategory

/**
 * Created by Jan Stoltman on 6/10/18.
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)
class OpenFileIntent {
    companion object {
        private const val INTENT_ACTION = Intent.ACTION_OPEN_DOCUMENT

        fun create(mimeType:String, extraMimeTypes: Array<String> = arrayOf(), allowMultiple: Boolean = false,
                   localOnly:Boolean = true, onlyOpenable: Boolean = false): Intent =
                Intent(INTENT_ACTION).setType(mimeType).
                        putExtra(Intent.EXTRA_MIME_TYPES, extraMimeTypes)
                        .putExtra(Intent.EXTRA_ALLOW_MULTIPLE, allowMultiple)
                        .putExtra(Intent.EXTRA_LOCAL_ONLY, localOnly)
                        .maybeAddCategory(Intent.CATEGORY_OPENABLE, onlyOpenable)

        fun resolveActivity(pm: PackageManager): Boolean =
                ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION))
    }
}