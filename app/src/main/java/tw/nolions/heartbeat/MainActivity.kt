package tw.nolions.heartbeat

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val DEFAULT_SCALE_FACTOR = 0.2f
    private val DEFAULT_DURATION = 300L

    var scaleFactor = DEFAULT_SCALE_FACTOR
    var reductionScaleFactor = -scaleFactor
    var duration = DEFAULT_DURATION

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        heart.animate().scaleXBy(scaleFactor).scaleXBy(scaleFactor).setDuration(duration)
                .setListener(scaleUpListener)
    }

    private val scaleUpListener: AnimatorListener = object : AnimatorListener {
        override fun onAnimationStart(animation: Animator) {}
        override fun onAnimationRepeat(animation: Animator) {}
        override fun onAnimationEnd(animation: Animator) {
            //we ignore heartBeating as we want to ensure the heart is reduced back to original size
            heart.animate().scaleXBy(reductionScaleFactor).scaleYBy(reductionScaleFactor)
                    .setDuration(duration).setListener(scaleDownListener)
            heart.isChecked = false

        }

        override fun onAnimationCancel(animation: Animator) {}
    }

    private val scaleDownListener: AnimatorListener = object : AnimatorListener {
        override fun onAnimationStart(animation: Animator) {}
        override fun onAnimationRepeat(animation: Animator) {}
        override fun onAnimationEnd(animation: Animator) {
            heart.isChecked = true
//            if (heartBeating) {
            //duration twice as long for the upscale
            heart.animate().scaleXBy(scaleFactor).scaleYBy(scaleFactor)
                    .setDuration(duration * 2).setListener(scaleUpListener)
//            }
        }

        override fun onAnimationCancel(animation: Animator) {}
    }


}