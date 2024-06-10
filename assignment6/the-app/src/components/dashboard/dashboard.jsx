import React, { useState} from "react";
import { Posts } from "../posts/posts";

export function Dashboard() {
    const { txt, setTxt } = useState("");

    return (<div>
        <h1>Dashboard</h1>
        <Posts />
        <input type="text" />
        <button onClick={() => setTxt("test")} />
    </div>);
};