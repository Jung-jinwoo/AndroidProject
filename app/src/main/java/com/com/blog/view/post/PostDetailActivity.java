package com.com.blog.view.post;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.com.blog.R;
import com.com.blog.controller.PostController;
import com.com.blog.controller.dto.CMRespDto;
import com.com.blog.model.Post;
import com.com.blog.view.CustomAppBarActivity;
import com.com.blog.view.InitActivity;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostDetailActivity extends CustomAppBarActivity implements InitActivity {

    private static final String TAG = "PostDetailActivity";
    // 애플리케이션이 처음부터 끝까지 관리하는 어떤 클래스에 엑티비티 컨텍스트 전달하면 망함.
    private PostDetailActivity mContext = PostDetailActivity.this;

    private MaterialButton btnDelete, btnUpdateForm;
    private TextView tvBox;

    private PostController postController;
    private Post post;
    private int postId;

    @Override
    protected void onResume() {
        super.onResume();
        // 수정완료가 되면 postId로 다시 데이터 갱신
        Log.d(TAG, "onResume: ");

        initData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        Log.d(TAG, "onCreate: ");
        
        init();
        initLr();
        initSetting();
    }

    @Override
    public void init() {
        postController = new PostController();
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdateForm = findViewById(R.id.btnUpdateForm);
        tvBox = findViewById(R.id.tvBox);
    }

    @Override
    public void initLr() {
        btnUpdateForm.setOnClickListener(v -> {
            Intent intent = new Intent(
                    mContext,
                    PostUpdateActivity.class
            );
            intent.putExtra("post", post);
            mContext.startActivity(intent);
        });

        btnDelete.setOnClickListener(v -> {
            postController.deleteById(post.getId()).enqueue(new Callback<CMRespDto>() {
                @Override
                public void onResponse(Call<CMRespDto> call, Response<CMRespDto> response) {
                    CMRespDto cm =  response.body();
                    if(cm.getCode() == 1){
                        // 이전 페이지들 다 삭제하고 PostListActivity 만 남게해서 !!
                        Intent intent = new Intent(
                                mContext,
                                PostListActivity.class
                        );
                        // Login -> List -> Detail
                        // Login -> List
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<CMRespDto> call, Throwable t) {

                }
            });
        });
    }

    @Override
    public void initSetting() {
        onAppBarSettings(true, "Detail");

        Intent getIntent = getIntent();
        postId = getIntent.getIntExtra("postId", 0);
        if(postId == 0) finish();
    }

    @Override
    public void initData() {
        // 데이터 초기화 하기
        postController.findById(postId).enqueue(new Callback<CMRespDto<Post>>() {
            @Override
            public void onResponse(Call<CMRespDto<Post>> call, Response<CMRespDto<Post>> response) {
                CMRespDto<Post> cm = response.body();
                if(cm.getCode() == 1){
                    post = cm.getData();
                    tvBox.setText("");
                    tvBox.append("id : "+cm.getData().getId()+"\n");
                    tvBox.append("title : "+cm.getData().getTitle()+"\n");
                    tvBox.append("content : "+cm.getData().getContent()+"\n");
                    tvBox.append("username : "+cm.getData().getUser().getUsername()+"\n");
                    tvBox.append("created : "+cm.getData().getCreated()+"\n");
                }
            }

            @Override
            public void onFailure(Call<CMRespDto<Post>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}