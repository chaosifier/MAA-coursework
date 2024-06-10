import { useState } from "react"
import Post from "../post/post";

export function Posts({data}) {
    return <div>
        <h2>Posts</h2>
        <div className="posts-container">
            {data && data.map(p =>
               <Post key={`post-${p.id}`} data={p}/>
            )}
        </div>
    </div>
}