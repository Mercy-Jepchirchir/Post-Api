package dev.charity.mypost


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.charity.mypost.databinding.ActivityMainBinding.inflate
import dev.charity.mypost.databinding.ActivityPostListsBinding


class RetrofitAdapter(var postList: List<Post>) :
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding =ActivityPostListsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var context = holder.itemView.context
        var currentPost = postList.get(position)
        with(holder.binding) {
            tvPost.text= currentPost.userId.toString()
            tvExplain.text = currentPost.id.toString()
            tvLanguage.text = currentPost.title

        }

        holder.binding.imgPerson.setOnClickListener{
            Toast
                .makeText(context, "You have clicked on my face", Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

}

class PostViewHolder(var binding: ActivityPostListsBinding) :
    RecyclerView.ViewHolder(binding.root)