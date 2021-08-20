package com.com.blog.model;



import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*{
         "id": 5,
         "title": "제목5",
         "content": "내용5",
         "user": {
                "id": 2,
                "username": "cos",
                "password": "1234",
                "email": "cos@nate.com",
                "created": "2021-26-11T09:26:05",
                "updated": "2021-26-11T09:26:05"
         },
         "created": "2021-26-11T09:26:05",
         "updated": "2021-26-11T09:26:05"
},*/

@Data
public class Post implements Serializable {

    private static final String TAG = "Post";

    private int id;
    private String title;
    private String content;
    private User user;
    private String created;
    private String updated;
}
