export default function Post({ data, deleteHandler, updateHandler, clickHandler }) {
    return <div className="post">
        <div className="post-card-body" onClick={() => clickHandler(data)}>
            <span>Id: {data.id}</span>
            <span>Title: {data.title}</span>
            <span>Author: {data.author}</span>
        </div>
        <div className="actions">
            <button className="btn btn-danger" onClick={() => deleteHandler(data)}>Delete</button>
            <button className="btn btn-primary" onClick={() => updateHandler(data)}>Update</button>
        </div>
    </div>
}