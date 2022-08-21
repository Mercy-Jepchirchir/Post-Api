package dev.charity.mypost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.charity.mypost.databinding.CommentListItemBinding


class CommentAdapter(var commentList:List<Comment>): RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding = CommentListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment = commentList.get(position)
        with(holder.binding){
            tvPostid.text = currentComment.postId.toString()
            tvid.text = currentComment.id.toString()
            tvName.text = currentComment.name
            tvEmail.text = currentComment.email
            tvbody.text = currentComment.body
        }
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}


class CommentViewHolder(var binding: CommentListItemBinding):RecyclerView.ViewHolder(binding.root)