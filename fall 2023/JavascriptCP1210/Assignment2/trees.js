/**
 *  CP1210-JavaScript: Assignment 2 - Tree Farm, Javascript
    John-Michael Woodrow, Sept 2023
    College of the North Atlantic
 */

document.getElementById('grow').addEventListener('click', growTree);

function growTree() {
    //inputs
    let treeType = document.getElementById('treeType').value;
    let treeHeight = document.getElementById('height').value;

    //build tree
    let tree = '';
    for (let i = 1; i <= treeHeight; i++) {
        if (treeType === "full") {
            tree += ' '.repeat(treeHeight - i) + '*'.repeat(2*i - 1) + '\n';

        } 
        
        else if (treeType === "left") {
            tree += '*'.repeat(i) + '\n';

        } 
        
        else if (treeType === "right") {
            tree += ' '.repeat(treeHeight - i) + '*'.repeat(i) + '\n';
        }
    }

    document.getElementById('forest').textContent = tree;
}


