package edu.uw.ischool.chym2002.biggobutton

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.Random

class MainActivity : AppCompatActivity() {
    private var count = 0
    private var isAnimating = false
    private lateinit var rotateAnimator: ObjectAnimator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)

        rotateAnimator = ObjectAnimator.ofFloat(button, "rotation", 0f, 360f)
        rotateAnimator.duration = 2000
        rotateAnimator.repeatCount = ObjectAnimator.INFINITE

        button.setOnClickListener {
            count++
            isAnimating = !isAnimating
            val str = if (count > 1) "times" else "time"
            button.text = getString(R.string.pushed, count, str)
            button.setBackgroundColor(getRandomColor())
            button.setTextColor(getRandomColor())

            if (isAnimating) rotateAnimator.start()
            else rotateAnimator.end()

        }
    }

    private fun getRandomColor(): Int {
        val random = Random()
        val red = random.nextInt()
        val green = random.nextInt()
        val blue = random.nextInt()
        return android.graphics.Color.rgb(red, green, blue)
    }
}