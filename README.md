# 안드로이드 + JWT 서버 인증 블로그 프로젝트

* 라이브러리
```gradle
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    compileOnly 'org.projectlombok:lombok:1.18.20'
    annotationProcessor 'org.projectlombok:lombok:1.18.20'
    implementation 'com.squareup.retrofit2:converter-gson:2.1.0'
```

* 권한
- 인터넷

* 인증방식
- JWT 토큰

* API
```html

        "id": 3,
        "username": "getinthere",
        "password": "1234",
        "email": "getinthere@nate.com",
        "created": [
            2021,
            7,
            10,
            7,
            45,
            15,
            764705000
        ],
        "updated": [
            2021,
            7,
            10,
            7,
            45,
            15,
            764705000
        ]
    }
}
4. 회원정보수정

요청 주소 (PUT)
- http://localhost:8080/user/3

요청 헤더
Authorization : Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb3PthqDtgbAiLCJpZCI6MywiZXhwIjoxNjI1ODc0Mzk1fQ.u_pUd7mwmE0KWWV_o7QDPkGg7Nyo_avYOwYwI5ZdIWluMltXfECQyYq9nVPzXGFZz89mOYLmYMazeYgfZwgVMw

요청 파라미터
- application/json
{
    "password":"5678",
    "email":"getinthere@gmail.com"
}

응답 바디
- application/json
{
    "code": 1,
    "msg": "회원정보수정완료",
    "data": {
        "id": 3,
        "username": "getinthere",
        "password": "5678",
        "email": "getinthere@gmail.com",
        "created": "2021-07-10T07:45:15.764705",
        "updated": "2021-07-10T07:50:13.7016973"
    }
}
5. 회원정보 한건보기

요청 주소 (GET)
- http://localhost:8080/user/3

요청 헤더
Authorization : Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb3PthqDtgbAiLCJpZCI6MywiZXhwIjoxNjI1ODc0Mzk1fQ.u_pUd7mwmE0KWWV_o7QDPkGg7Nyo_avYOwYwI5ZdIWluMltXfECQyYq9nVPzXGFZz89mOYLmYMazeYgfZwgVMw

응답 바디
- application/json
{
    "code": 1,
    "msg": "회원정보확인완료",
    "data": {
        "id": 3,
        "username": "getinthere",
        "password": "1234",
        "email": "getinthere@nate.com",
        "created": "2021-07-10T08:06:24.483245",
        "updated": "2021-07-10T08:06:24.483245"
    }
}
6. 게시글 목록보기

요청 주소 (GET)
- http://localhost:8080/post

요청 헤더
Authorization : Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb3PthqDtgbAiLCJpZCI6MywiZXhwIjoxNjI1ODc0Mzk1fQ.u_pUd7mwmE0KWWV_o7QDPkGg7Nyo_avYOwYwI5ZdIWluMltXfECQyYq9nVPzXGFZz89mOYLmYMazeYgfZwgVMw

응답 바디
- application/json
{
    "code": 1,
    "msg": "목록보기완료",
    "data": [
        {
            "id": 5,
            "title": "제목5",
            "content": "내용5",
            "user": {
                "id": 2,
                "username": "cos",
                "password": "1234",
                "email": "cos@nate.com",
                "created": "2021-07-10T08:05:49.039117",
                "updated": "2021-07-10T08:05:49.039117"
            },
            "created": "2021-07-10T08:05:49.069037",
            "updated": "2021-07-10T08:05:49.069037"
        },
        {
            "id": 4,
            "title": "제목4",
            "content": "내용4",
            "user": {
                "id": 2,
                "username": "cos",
                "password": "1234",
                "email": "cos@nate.com",
                "created": "2021-07-10T08:05:49.039117",
                "updated": "2021-07-10T08:05:49.039117"
            },
            "created": "2021-07-10T08:05:49.068049",
            "updated": "2021-07-10T08:05:49.068049"
        },
        {
            "id": 3,
            "title": "제목3",
            "content": "내용3",
            "user": {
                "id": 1,
                "username": "ssar",
                "password": "1234",
                "email": "ssar@nate.com",
                "created": "2021-07-10T08:05:49.0082",
                "updated": "2021-07-10T08:05:49.0082"
            },
            "created": "2021-07-10T08:05:49.062057",
            "updated": "2021-07-10T08:05:49.062057"
        },
        {
            "id": 2,
            "title": "제목2",
            "content": "내용2",
            "user": {
                "id": 1,
                "username": "ssar",
                "password": "1234",
                "email": "ssar@nate.com",
                "created": "2021-07-10T08:05:49.0082",
                "updated": "2021-07-10T08:05:49.0082"
            },
            "created": "2021-07-10T08:05:49.060063",
            "updated": "2021-07-10T08:05:49.060063"
        },
        {
            "id": 1,
            "title": "제목1",
            "content": "내용1",
            "user": {
                "id": 1,
                "username": "ssar",
                "password": "1234",
                "email": "ssar@nate.com",
                "created": "2021-07-10T08:05:49.0082",
                "updated": "2021-07-10T08:05:49.0082"
            },
            "created": "2021-07-10T08:05:49.057069",
            "updated": "2021-07-10T08:05:49.057069"
        }
    ]
}
7. 게시글 한건보기

요청 주소 (GET)
- http://localhost:8080/post/1

요청 헤더
Authorization : Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb3PthqDtgbAiLCJpZCI6MywiZXhwIjoxNjI1ODc0Mzk1fQ.u_pUd7mwmE0KWWV_o7QDPkGg7Nyo_avYOwYwI5ZdIWluMltXfECQyYq9nVPzXGFZz89mOYLmYMazeYgfZwgVMw

응답 바디
- application/json
{
    "code": 1,
    "msg": "상세보기완료",
    "data": {
        "id": 1,
        "title": "제목1",
        "content": "내용1",
        "user": {
            "id": 1,
            "username": "ssar",
            "password": "1234",
            "email": "ssar@nate.com",
            "created": "2021-07-10T08:05:49.0082",
            "updated": "2021-07-10T08:05:49.0082"
        },
        "created": "2021-07-10T08:05:49.057069",
        "updated": "2021-07-10T08:05:49.057069"
    }
}
8. 게시글 쓰기

요청 주소 (POST)
- http://localhost:8080/post

요청 바디
- application/json
{
    "title":"제목6",
    "content":"내용6"
}

요청 헤더
Authorization : Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb3PthqDtgbAiLCJpZCI6MywiZXhwIjoxNjI1ODc0Mzk1fQ.u_pUd7mwmE0KWWV_o7QDPkGg7Nyo_avYOwYwI5ZdIWluMltXfECQyYq9nVPzXGFZz89mOYLmYMazeYgfZwgVMw

응답 바디
- application/json
{
    "code": 1,
    "msg": "글쓰기완료",
    "data": {
        "id": 6,
        "title": "제목6",
        "content": "내용6",
        "user": {
            "id": 3,
            "username": "getinthere",
            "password": "1234",
            "email": "getinthere@nate.com",
            "created": "2021-07-10T08:06:24.483245",
            "updated": "2021-07-10T08:06:24.483245"
        },
        "created": "2021-07-10T08:11:05.5290593",
        "updated": "2021-07-10T08:11:05.5290593"
    }
}
9. 게시글 수정하기

요청 주소 (PUT)
- http://localhost:8080/post/6

요청 바디
- application/json
{
    "title":"제목변경",
    "content":"내용변경"
}

요청 헤더
Authorization : Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb3PthqDtgbAiLCJpZCI6MywiZXhwIjoxNjI1ODc0Mzk1fQ.u_pUd7mwmE0KWWV_o7QDPkGg7Nyo_avYOwYwI5ZdIWluMltXfECQyYq9nVPzXGFZz89mOYLmYMazeYgfZwgVMw

응답 바디
- application/json
{
    "code": 1,
    "msg": "수정하기완료",
    "data": {
        "id": 6,
        "title": "제목변경",
        "content": "내용변경",
        "user": {
            "id": 3,
            "username": "getinthere",
            "password": "1234",
            "email": "getinthere@nate.com",
            "created": "2021-07-10T08:06:24.483245",
            "updated": "2021-07-10T08:06:24.483245"
        },
        "created": "2021-07-10T08:11:05.529059",
        "updated": "2021-07-10T08:11:52.9494383"
    }
}
10. 게시글 삭제하기

요청 주소 (DELETE)
- http://localhost:8080/post/6

요청 헤더
Authorization : Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb3PthqDtgbAiLCJpZCI6MywiZXhwIjoxNjI1ODc0Mzk1fQ.u_pUd7mwmE0KWWV_o7QDPkGg7Nyo_avYOwYwI5ZdIWluMltXfECQyYq9nVPzXGFZz89mOYLmYMazeYgfZwgVMw

응답 바디
- application/json
{
    "code": 1,
    "msg": "삭제하기완료",
    "data": null
}
```