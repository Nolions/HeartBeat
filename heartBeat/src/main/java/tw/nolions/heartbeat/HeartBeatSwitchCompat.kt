package tw.nolions.heartbeat

import android.animation.Animator
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat


class HeartBeatSwitchCompat : SwitchCompat {
    private var heartDrawable: Drawable? = null

    private var heartBeating = false

    private var mScale = 0.2f
    private var mReductionScaleFactor = -mScale
    private var mDuration = 300L

    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        init()
    }


    private fun init() {
        heartDrawable = ContextCompat.getDrawable(context, R.drawable.heart)
        background = heartDrawable
        thumbDrawable = null
    }

    fun start() {
        heartBeating = true
        animate().scaleXBy(mScale).scaleXBy(mScale).setDuration(mDuration)
            .setListener(scaleUpListener)
    }

    fun stop() {
        heartBeating = false
        clearAnimation()
    }


    fun animationToggle() {
        if (heartBeating) {
            stop()
        } else {
            start()
        }
    }

    fun setScale(scale: Float) {
        mScale = scale
        mReductionScaleFactor = -scale;
    }

    fun setDuration(duration: Long) {
        mDuration = mDuration;
    }

    private val scaleUpListener: Animator.AnimatorListener = object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator) {}
        override fun onAnimationRepeat(animation: Animator) {}
        override fun onAnimationEnd(animation: Animator) {
            animate().scaleXBy(mReductionScaleFactor).scaleYBy(mReductionScaleFactor)
                .setDuration(mDuration).setListener(scaleDownListener)
            isChecked = false
        }

        override fun onAnimationCancel(animation: Animator) {}
    }

    private val scaleDownListener: Animator.AnimatorListener = object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator) {}
        override fun onAnimationRepeat(animation: Animator) {}
        override fun onAnimationEnd(animation: Animator) {
            isChecked = true
            if (heartBeating) {
                animate().scaleXBy(mScale).scaleYBy(mScale)
                    .setDuration(mDuration * 2).setListener(scaleUpListener)
            }
        }

        override fun onAnimationCancel(animation: Animator) {}
    }
}