package mx.tecnm.tepic.ladm_u1_practica2_juan_soltero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import mx.tecnm.tepic.ladm_u1_practica2_juan_soltero.ui.gallery.GalleryFragment
import java.io.BufferedReader
import java.io.InputStreamReader

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    //val titles = arrayListOf<String>()
    val titles = arrayOf("Sin Orden","Sin Orden","Sin Orden","Sin Orden","Sin Orden",
        "Sin Orden","Sin Orden","Sin Orden","Sin Orden","Sin Orden")
    val details = arrayOf("Sin Orden","Sin Orden","Sin Orden","Sin Orden","Sin Orden",
        "Sin Orden","Sin Orden","Sin Orden","Sin Orden","Sin Orden")
    val images = intArrayOf(
        R.drawable.ic_baseline_fastfood_24,
        R.drawable.ic_baseline_fastfood_24,
        R.drawable.ic_baseline_fastfood_24,
        R.drawable.ic_baseline_fastfood_24,
        R.drawable.ic_baseline_fastfood_24,
        R.drawable.ic_baseline_fastfood_24,
        R.drawable.ic_baseline_fastfood_24,
        R.drawable.ic_baseline_fastfood_24,
        R.drawable.ic_baseline_fastfood_24,
        R.drawable.ic_baseline_fastfood_24
    )

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.imagen)
            itemTitle = itemView.findViewById(R.id.titulo)
            itemDetail = itemView.findViewById(R.id.detalles)
        }
    }

}