package com.ck2020.cklearn.customview.volumeview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.ck2020.cklearn.R

/**
 * @author chenke
 * @create 2020/7/15
 * @Describe
 */
class VolumeView : View {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    var mPaint: Paint? = null
    private fun initView(context: Context?) {
        mPaint = Paint()
        mPaint?.apply {
            isAntiAlias = true//抗锯齿
        }
    }

    /**
     * 定义音量大小，有8个级别
     */
    var mVolumeCount = 8

    /**
     * 当前音量的等级
     */
    var mVolumeLevel = 0

    /**
     * 当前音量的大小
     */
    var mVolumeNow = 0

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //画背景
        drawBackground(canvas)
        //画音量图标
        drawVolumeIcon(canvas)
        //画音量横线
        drawVolumeLevel(canvas)
    }

    private fun drawVolumeLevel(canvas: Canvas?) {
        mPaint?.apply {
//            val stepDex = 20//步长为20
//            val levelDex = 20//初始长度

            color = Color.BLACK
            strokeWidth = 10f

            for (i in 0..mVolumeCount) {
                canvas?.drawLine(
                    100f - 5 * i,
                    (height - 100f) - 30 * i,
                    120f + 5 * i,
                    (height - 100f) - 30 * i
                    , this
                )
            }
            //绘制当前的音量大小
            if (mVolumeNow > 0) {
                color = Color.WHITE
            } else {
                color = Color.BLACK
            }
            //绘制白色
            for (i in 0..mVolumeNow) {
                canvas?.drawLine(
                    100f - 5 * i,
                    (height - 100f) - 30 * i,
                    120f + 5 * i,
                    (height - 100f) - 30 * i
                    , this
                )
            }
        }
    }

    /**
     * 黑色背景
     */
    private fun drawBackground(canvas: Canvas?) {
        //创建一个圆角矩形
        mPaint?.apply {
            color = Color.BLACK
            alpha = 120
            val rectF = RectF(0f, 0f, width.toFloat(), height.toFloat())
            canvas?.drawRoundRect(rectF, 24.toFloat(), 24.toFloat(), this)
        }
    }

    private var imageBitmap: Bitmap? = null
    private fun drawVolumeIcon(canvas: Canvas?) {
        mPaint?.apply {
            imageBitmap = BitmapFactory.decodeResource(resources, R.mipmap.icon_volume)
            //将音量图片放置在中间
            val radio = imageBitmap!!.width / imageBitmap!!.height.toFloat()
            val rectHeight = (height - 100) * 0.8f//(上下50)
            val rectWidth = (rectHeight * radio) * 0.8f
            val bitmapRectF =
                RectF(
                    (width / 2 - rectWidth / 2.toFloat()) + 50,
                    height / 2 - rectHeight / 2.toFloat(),
                    (width / 2 + rectWidth / 2.toFloat()) + 50,
                    height / 2 + rectHeight / 2.toFloat()
                )
            canvas?.drawBitmap(imageBitmap!!, null, bitmapRectF, mPaint)
        }
    }

    var yDown = 0f

    /**
     * 对触摸反馈进行处理，处理上下
     */
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //通过滑动的距离来控制大小
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                yDown = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                val yMove = event.y
                val count = (yDown - yMove) / 100//将100作为一个刻度的步长
                Log.i("gw", "count:$count")
                mVolumeNow = (mVolumeNow + count).toInt()
                if (mVolumeNow > 8) {
                    mVolumeNow = 8
                }
                if (mVolumeNow < 0) {
                    mVolumeNow = 0
                }
                Log.i("gw", "mVolumeNow:$mVolumeNow")
                postInvalidate()
            }
        }
        return true//不改变系统的触摸反馈，这里只处理音量的大小
    }
}