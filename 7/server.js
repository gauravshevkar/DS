const express = require("express");

const app = express();
const PORT = 3000;

// Serve frontend files
app.use(express.static("public"));

// Simple API
app.get("/message", (req, res) => {
    res.json({
        message: "Hello from Node.js Server!"
    });
});

// Start server
app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});