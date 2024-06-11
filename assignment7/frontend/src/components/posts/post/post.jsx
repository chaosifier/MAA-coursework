export default function Post({ data, deleteHandler, updateHandler }) {
    return <div className="post">
        <span>Id: {data.id}</span>
        <span>Title: {data.title}</span>
        <span>Author: {data.author}</span>
        <div class="actions">
            <button class="btn btn-danger" onClick={() => deleteHandler(data)}>Delete</button>
            <button class="btn btn-primary" onClick={() => updateHandler(data)}>Update</button>
        </div>
    </div>
}