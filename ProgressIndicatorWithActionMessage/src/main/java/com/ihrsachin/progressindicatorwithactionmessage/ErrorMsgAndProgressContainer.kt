package com.ihrsachin.progressindicatorwithactionmessage

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import com.google.android.material.button.MaterialButton
import com.google.android.material.progressindicator.LinearProgressIndicator

class ErrorMsgAndProgressContainer : LinearLayout{

    private var container : LinearLayout
    private var progressBar: LinearProgressIndicator
    private var messageWrap : LinearLayout
    private var messageTV: TextView
    private var actionButton : MaterialButton

    constructor(context: Context) : super(context){
        inflate(context, R.layout.error_msg_and_progress_container, this)
        container = this.findViewById(R.id.container)
        progressBar = this.findViewById(R.id.horizontal_progress)
        messageWrap = this.findViewById(R.id.message_wrap)
        messageTV = this.findViewById(R.id.message_text)
        actionButton  = this.findViewById(R.id.action_btn)
    }

    constructor(context: Context, attrs : AttributeSet) : super(context, attrs) {
        inflate(context, R.layout.error_msg_and_progress_container, this)
        container = this.findViewById(R.id.container)
        progressBar = this.findViewById(R.id.horizontal_progress)
        messageWrap = this.findViewById(R.id.message_wrap)
        messageTV = this.findViewById(R.id.message_text)
        actionButton  = this.findViewById(R.id.action_btn)

        if(isInEditMode){
            visibility = View.VISIBLE
            this.visibility = View.VISIBLE
            messageWrap.visibility = View.VISIBLE
            actionButton.visibility = View.VISIBLE
        }

    }


    fun backgroundColor(@ColorInt color : Int) : ErrorMsgAndProgressContainer{
        container.setBackgroundColor(color)
        return this
    }

    fun setProgressVisibility(visibility: Int){
        progressBar.visibility = visibility
    }

    fun setMessage(message : String) : ErrorMsgAndProgressContainer{
        messageTV.text = message
        return this
    }
    fun setMessageVisibility(visibility: Int) : ErrorMsgAndProgressContainer{
        messageWrap.visibility = visibility
        return this
    }
    fun setMessageTextColor(@ColorInt color : Int) : ErrorMsgAndProgressContainer{
        messageTV.setTextColor(color)
        return this
    }
    fun setMessageTextSize(size: Float) : ErrorMsgAndProgressContainer{
        messageTV.textSize = size
        return this
    }


    fun setActionButtonText(text : String) : ErrorMsgAndProgressContainer{
        actionButton.text = text
        return this
    }
    fun setActionButtonTextColor(@ColorInt color : Int) : ErrorMsgAndProgressContainer{
        actionButton.setTextColor(color)
        return this
    }
    fun setActionButtonOnClickListener(actionBtnClickListener: (view : View) -> Unit) : ErrorMsgAndProgressContainer{
        actionButton.setOnClickListener {
            actionBtnClickListener.invoke(it)
        }
        return this
    }





    fun hide() : ErrorMsgAndProgressContainer{
        val animator = ValueAnimator.ofFloat(1f, 0f)
        animator.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Float
            container.scaleY = value
        }
        animator.duration = 300 // Set the duration of the animation in milliseconds
        animator.start()
        postDelayed({
            container.visibility = View.GONE
            container.scaleY = 1f
        }, 350)
        return this
    }

    fun hideProgressIndicator() : ErrorMsgAndProgressContainer{
        val animator = ValueAnimator.ofFloat(1f, 0f)
        animator.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Float
            progressBar.scaleY = value
        }
        animator.duration = 200 // Set the duration of the animation in milliseconds
        animator.start()
        postDelayed({
            progressBar.visibility = View.GONE
            progressBar.scaleY = 1f
        }, 250)

        return this
    }

    fun hideMessage() : ErrorMsgAndProgressContainer{
        val animator = ValueAnimator.ofFloat(1f, 0f)
        animator.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Float
            messageWrap.scaleY = value
        }
        animator.duration = 300 // Set the duration of the animation in milliseconds
        animator.start()
        postDelayed({
            messageWrap.visibility = View.GONE
            messageWrap.scaleY = 1f
        }, 350)
        return this
    }

    fun hideActionButton() : ErrorMsgAndProgressContainer{
        actionButton.visibility = View.GONE
        return this
    }

    fun show() : ErrorMsgAndProgressContainer{
        container.scaleY = 0f
        container.visibility = View.VISIBLE
        progressBar.visibility = View.VISIBLE
        messageWrap.visibility = View.VISIBLE
        actionButton.visibility = VISIBLE

        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Float
            container.scaleY = value

        }
        animator.duration = 300 // Set the duration of the animation in milliseconds
        animator.start()
        return this
    }

    fun showProgressIndicator() : ErrorMsgAndProgressContainer{
        progressBar.scaleY = 0f
        container.visibility = View.VISIBLE
        progressBar.visibility = View.VISIBLE
        hideMessage()

        val animator = ValueAnimator.ofFloat(0f, 1f)

        animator.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Float
            progressBar.scaleY = value
        }
        animator.duration = 200 // Set the duration of the animation in milliseconds
        animator.start()
        return this
    }

    fun showMessage() : ErrorMsgAndProgressContainer{
        messageWrap.scaleY = 0f
        container.visibility = View.VISIBLE
        messageWrap.visibility = View.VISIBLE
        actionButton.visibility = View.VISIBLE

        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Float
            messageWrap.scaleY = value
        }
        animator.duration = 500 // Set the duration of the animation in milliseconds
        animator.start()

        return this
    }

    fun showActionButton() : ErrorMsgAndProgressContainer{
        actionButton.visibility = View.VISIBLE
        return this
    }


    fun dpToPx(dp: Float): Float {
        val density = context.resources.displayMetrics.density
        return dp * density
    }


}