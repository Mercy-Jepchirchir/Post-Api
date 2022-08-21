package dev.charity.mypost


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.charity.mypost.databinding.ActivityMainBinding.inflate
import dev.charity.mypost.databinding.PostListItemBinding


class RetrofitAdapter(var postList:List<Post>):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding=PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
                var currentPost = postList.get(position)
//        holder.binding.tvBody= currentPost.userId.toString()
//
            holder.binding.tvBody.text = currentPost.body
        holder.binding.tvTitles.text = currentPost.title

             var context = holder.itemView.context
        holder.binding.cvPosts.setOnClickListener{
                var intent = Intent (context, CommentsActivity::class.java)
                intent.putExtra("POST_ID",currentPost.id)
                context.startActivity(intent)
            }

//        holder.binding.imgPerson.setOnClickListener{
////            Toast
////                .makeText(context, "You have clicked on my face", Toast.LENGTH_LONG)
////                .show()
////        }


    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
class PostViewHolder(var binding: PostListItemBinding):RecyclerView.ViewHolder(binding.root)


