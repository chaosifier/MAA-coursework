import { useRef, useState } from "react"

export default function Editor({ data, saveHandler, cancelHandler }) {
    const formRef = useRef();

    return <form className="form" ref={formRef} onSubmit={e => saveHandler(e, formRef)}>
        <div className="form-head">
            <span>{data.id ? "Update" : "Create"} Post</span>
        </div>
        <div className="form-body">
            <input type="hidden" value={data.id} name="id" />
            <div className="form-group">
                <span>Title</span>
                <input type="text" name="title" value={data.title}/>
            </div>
            <div className="form-group">
                <span>Author</span>
                <input type="text" name="author" value={data.author} />
            </div>
            <div className="form-group">
                <span>Content</span>
                <textarea value={data.content} name="content" />
            </div>
        </div>
        <div className="form-actions">
            <button className="btn btn-primary" type="submit">{data.id ? "Update" : "Save"}</button>
            <button className="btn btn-danger" onClick={cancelHandler}>Cancel</button>
        </div>
    </form>
}