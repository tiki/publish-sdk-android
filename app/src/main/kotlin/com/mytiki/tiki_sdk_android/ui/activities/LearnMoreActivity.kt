package com.mytiki.tiki_sdk_android.ui.activities

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.mytiki.tiki_sdk_android.R
import io.noties.markwon.Markwon
import io.noties.markwon.ext.tables.TablePlugin

class LearnMoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val learnMoreText: String =
            assets.open("learn_more.md").bufferedReader().use { it.readText() }
        val markwon = Markwon.builder(this)
            .usePlugin(TablePlugin.create(this))
            .build();
        setContentView(R.layout.learn_more)
        markwon.setMarkdown(
            findViewById(R.id.learn_more_text),
            learnMoreText
        )
        findViewById<ImageView>(R.id.back_btn).setOnClickListener {
            finish()
        }
    }
}