const express = require("express");
const app = express();

app.use(express.json());
app.use(express.static("public"));

let tasks = [];

// GET
app.get("/tasks", (req, res) => {
    res.json(tasks);
});

// POST
app.post("/tasks", (req, res) => {

    const task = {
        id: tasks.length + 1,
        title: req.body.title
    };

    tasks.push(task);

    res.json(task);
});

app.listen(3000, () => {
    console.log("Server running on http://localhost:3000");
});