package com.ck2020.cklearn.sliding_conflict

import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ck2020.cklearn.R
import com.ck2020.cklearn.customview.Logel
import kotlinx.android.synthetic.main.activity_nest_scroll_recycler.*

class NestScrollRecyclerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nest_scroll_recycler)
        for (i in 0 until 20) {
            dateList.add("$i")
        }
        var layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.height = getAppScreenHeight()

        recycle_parent.layoutParams = layoutParams
        nested.withRecyclerView(recycle)
        var adapter = MyAdapter(dateList)
        recycle.layoutManager = LinearLayoutManager(this)
        recycle.adapter = adapter
        adapter.setOnLoadMoreListener({
            Logel.i("触发上拉加载更多")
            var tempList = mutableListOf<String>()
            for (i in 0 until 20) {
                tempList.add("$i")
            }
            dateList.addAll(tempList)
            adapter.loadMoreComplete()
        }, recycle)
    }


    open class MyAdapter : BaseQuickAdapter<String, BaseViewHolder> {
        constructor(data: MutableList<String>?) : super(R.layout.item_recycler, data)

        override fun convert(helper: BaseViewHolder, item: String?) {
            helper.setText(R.id.tv_number, "item:${helper.layoutPosition}")
        }
    }

    private var dateList = mutableListOf<String>()

    fun getAppScreenHeight(): Int {
        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager ?: return -1
        val point = Point()
        wm.defaultDisplay.getSize(point)
        return point.y
    }
}