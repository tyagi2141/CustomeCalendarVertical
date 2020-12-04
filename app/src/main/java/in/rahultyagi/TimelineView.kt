package `in`.rahultyagi

import `in`.rahultyagi.MainActivity.RefreshData
import `in`.rahultyagi.adapter.TimelineAdapter
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Rahul on 03/12/20.
 */
class TimelineView : RecyclerView, RefreshData {
    private var adapter: TimelineAdapter? = null
    private var monthTextColor = 0
    private var dateTextColor = 0
    private var dayTextColor = 0
    private var selectedColor = 0
    private var disabledColor = 0
    var mLayoutSuppressed = false

    @VisibleForTesting
    var mLayout: LayoutManager? = null

    //    private float monthTextSize, dateTextSize, dayTextSize;
    private var year = 0
    private var month = 0
    private var date = 0
    private var position = 0

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        init()
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyle: Int
    ) : super(context, attrs, defStyle) {
        init()
    }

    fun init() {
        year = 1970
        month = 0
        date = 1
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL,
            false
        )
       // listener = this
        adapter = TimelineAdapter(this, -1)
        setAdapter(adapter)
    }

    fun getMonthTextColor(): Int {
        return monthTextColor
    }

    fun setMonthTextColor(color: Int) {
        monthTextColor = color
    }

    fun getDateTextColor(): Int {
        return dateTextColor
    }

    fun setDateTextColor(color: Int) {
        dateTextColor = color
    }

    fun getDayTextColor(): Int {
        return dayTextColor
    }

    fun setDayTextColor(color: Int) {
        dayTextColor = color
    }

    fun setDisabledDateColor(color: Int) {
        disabledColor = color
    }

    fun getDisabledDateColor(): Int {
        return disabledColor
    }

    fun getSelectedColor(): Int {
        return selectedColor
    }

    fun setSelectedColor(color: Int) {
        selectedColor = color
    }

    fun getYear(): Int {
        return year
    }

    fun getMonth(): Int {
        return month
    }

    fun getDate(): Int {
        return date
    }

     fun position():Int{
         return position
     }
    fun setOnDateSelectedListener(listener: OnDateSelectedListener?) {
        adapter?.setDateSelectedListener(listener)
    }

    fun setInitialDate(year: Int, month: Int, date: Int) {
        this.year = year
        this.month = month
        this.date = date
        invalidate()
    }

    /**
     * Calculates the date position and set the selected background on that date
     * @param activeDate active Date
     */
    fun setActiveDate(activeDate: Calendar) {
        try {
            val initialDate = SimpleDateFormat("yyyy-MM-dd")
                .parse(year.toString() + "-" + (month + 1) + "-" + date)
            val diff = activeDate.time.time - initialDate.time
            val position = (diff / (1000 * 60 * 60 * 24)).toInt()
            adapter?.setSelectedPosition(position)
           // linearLayoutManager.scrollToPositionWithOffset(pos, 0);
           // recyclerview.scrollToPosition(position)
            //this.scrollToPosition(position)
           this.smoothScrollToPosition(position)



            Log.e("TimelineSettingPosition",""+position)
            invalidate()
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }



    fun getPositionRefresh():Int?{
        return adapter?.getPosition()

    }
    fun deactivateDates(deactivatedDates: Array<Date?>) {
        adapter?.disableDates(deactivatedDates)
    }


    companion object {
        private const val TAG = "TimelineView"
    }

    override fun refresh() {
        // adapter?.notifyDataSetChanged()
        adapter = null
        if (adapter == null) {
            adapter = TimelineAdapter(this, -1)
            setAdapter(adapter)
            adapter?.notifyItemChanged(0)
        }

        Log.e("refreshingData", "yessss")
    }
}
