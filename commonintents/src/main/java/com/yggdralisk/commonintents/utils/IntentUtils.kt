package com.yggdralisk.commonintents.utils

import android.content.Intent
import android.net.Uri

/**
 * Created by Jan Stoltman on 6/10/18.
 */
fun Intent.maybeAddCategory(category: String, addCategory: Boolean): Intent =
        if (addCategory) {
            this.addCategory(category)
        } else {
            this
        }

fun Intent.maybePutStringExtra(name: String, value: String?): Intent =
        if (value != null) {
            this.putExtra(name, value)
        } else {
            this
        }

fun Intent.maybePutArrayListExtra(name: String, attachments: ArrayList<Uri>?, actionType: String) =
        if (attachments != null && attachments.isNotEmpty()) {
            if (actionType == Intent.ACTION_SEND_MULTIPLE) {
                this.putExtra(name, attachments)
            } else {
                this.putExtra(name, attachments.first())
            }
        } else {
            this
        }
