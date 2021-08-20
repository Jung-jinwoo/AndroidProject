package com.com.blog.view.post;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.com.blog.R;
import com.com.blog.controller.PostController;
import com.com.blog.controller.dto.CMRespDto;
import com.com.blog.controller.dto.PostUpdateDto;
import com.com.blog.model.Post;
import com.com.blog.view.CustomAppBarActivity;
import com.com.blog.view.InitActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostUpdateActivity extends CustomAppBarActivity implements InitActivity {

    private static final String TAG = "PostUpdateActivity";
    private PostUpdateActivity mContext = PostUpdateActivity.this;

    private MaterialButton btnUpdate;
    private TextInputEditText tfTitle, tfContent;

    private PostController postController;
    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_update);

        init();
        initLr();
        initSetting();
        initData();
    }

    @Override
    public void init() {
        postController = new PostController();
        btnUpdate = findViewById(R.id.btnUpdate);
        tfTitle = findViewById(R.id.tfTitle);
        tfContent = findViewById(R.id.tfContent);
    }

    @Override
    public void initLr() {
        btnUpdate.setOnClickListener(v -> {
            // postId, content, title
            PostUpdateDto postUpdateDto =
                    new PostUpdateDto(
                            tfTitle.getText().toString(),
                            tfContent.getText().toString()
                    );

            postController.update(post.getId(), postUpdateDto).enqueue(new Callback<CMRespDto<Post>>() {
                @Override
                public void onResponse(Call<CMRespDto<Post>> call, Response<CMRespDto<Post>> response) {
                    CMRespDto<Post> cm = response.body();
                    if(cm.getCode() == 1){
                        // intent 하면 post.getId() 가져가야함.
//                        Intent intent = new Intent(
//                                mContext,
//                                PostDetailActivity.class
//                        );
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        intent.putExtra("postId", post.getId());
//                        startActivity(intent);

                        // finish 하면 PostDetailActivity onResume()에서 UI동기화
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<CMRespDto<Post>> call, Throwable t) {

                }
            });
        });
    }

    @Override
    public void initSetting() {
        onAppBarSettings(true, "Update");
    }

    @Override
    public void initData() {
        Intent getIntent = getIntent();
        post = (Post) getIntent.getSerializableExtra("post");

        tfTitle.setText(post.getTitle());
        tfContent.setText(post.getContent());
    }
}