package com.ck2020.cklearn.image_compress

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

/**
 * @author chenke
 * @create 2021/2/22
 * @Describe
 * 图片压缩
 */
object ImageCompressUtil {
    public fun resizeBitmap(context: Context, resId: Int, maxW: Int, maxH: Int, isAlpha: Boolean): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(context.resources, resId, options)
        if (!isAlpha) {
            options.inMutable = true
            options.inPreferredConfig = Bitmap.Config.RGB_565//565显示16位图，颜色存储较少，所占内存较少
        }
        //这里计算bitmap的宽高，按官方文档/2的做适配缩放
        options.inSampleSize = calculateResize(options.outWidth, options.outHeight, maxW, maxH)
        options.inJustDecodeBounds = false
        return BitmapFactory.decodeResource(context.resources, resId, options)
    }

    public fun calculateResize(oldW: Int, oldH: Int, maxW: Int, maxH: Int): Int {
        //每次除以二去接近控件的大小,这里以宽的维度去做测量
        var scale = 1
        while (oldW / scale / 2 >= maxW && oldH / scale / 2 >= maxH) {
            scale *= 2
        }
        return scale
    }
}