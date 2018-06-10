package com.yggdralisk.commonintents.file

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.DocumentsContract
import android.support.annotation.RequiresApi
import com.yggdralisk.commonintents.utils.ActivityUtils
import com.yggdralisk.commonintents.utils.maybeAddCategory
import com.yggdralisk.commonintents.utils.maybePutStringExtra

/**
 * Created by Jan Stoltman on 6/10/18.
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)

class CreateFileIntent {
    companion object {
        private const val INTENT_ACTION = Intent.ACTION_CREATE_DOCUMENT

        fun create(mimeType: String, title: String, extraMimeTypes: Array<String> = arrayOf(), allowMultiple: Boolean = false,
                   localOnly: Boolean = true, onlyOpenable: Boolean = false): Intent =
                Intent(INTENT_ACTION).setType(mimeType)
                        .putExtra(Intent.EXTRA_TITLE, title)
                        .putExtra(Intent.EXTRA_MIME_TYPES, extraMimeTypes)
                        .putExtra(Intent.EXTRA_ALLOW_MULTIPLE, allowMultiple)
                        .putExtra(Intent.EXTRA_LOCAL_ONLY, localOnly)
                        .maybeAddCategory(Intent.CATEGORY_OPENABLE, onlyOpenable)

        @RequiresApi(Build.VERSION_CODES.O)
        fun create(mimeType: String, title: String, extraMimeTypes: Array<String> = arrayOf(), allowMultiple: Boolean = false,
                   localOnly: Boolean = true, onlyOpenable: Boolean = false, initialUri: String): Intent =
                create(mimeType, title, extraMimeTypes, allowMultiple, localOnly, onlyOpenable)
                        .maybePutStringExtra(DocumentsContract.EXTRA_INITIAL_URI, initialUri)


        fun resolveActivity(pm: PackageManager): Boolean = ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION))
    }
}