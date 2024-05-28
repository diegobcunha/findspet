package com.diegocunha.coreui.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.openLink(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}