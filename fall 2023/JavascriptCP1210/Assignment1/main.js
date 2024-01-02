const $ = selector => document.querySelector(selector);

const action1Function = evt => {
    alert ("Action 1");
}

const action2Function = evt => {
    alert ("Action 2");
}

document.addEventListener("DOMContentLoaded", () => {
    $("#action1").addEventListener("click", action1Function);
});