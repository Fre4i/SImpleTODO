package com.frein.simpletodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.app.ActivityCompat
import com.justai.aimybox.Aimybox
import com.justai.aimybox.components.AimyboxAssistantFragment
import com.justai.aimybox.components.AimyboxProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.assistant_container, AimyboxAssistantFragment())
            commit()
        }

    }
    override fun onBackPressed() {
        val assistantFragment = (supportFragmentManager.findFragmentById(R.id.assistant_container)
                as? AimyboxAssistantFragment)
        if (assistantFragment?.onBackPressed() != true) super.onBackPressed()
    }
}