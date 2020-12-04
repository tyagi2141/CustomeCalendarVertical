package `in`.rahultyagi.recycle

import `in`.rahultyagi.R
import `in`.rahultyagi.pojo.MyListData
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Rahul on 03/12/20.
 */
class MyListAdapter(listdata: Array<MyListData>,listener: MyDateData) : RecyclerView.Adapter<MyListAdapter.ViewHolder?>() {
    private val listdata: Array<MyListData>
    var listener: MyDateData =listener

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val myListData: MyListData = listdata[position]
        holder.textView.setText(listdata[position].getDescription())
        holder.textView2.setText(listdata[position].getImgId())
        holder.tvDate.setText(listdata[position].getImgId())
        holder.relativeLayout.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                Toast.makeText(
                    view.getContext(),
                    "click on item: " + myListData.getImgId(),
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        listener.selectedData(listdata[position].getImgId(),position)


    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvDate: TextView
        var textView: TextView
        var textView2: TextView
        var relativeLayout: LinearLayout

        init {
            tvDate = itemView.findViewById(R.id.imageView) as TextView
            textView = itemView.findViewById(R.id.textView)
            textView2 = itemView.findViewById(R.id.textView2)
            relativeLayout = itemView.findViewById(R.id.relativeLayout)
        }
    }

    // RecyclerView recyclerView;
    init {
        this.listdata = listdata
    }

    interface MyDateData {

        fun selectedData(date:String,position: Int)


    }
}