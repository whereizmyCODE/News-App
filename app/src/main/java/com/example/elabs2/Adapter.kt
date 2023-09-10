import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.elabs2.Articles
import com.example.elabs2.R

class Adapter(val context:Context,val articles:List<Articles>):
    androidx.recyclerview.widget.RecyclerView.Adapter<Adapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView =itemView.findViewById(R.id.image)
        val headlines: TextView =itemView.findViewById(R.id.headlines)
        val description:TextView=itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.items,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article=articles[position]
        holder.headlines.text=article.title
        holder.description.text=article.description
       Glide.with(context).load(article.urlToImage).into(holder.image)
    }
    override fun getItemCount(): Int {
        return articles.size
    }

}