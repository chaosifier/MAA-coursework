export default function Post({ data }) {
    return <div className="post">
        <span>Id: {data.id}</span>
        <span>Title: {data.title}</span>
        <span>Author: {data.author}</span>
    </div>
}