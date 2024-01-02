// Setup the game
document.addEventListener('DOMContentLoaded', () => {
    const startButton = document.querySelector('button');
    let game = null;

    // Click event listener for the start/play again button
    startButton.addEventListener('click', () => {
        const level = document.getElementById('level').value; // Get the current level selection
        if (startButton.textContent === "Play Again?") {
            game.resetGame(level); 
            startButton.textContent = "Start Game";
        } else {
            game = new Game(level);
            startButton.style.display = 'none';
        }
    });

    // Set up an event listener for the level selection dropdown
    const levelSelect = document.getElementById('level');
    levelSelect.addEventListener('change', () => {
        if (game) {
            game.resetGame(levelSelect.value);
        }
    });
});

// Tile class represents each tile on the board
class Tile {
    constructor(row, col) {
        this.row = row;
        this.col = col;
        this.isRevealed = false;
        this.isMine = false;
        this.adjacentMines = 0;
        this.element = this.createElement();
    }

    // Create the HTML element for the tile
    createElement() {
        const tileElement = document.createElement('div');
        tileElement.classList.add('tile');
        tileElement.dataset.row = this.row.toString();
        tileElement.dataset.col = this.col.toString();
        // Event listeners attached in the Game class
        return tileElement;
    }

    // Set the tile as a mine
    setMine() {
        this.isMine = true;
    }

    // Increment the count of adjacent mines
    incrementAdjacentMines() {
        if (!this.isMine) {
            this.adjacentMines += 1;
        }
    }

    // Toggle a flag on the tile to mark or unmark a suspected mine
    toggleFlag() {
        if (this.isRevealed) {
            return; // Cannot flag a revealed tile
        }

        this.isFlagged = !this.isFlagged;
        this.element.classList.toggle('flagged');
        if (this.isFlagged) {
            this.element.textContent = '🚩';
        } else {
            this.element.textContent = '';
        }
    }

    // Reveal the tile
    reveal() {
        if (this.isRevealed || this.isFlagged) {
            return; // Do not reveal if already revealed or flagged
        }

        this.isRevealed = true;
        this.element.classList.add('revealed');
        if (this.isMine) {
            this.element.textContent = '💣';
        } else if (this.adjacentMines > 0) {
            this.element.textContent = this.adjacentMines;
        }
    }

    // Reset the tile
    reset() {
        this.isRevealed = false;
        this.isMine = false;
        this.adjacentMines = 0;
        this.isFlagged = false;
        this.element.className = 'tile';
        this.element.textContent = '';
    }
}

// Game class represents the game logic
class Game {
    constructor(level) {
        this.level = level;
        this.grid = [];
        this.isTimerStarted = false;
        this.timer = null;
        this.elapsedTime = 0;
        this.revealedTilesCount = 0;
        this.totalNonMineTiles = 0;
        this.startButton = document.querySelector('button');
        this.init();
    }

    // Retrieve configuration for the selected level
    getLevelConfig(level) {
        const configs = {
            beginner: { tiles: 9, mines: 10 },
            intermediate: { tiles: 16, mines: 40 },
            expert: { tiles: 22, mines: 99 }
        };
        return configs[level];
    }

    // Initialize the game board
    init() {
        const { tiles, mines } = this.getLevelConfig(this.level);
        this.totalNonMineTiles = tiles * tiles - mines;
        this.createGrid(tiles, mines);
        this.renderBoard();
        this.resetTimerAndCounter();
        this.startButton.style.display = 'none';
    }

    // Create the grid and establish logic for the board
    createGrid(tiles, mines) {
        this.grid = []; // Clear existing grid before creating a new one
        for (let row = 0; row < tiles; row++) {
            this.grid[row] = [];
            for (let col = 0; col < tiles; col++) {
                // New Tile object for each position in the grid
                this.grid[row][col] = new Tile(row, col);
            }
        }

        let minesPlaced = 0;
        while (minesPlaced < mines) {
            let row = Math.floor(Math.random() * tiles);
            let col = Math.floor(Math.random() * tiles);

            if (!this.grid[row][col].isMine) {
                this.grid[row][col].setMine();
                this.incrementAdjacentMines(row, col);
                minesPlaced++;
            }
        }
    }

    // Add tiles and attach event listeners
    renderBoard() {
        const board = document.getElementById('board');
        const { tiles } = this.getLevelConfig(this.level);
        // Set the grid-template-columns based on the number of tiles
        board.style.gridTemplateColumns = `repeat(${tiles}, 1fr)`;
        board.innerHTML = ''; // Clear the board
        this.grid.forEach(row => {
            row.forEach(tile => {
                board.appendChild(tile.element);
                tile.element.addEventListener('click', () => {
                    this.handleLeftClick(tile);
                });
                tile.element.addEventListener('contextmenu', (e) => {
                    this.handleRightClick(e, tile);
                });
            });
        });
    }

    // Handle a left click on a tile
    handleLeftClick(tile) {
        if (!this.isTimerStarted) {
            this.startTimer();
            this.isTimerStarted = true;
        }
    
        if (tile.isMine) {
            this.gameOver();
        } else {
            this.revealTile(tile);
        }
    }

    // Handle a right click on a tile
    handleRightClick(event, tile) {
        event.preventDefault();
        if (!this.isTimerStarted) {
            this.startTimer();
            this.isTimerStarted = true;
    }
    
    tile.toggleFlag();
    }

    // Increase the mine count for tiles adjacent to a mine
    incrementAdjacentMines(row, col) {
        for (let i = -1; i <= 1; i++) {
            for (let j = -1; j <= 1; j++) {
                if (row + i >= 0 && row + i < this.grid.length && col + j >= 0 && col + j < this.grid[row].length) {
                    this.grid[row + i][col + j].incrementAdjacentMines();
                }
            }
        }
    }

    // Reveal a tile and its adjacent tiles if necessary
    revealTile(tile) {
        if (tile.isRevealed) {
            return;
        }

        tile.reveal();
        this.revealedTilesCount++;
        this.updateRevealedTilesDisplay();

        if (tile.adjacentMines === 0) {
            this.revealAdjacentTiles(tile.row, tile.col);
        }

        this.checkWinCondition();
    }

    // Recursively reveal adjacent tiles with no adjacent mines
    revealAdjacentTiles(row, col) {
        for (let i = -1; i <= 1; i++) {
            for (let j = -1; j <= 1; j++) {
                if (row + i >= 0 && row + i < this.grid.length && col + j >= 0 && col + j < this.grid[row].length) {
                    const adjacentTile = this.grid[row + i][col + j];
                    if (!adjacentTile.isMine && !adjacentTile.isRevealed) {
                        this.revealTile(adjacentTile);
                    }
                }
            }
        }
    }

    // Start the timer for the game
    startTimer() {
        this.elapsedTime = 0;
        this.updateTimerDisplay();
        this.timer = setInterval(() => {
            this.elapsedTime++;
            this.updateTimerDisplay();
        }, 1000);
    }
    
    // Stop the timer
    stopTimer() {
        clearInterval(this.timer);
        this.isTimerStarted = false;
    }
    
    // Update the display for the timer
    updateTimerDisplay() {
        document.getElementById('timer').textContent = `Time: ${this.elapsedTime}s`;
    }

    // Update the display for the count of revealed tiles
    updateRevealedTilesDisplay() {
        document.getElementById('counter').textContent = `Revealed Tiles: ${this.revealedTilesCount}`;
    }
    
    // Update the text of the start button
    updateStartButton(text) {
        const startButton = document.querySelector('button');
        startButton.textContent = text;
    }
    
    // Reset the timer and revealed tiles counter
    resetTimerAndCounter() {
        this.stopTimer();
        this.elapsedTime = 0;
        this.updateTimerDisplay();
        this.revealedTilesCount = 0;
    }

    // Handle game over
    gameOver() {
        this.stopTimer();
        this.grid.forEach(row => row.forEach(tile => {
            if (tile.isMine) tile.reveal();
        }));
        alert('Game Over!');
        this.updateStartButton("Play Again?");
        document.getElementById('board').style.pointerEvents = 'none';
        this.startButton.style.display = 'block';
    }
    
    // Check if the win condition is met
    checkWinCondition() {
        if (this.revealedTilesCount === this.totalNonMineTiles) {
            this.stopTimer();
            alert('Congratulations! You have won the game!');
            this.updateStartButton("Play Again?");
            this.startButton.style.display = 'block';
            document.getElementById('board').style.pointerEvents = 'none';
            
        }
    }

    // Reset the game 
    resetGame(newLevel) {
        this.level = newLevel;
        this.stopTimer();
        this.elapsedTime = 0;
        this.isTimerStarted = false;
        this.revealedTilesCount = 0;
        this.updateTimerDisplay();
        this.updateRevealedTilesDisplay();

        // Clear the board
        const board = document.getElementById('board');
        board.innerHTML = '';
        board.style.pointerEvents = 'auto'; // Re-enable pointer events

        // Reinitialize the game
        this.init();
    }
    
}
