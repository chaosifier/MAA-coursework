import { useState } from "react"
import Post from "../post/post";

export function Posts() {
    const [posts, setPosts] = useState([
        { id: 1, title: "Post 1", author: "Sagar Dahal" },
        { id: 2, title: "Post 2", author: "Sagar Dahal" },
        { id: 3, title: "Post 3", author: "Sagar Dahal" },
        { id: 4, title: "Post 4", author: "Sagar Dahal" },
    ]);

    return <div>
        <h2>Posts</h2>
        <div className="posts-container">
            {posts.map(p =>
               <Post data={p}/>
            )}
        </div>
    </div>
}