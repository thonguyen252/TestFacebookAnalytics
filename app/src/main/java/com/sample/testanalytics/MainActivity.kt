package com.sample.testanalytics

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun attachBaseContext(newBase: Context?) {
        val locale = Locale("en")
        Locale.setDefault(locale)
        val newContext = newBase?.let {
            val conf = it.resources.configuration
            conf.setLocale(locale)
            it.createConfigurationContext(conf)
        }
        super.attachBaseContext(newContext)
    }


    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        onDispatch(event)
        return super.dispatchTouchEvent(event)
    }

    /**
     * Clear focus on every edit text when touch out side
     *
     * @param event
     * @return
     */
    protected fun onDispatch(event: MotionEvent) {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                }
            }
        }
    }
}
