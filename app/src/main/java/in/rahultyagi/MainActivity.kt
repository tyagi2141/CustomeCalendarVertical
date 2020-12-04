package `in`.rahultyagi

/**
 * Created by Rahul on 03/12/20.
 */

import `in`.rahultyagi.adapter.TimelineAdapter
import `in`.rahultyagi.pojo.MyListData
import `in`.rahultyagi.recycle.MyListAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(), MyListAdapter.MyDateData
    {
    val dateForamate = SimpleDateFormat("dd-MM-yyyy")

    var myListData: Array<MyListData>? = null
    var datePickerTimeline: DatePickerTimeline? = null
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        datePickerTimeline = findViewById(R.id.dateTimeline)

        val todayDate = Calendar.getInstance().time
        val calendar: Calendar = Calendar.getInstance();
        calendar.time = todayDate;

        val year = calendar.get(Calendar.YEAR);
        val month = calendar.get(Calendar.MONTH);
        val day = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerTimeline?.setInitialDate(year, month, day)
        val date = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, 5)


        //  datePickerTimeline?.setActiveDate(date)
        datePickerTimeline?.setOnDateSelectedListener(object : OnDateSelectedListener {
            override fun onDateSelected(year: Int, month: Int, day: Int, dayOfWeek: Int) {
                //Do Something


                Log.d(TAG, "onDateSelected: $day ${month.plus(1)} $year")
                val selectedDate = "$day-${month.plus(1)}-$year"

                val date = dateForamate.parse(selectedDate)
                val dateFormat: DateFormat = dateForamate
                val strDate: String = dateFormat.format(date)

                changeDateColor(date)




                if (getPositionByDate(strDate) == null) {
                    Toast.makeText(applicationContext, "no value for this date", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    recyclerView?.scrollToPosition(getPositionByDate(strDate) ?: 0)
                }
            }

            override fun onDisabledDateSelected(
                year: Int,
                month: Int,
                day: Int,
                dayOfWeek: Int,
                isDisabled: Boolean
            ) {
                Log.d(TAG, "onDisabledDateSelected: $day")
            }
        })
        val dates = arrayOf(Calendar.getInstance().time)
        datePickerTimeline?.deactivateDates(dates)




        myListData = arrayOf<MyListData>(


            MyListData("Email", "04-12-2020"),
            MyListData("Info", "04-12-2020"),
            MyListData("Delete", "04-12-2020"),
            MyListData("Dialer", "04-12-2020"),
            MyListData("Alert", "04-12-2020"),
            MyListData("Email", "04-12-2020"),
            MyListData("Info", "04-12-2020"),
            MyListData("Delete", "04-12-2020"),
            MyListData("Dialer", "04-12-2020"),
            MyListData("Alert", "04-12-2020"),
            MyListData("Alert", "04-12-2020"),
            MyListData("Alert", "04-12-2020"),

            MyListData("Email", "20-12-2020"),
            MyListData("Info", "20-12-2020"),
            MyListData("Delete", "20-12-2020"),
            MyListData("Dialer", "20-12-2020"),
            MyListData("Alert", "20-12-2020"),
            MyListData("Email", "20-12-2020"),
            MyListData("Info", "20-12-2020"),
            MyListData("Delete", "20-12-2020"),
            MyListData("Dialer", "20-12-2020"),
            MyListData("Alert", "20-12-2020"),
            MyListData("Map", "21-12-2020"),
            MyListData("Email", "21-12-2020"),
            MyListData("Info", "21-12-2020"),
            MyListData("Delete", "21-12-2020"),
            MyListData("Map", "21-12-2020"),
            MyListData("Email", "21-12-2020"),
            MyListData("Info", "21-12-2020"),
            MyListData("Delete", "21-12-2020"),
            MyListData("Dialer", "25-12-2020"),
            MyListData("Alert", "25-12-2020"),
            MyListData("Map", "25-12-2020"),
            MyListData("Dialer", "25-12-2020"),
            MyListData("Alert", "25-12-2020"),
            MyListData("Dialer", "25-12-2020"),
            MyListData("Alert", "25-12-2020"),
            MyListData("Map", "25-12-2020"),
            MyListData("Dialer", "25-12-2020"),
            MyListData("Dialer", "25-12-2020"),
            MyListData("Dialer", "25-12-2020"),
            MyListData("Alert", "25-12-2020"),
            MyListData("Map", "26-12-2020"),
            MyListData("Dialer", "26-12-2020"),
            MyListData("Alert", "26-12-2020"),
            MyListData("Map", "26-12-2020"),
            MyListData("Map", "26-12-2020"),
            MyListData("Dialer", "26-12-2020"),
            MyListData("Alert", "26-12-2020"),
            MyListData("Map", "26-12-2020"),
            MyListData("Dialer", "27-12-2020"),
            MyListData("Alert", "27-12-2020"),
            MyListData("Map", "27-12-2020"),
            MyListData("Map", "27-12-2020"),
            MyListData("Map", "27-12-2020"),
            MyListData("Map", "27-12-2020"),
            MyListData("Map", "27-12-2020"),
            MyListData("Map", "27-12-2020"),
            MyListData("Map", "27-12-2020"),
            MyListData("Map", "27-12-2020"),
            MyListData("Map", "27-12-2020"),
            MyListData("Map", "27-12-2020"),
            MyListData("Map", "27-12-2020"),
            MyListData("Map", "27-12-2020"),
            MyListData("Map", "30-12-2020"),
            MyListData("Map", "30-12-2020"),
            MyListData("Map", "31-12-2020"),
            MyListData("Map", "31-12-2020"),
            MyListData("Map", "31-12-2020"),
            MyListData("Map", "31-12-2020"),
            MyListData("Map", "31-12-2020"),
            MyListData("Map", "31-12-2020"),
            MyListData("Map", "01-12-2020"),
            MyListData("Map", "01-01-2021"),
            MyListData("Map", "01-01-2021"),
            MyListData("Map", "01-01-2021"),
            MyListData("Map", "01-01-2021"),
            MyListData("Map", "01-01-2021"),
            MyListData("Map", "01-01-2021"),
            MyListData("Map", "01-01-2021"),
            MyListData("Map", "02-02-2021"),
            MyListData("Map", "02-02-2021"),
            MyListData("Map", "02-02-2021"),
            MyListData("Map", "02-02-2021"),
            MyListData("Map", "02-02-2021"),
            MyListData("Map", "02-02-2021"),
            MyListData("Map", "02-02-2021"),
            MyListData("Map", "02-02-2021"),
            MyListData("Map", "02-02-2021"),
            MyListData("Map", "02-02-2021")
        )


        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        val adapter = MyListAdapter(myListData!!, this)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = LinearLayoutManager(this)

        recyclerView?.adapter = adapter


    }

    companion object {
        private const val TAG = "MainActivity"
        var listener: RefreshData? = null

    }


    override fun selectedData(dates: String, position: Int) {

        listener?.refresh()

        val date = dateForamate.parse(dates)

        changeDateColor(date)
    }

    fun changeDateColor(date: Date) {

        val calendar: Calendar = Calendar.getInstance();
        calendar.setTime(date);

        val year = calendar.get(Calendar.YEAR);
        val month = calendar.get(Calendar.MONTH);
        val day = calendar.get(Calendar.DAY_OF_MONTH);


        datePickerTimeline?.setActiveDate(calendar)
        datePickerTimeline?.getPositionRefresh()
        val arrayDate = arrayOf(calendar.time)
        datePickerTimeline?.deactivateDates(arrayDate)


    }

    interface RefreshData {

        fun refresh()


    }

    fun getPositionByDate(date: String): Int? {
        var position: Int? = null
        for ((index, value) in myListData!!.withIndex()) {
           // println("the element at $index is ${value.getImgId()}" + " === " + date)

            val mypojo = myListData!![index].getImgId()
            if (mypojo == date) {
                position = index
                break
            } else {
                // position = null

            }
        }

        return position
    }


}
