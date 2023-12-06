# eng2-assessment

```
class Video {
    id: Int
    title: string
    hashtags: string[]
    likes: User[]
    dislikes: User[]
    user: User  
    views: User
}

class User {
    id: string
    name: string
}

class HashTag {
    id
    name
}

User --> Video posts
```