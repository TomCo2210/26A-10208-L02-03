package dev.tomco.a26a_10208_l02_03

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import dev.tomco.a26a_10208_l02_03.utilities.Constants

class ScoreActivity : AppCompatActivity() {


    private lateinit var score_LBL_title: MaterialTextView

    private lateinit var score_BTN_newGame: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViews()
        initViews()
    }

    private fun findViews() {
        score_LBL_title = findViewById(R.id.score_LBL_title)
        score_BTN_newGame = findViewById(R.id.score_BTN_newGame)
    }

    private fun initViews() {
        val bundle: Bundle? = intent.extras

        val message = bundle?.getString(Constants.BundleKeys.MESSAGE_KEY,"🤷🏻‍♂️ Unknown Status!")
        val score = bundle?.getInt(Constants.BundleKeys.SCORE_KEY, 0)

        score_LBL_title.text = buildString {
            append(message)
            append("\n")
            append(score)
        }
        score_BTN_newGame.setOnClickListener { view: View ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}