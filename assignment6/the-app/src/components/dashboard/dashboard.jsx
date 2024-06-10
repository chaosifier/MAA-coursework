import React, { useState} from "react";
import { Posts } from "../posts/posts";

export function Dashboard() {
    const [txt, setTxt] = useState("");
    const [posts, setPosts] = useState([
        { id: 1, title: "Post 1", author: "Sagar Dahal" },
        { id: 2, title: "Post 2", author: "Sagar Dahal" },
        { id: 3, title: "Post 3", author: "Sagar Dahal" },
        { id: 4, title: "Post 4", author: "Sagar Dahal" },
    ]);

    function updateTitle(postId, newTitle){
        setPosts(posts.map(p => 
            p.id === postId ? {...p, title: newTitle} : p
        ));
    }

    function handleChange(e){
        setTxt(e.target.value);
    }

    return (<div>
        <h1>Dashboard</h1>
        <Posts data={posts}/>
        <input type="text" onChange={handleChange} value={txt}/>
        <button onClick={() => updateTitle(1, txt)}>Update first post</button>
    </div>);
};