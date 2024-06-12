import { useContext, useEffect, useState } from "react";
import { MyContext, PostsApiEndpoint } from "../posts"
import axios from "axios";

export default function Detail() {
    const { openPostId, setOpenPostId } = useContext(MyContext);
    const [data, setData] = useState(null);

    useEffect(() => {
        if (openPostId) {
            axios
                .get(PostsApiEndpoint + openPostId)
                .then((resp) => setData(resp.data));
        }
    }, [openPostId]);

    return data && <div className="post-detail">
        <h1>Title: {data.title}</h1>
        <p>{data.content}</p>
        <span>Author: {data.author}</span>
    </div>
}