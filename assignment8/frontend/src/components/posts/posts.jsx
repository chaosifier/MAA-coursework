import { createContext, useState } from "react"
import Post from "./post/post";
import axios from "axios";
import Editor from "./editor/editor";
import Detail from "./detail/detail";

const PostsApiEndpoint = "http://localhost:3000/posts/"; //npx json-server testData.json
// const PostsApiEndpoint = "http://localhost:8080/api/v1/posts/";
const MyContext = createContext();

function Posts() {
    const [posts, setPosts] = useState(loadPosts)
    const [postBeingEdited, setPostBeingEdited] = useState(null);
    const [openPostId, setOpenPostId] = useState(null);

    function loadPosts() {
        axios.get(PostsApiEndpoint).then((resp) => setPosts(resp.data));
    }

    function deletePost(post) {
        axios.delete(PostsApiEndpoint + post.id).then(resp => {
            setPosts(posts.filter(p => p.id !== post.id));
        })
    }

    function savePost(e, formRef) {
        e.preventDefault();
        const formData = new FormData(formRef.current);
        const post = {};
        formData.forEach((v, k) => {
            post[k] = v;
        })

        if (post.id)
            axios.put(PostsApiEndpoint + post.id, post).then(resp => {
                setPosts(posts.map(p => p.id === post.id ? { ...post } : p));
                setPostBeingEdited(null);
            });
        else
            axios.post(PostsApiEndpoint, post).then(resp => {
                setPosts([...posts, resp.data]);
                setPostBeingEdited(null);
            });
    }

    function openPost(post) {
        setOpenPostId(post.id);
    }

    return (
        <MyContext.Provider value={{ openPostId, setOpenPostId }}>
            <div>
                <h2>Posts</h2>
                <div className="posts-container">
                    {posts && posts.map(p =>
                        <Post key={`post-${p.id}`} data={p} deleteHandler={deletePost} updateHandler={setPostBeingEdited} clickHandler={openPost} />
                    )}
                </div>
                <div className="actions">
                    <button className="btn btn-primary" onClick={() => setPostBeingEdited({})}>Create Post</button>
                </div>

                {postBeingEdited && <Editor data={postBeingEdited} cancelHandler={() => setPostBeingEdited(null)} saveHandler={savePost} />}

                {openPostId && <Detail />}
            </div>
        </MyContext.Provider>
    )
}

export { MyContext, Posts, PostsApiEndpoint }