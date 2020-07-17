package com.ck2020.cklearn.customview.verificationview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.ck2020.cklearn.R

/**
 * @author chenke
 * @create 2020/7/14
 * @Describe 这里只写继承view
 * 通过 onMeasure onDraw onLayout
 * 自定义三步来绘制。
 * 正在项目开发中，验证码控件推荐采用组合的方式:ViewGroup+TextView
 * 例如FrameLayout+TextView
 */
class VerificationView : View {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val a = context?.obtainStyledAttributes(attrs, R.styleable.VerificationView)
        //获取自定义attrs文件的属性
        mText = a?.getString(R.styleable.VerificationView_text)
        mTextSize = a?.getDimension(R.styleable.VerificationView_textSize, 0f)!!
        mTextColor = a.getColor(R.styleable.VerificationView_color, Color.parseColor("#000000"))//纯黑
        a.recycle()

        mPaint = Paint()
        mPaint?.color = mTextColor!!
        mPaint?.textSize = mTextSize
        mPaint?.isAntiAlias = true//抗锯齿，平滑
        mBound = Rect()
        mPaint?.getTextBounds(mText, 0, mText!!.length, mBound)//将文本的绘制宽高限定在Rect(矩形内)
        //设置点击事件
        setOnClickListener {
            val mCode = 1000.rangeTo(9999)
            mText = "${mCode.random()}"
            mPaint?.getTextBounds(mText, 0, mText!!.length, mBound)//更新文字文字显示区域
            requestLayout()//重新测量布局
//            invalidate() //只执行onDraw，不会重新测量(onMeasure) 布局(onLayout)。关键词：requestLayout会想上层层调用，最终 调用ViewRootImpl的requestLayout
            //在调用view 的onMeasure，标记PFLAG_FORCE_LAYOUT 然后在onLayout布局中取消标记
            //invalidate() 标记mPrivateFlags |= PFLAG_INVALIDATED;所以不会重新测量布局
        }
    }

    var mText: String? = null
    var mTextSize: Float = 0f
    var mTextColor: Int? = null
    var mPaint: Paint? = null

    /**
     * 绘制时控制文本绘制的范围
     */
    private var mBound: Rect? = null

    /**
     * 第一步，开始测量
     * onMeasure的2个参数，是父布局调用measureChildWithMargins，遍历子布局，然后调用onMeasure(int,int)
     * 传回测量值
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //获取宽度的测量模式
        val widthSpecMode = MeasureSpec.getMode(widthMeasureSpec)
        var mWidth = 0
        var mHeight = 0
        //计算宽度
        if (widthSpecMode == MeasureSpec.EXACTLY) {
            //是精确的值，例如已经xml写入的200dp
            mWidth = MeasureSpec.getSize(widthMeasureSpec)//宽度为测量的精确值
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            //非精确值，例如warp_content，match_parent
            mWidth = mBound!!.width() + paddingLeft + paddingRight
        }
        //计算高度
        val heightSpecMode = MeasureSpec.getMode(heightMeasureSpec)
        if (heightSpecMode == MeasureSpec.EXACTLY) {
            mHeight = MeasureSpec.getSize(heightMeasureSpec)
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            mHeight = mBound!!.height() + paddingTop + paddingBottom
        }
        //重新设置测量值
        setMeasuredDimension(mWidth, mHeight)
    }

    /**
     * onDraw 可以获取测量的布局宽高
     */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //绘制背景
        mPaint?.color = Color.YELLOW
        canvas?.drawRect(0f, 0f, measuredWidth.toFloat(), measuredHeight.toFloat(), mPaint!!)
        //绘制文字
        mPaint?.color = mTextColor!!
        canvas?.drawText(
            mText!!,
            (width / 2 - mBound!!.width() / 2).toFloat(),
            (height / 2 + mBound!!.height() / 2).toFloat(),
            mPaint!!
        )//有padding，所以这里用父布局宽度的一半，减去文字宽度的一半
    }

    /**
     * onLayout表示放置绘制的位置
     */
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }
}