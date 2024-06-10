export default function Post({ data }) {
    return <div key={`post-${data.id}`} className="post">
        <span>Id: {data.id}</span>
        <span>Title: {data.title}</span>
        <span>Author: {data.author}</span>
    </div>
}