package dev.charity.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.charity.mypost.databinding.ActivityCommentsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId = 0
    lateinit var binding : ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostId()
    }

    fun obtainPostId(){
        postId = intent.extras?.getInt("POST_ID")?:0
    }

    fun fetchPostId(){
        var apiClient = APIClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)
        request.enqueue(object :Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response .isSuccessful){
                    var post = response.body()
                    binding.tvTitle.text = post?.title
                    binding.tvPostbody.text = post?.body
                }

            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG).show()
            }

        })

    }
    fun setupToolbar(){
        setSupportActionBar(binding.toolbar2)
    }
}