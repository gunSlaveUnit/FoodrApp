import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.gunslaveunit.foodrapp.R
import com.github.gunslaveunit.foodrapp.models.Table
import com.github.gunslaveunit.foodrapp.views.fragments.tables_list.TableItemViewHolder

class ListAdapter : RecyclerView.Adapter<TableItemViewHolder>() {
    private var tableList = emptyList<Table>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableItemViewHolder {
        return TableItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.table_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TableItemViewHolder, position: Int) {
        val item = tableList[position];

        holder.itemView.findViewById<TextView>(R.id.number).text = item.number.toString()
        holder.itemView.findViewById<TextView>(R.id.description).text = item.description
        holder.itemView.findViewById<TextView>(R.id.capacity).text = item.capacity.toString()
        holder.itemView.findViewById<ImageView>(R.id.photo).setImageResource(R.color.purple_500)
    }

    override fun getItemCount(): Int {
        return tableList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(tables: List<Table>) {
        this.tableList = tables
        notifyDataSetChanged()
    }
}