import { useState } from "react"

export default function Editor({ data, saveHandler, cancelHandler }) {
    const [title, setTitle] = useState(data.id ? data.title : "");
    const [author, setAuthor] = useState(data.id ? data.author : "");
    const [content, setContent] = useState(data.id ? data.content : "");

    function saveChanges() {
        let postToSave = data.id ?
            {
                ...data,
                title: title,
                author: author,
                content: content
            }
            :
            {
                title: title,
                author: author,
                content: content
            };
        saveHandler(postToSave);
    }

    return <div className="form">
        <div className="form-head">
            <span>{data.id ? "Update" : "Create"} Post</span>
        </div>
        <div className="form-body">
            <div className="form-group">
                <span>Title</span>
                <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
            </div>
            <div className="form-group">
                <span>Author</span>
                <input type="text" value={author} onChange={(e) => setAuthor(e.target.value)} />
            </div>
            <div className="form-group">
                <span>Content</span>
                <textarea value={content} onChange={(e) => setContent(e.target.value)} />
            </div>
        </div>
        <div className="form-actions">
            <button class="btn btn-primary" onClick={saveChanges}>{data.id ? "Update" : "Save"}</button>
            <button class="btn btn-danger" onClick={cancelHandler}>Cancel</button>
        </div>
    </div>
}