package org.org.nahoft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Go To SetLanguageActivity
        set_language.setOnClickListener {
            val setLanguageIntent = Intent(this, SetLanguageActivity::class.java)
            startActivity(setLanguageIntent)
        }

        // Go To ApplicationShortcutActivity
        application_shortcut.setOnClickListener {
            val setShortcutIntent = Intent(this, ApplicationShortcutActivity::class.java)
            startActivity(setShortcutIntent)
        }
    }
}

