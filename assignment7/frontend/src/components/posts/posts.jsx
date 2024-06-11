import { useState } from "react"
import Post from "./post/post";
import axios from "axios";
import Editor from "./editor/editor";

export function Posts() {
    // const postsApiEndpoint = "http://localhost:3000/posts/"; //npx json-server testData.json
    const postsApiEndpoint = "http://localhost:8080/api/v1/posts/";
    const [posts, setPosts] = useState(loadPosts)
    const [postBeingEdited, setPostBeingEdited] = useState(null);

    function loadPosts() {
        axios.get(postsApiEndpoint).then((resp) => setPosts(resp.data));
    }

    function deletePost(post) {
        axios.delete(postsApiEndpoint + post.id).then(resp => {
            setPosts(posts.filter(p => p.id !== post.id));
        })
    }

    function savePost(post) {
        if (post.id)
            axios.put(postsApiEndpoint + post.id, post).then(resp => {
                setPosts(posts.map(p => p.id === post.id ? { ...post } : p));
                setPostBeingEdited(null);
            });
        else
            axios.post(postsApiEndpoint, post).then(resp => {
                setPosts([...posts, resp.data]);
                setPostBeingEdited(null);
            });
    }

    return <div>
        <h2>Posts</h2>
        <div className="posts-container">
            {posts && posts.map(p =>
                <Post key={`post-${p.id}`} data={p} deleteHandler={deletePost} updateHandler={setPostBeingEdited} />
            )}
        </div>
        <div className="actions">
            <button class="btn btn-primary" onClick={() => setPostBeingEdited({})}>Create Post</button>
        </div>

        {postBeingEdited && <Editor data={postBeingEdited} cancelHandler={() => setPostBeingEdited(null)} saveHandler={savePost} />}
    </div>
}