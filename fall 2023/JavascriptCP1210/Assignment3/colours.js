const $ = selector => document.querySelector(selector);

const colors = ["white", "red", "orange", "yellow", "green", "blue", "violet", "black"];

document.addEventListener("DOMContentLoaded", () => {

    let root = $("#ocean");
    root.innerHTML = "";

    for (let i = 0; i < 20; i++) {
        for (let j = 0; j < 20; j++) {
            const node = document.createElement("button");
            node.textContent = "#";
            node.style.backgroundColor = colors[0];
            node.style.fontFamily = 'Courier New, monospace';
            node.addEventListener("click", handleButtonClick);
            node.addEventListener("mouseenter", handleButtonMouseEnter);
            root.appendChild(node);
        }
        root.appendChild(document.createElement("br"));
    }

    root.addEventListener("mouseenter", handleDivMouseEnter);
    root.addEventListener("mouseleave", handleDivMouseLeave);
});

function handleButtonClick(e) {
    e.target.style.backgroundColor = colors[0];
}

function handleButtonMouseEnter(e) {
    let currentColorIndex = colors.indexOf(e.target.style.backgroundColor);
    if (currentColorIndex < colors.length - 1) {
        e.target.style.backgroundColor = colors[currentColorIndex + 1];
    }
}

function handleDivMouseEnter() {
    $("#ocean").style.backgroundColor = "lightgrey";
}

function handleDivMouseLeave() {
    $("#ocean").style.backgroundColor = "white";
}
