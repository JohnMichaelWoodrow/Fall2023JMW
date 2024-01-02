/*
//Example 1: Filtering an Array
//We'll use the filter method to get all even numbers from an array.
// Array of numbers
let numbers = [1, 2, 3, 4, 5, 6];

// Filter even numbers
let evens = numbers.filter(number => number % 2 === 0);

console.log(evens); // [2, 4, 6]


//Example 2: Summing an Array
//Using reduce to sum all numbers in an array.
// Array of numbers
let newNumbers = [1, 2, 3, 4, 5];

// Sum all numbers
let sum = newNumbers.reduce((total, number) => total + number, 0);

console.log(sum); // 15


//Example 3: Creating and Appending Multiple Elements
//Creating a list of items from an array and appending them to the DOM.
// Array of items
let fruits = ['Apple', 'Banana', 'Cherry'];

// Create a list element
let list = document.createElement('ul');

// Append list items for each fruit
fruits.forEach(fruit => {
  let listItem = document.createElement('li');
  listItem.textContent = fruit;
  list.appendChild(listItem); // append each item to the list
});

// Append the list to the body of the document
document.body.appendChild(list);


//Example 4: Handling Multiple Buttons
//Setting up event handlers for multiple buttons.
// Create three buttons and log which one was clicked
for (let i = 1; i <= 3; i++) {
    let button = document.createElement('button');
    button.textContent = `Button ${i}`;
    button.addEventListener('click', function() {
      console.log(`Button ${i} clicked!`);
    });
    document.body.appendChild(button);
  }
  
//Example 5: Updating Elements with Event Handlers
//Changing the text content of a paragraph element when a button is clicked.
// Create a paragraph element
let paragraph = document.createElement('p');
paragraph.textContent = 'Click the button to change this text.';
document.body.appendChild(paragraph);

// Create a button element
let button = document.createElement('button');
button.textContent = 'Change Text';
button.addEventListener('click', () => {
  paragraph.textContent = 'Text changed!';
});
document.body.appendChild(button);

//Example 6: Using Arrow Functions in Event Handlers
//Using an arrow function to handle resizing of the window.
window.addEventListener('resize', () => {
    console.log('Window resized to', window.innerWidth, 'x', window.innerHeight);
  });

//Example: Creating a Clickable List of Items
// Array of items
let items = ['Item 1', 'Item 2', 'Item 3'];

// Create a list element
let newList = document.createElement('ul');
document.body.appendChild(newList);

// Iterate over the array and create a newList item for each element
items.forEach((item, index) => {
  let newListItem = document.createElement('li');
  newListItem.textContent = item;

  // Add a click event newListener to each newList item
  newListItem.addEventnewListener('click', () => {
    console.log(`You clicked on ${item}`);
  });

  // Append the newList item to the newList
  newList.appendChild(newListItem);
});

/*
In this example, the forEach method is used to iterate over the items array, 
creating a new list item for each element and setting up a click event listener 
that logs a message to the console when the item is clicked. This showcases how 
iteration methods can be combined with event handling in JavaScript.
*/

// Function to create the main 'app' div and append it to the body
function createAppContainer() {
    const app = document.createElement('div');
    app.id = 'app';
    document.body.appendChild(app);
    return app;
  }
  
  // Function to create a generic container
  function createContainer(containerId, app) {
    const container = document.createElement('div');
    container.id = containerId;
    container.className = 'container';
    app.appendChild(container);
    return container;
  }
  
  // Function to create and display array operations (Examples 1-3)
  function createArrayOperations(container) {
    const title = document.createElement('h2');
    title.textContent = 'Array Operations';
    container.appendChild(title);
  
    // Example 1: Filter even numbers and display them
    const evenNumbersList = document.createElement('ul');
    const numbers = [1, 2, 3, 4, 5, 6];
    const evens = numbers.filter(number => number % 2 === 0);
    evens.forEach(even => {
      const listItem = document.createElement('li');
      listItem.textContent = `Even number: ${even}`;
      evenNumbersList.appendChild(listItem);
    });
    container.appendChild(evenNumbersList);
  
    // Example 2: Sum all numbers and display the result
    const sum = numbers.reduce((total, number) => total + number, 0);
    const sumDisplay = document.createElement('p');
    sumDisplay.textContent = `Sum of numbers: ${sum}`;
    container.appendChild(sumDisplay);
  
    // Example 3: Create a list of fruits and append them to the container
    const fruits = ['Apple', 'Banana', 'Cherry'];
    const fruitList = document.createElement('ul');
    fruits.forEach(fruit => {
      const listItem = document.createElement('li');
      listItem.textContent = fruit;
      fruitList.appendChild(listItem);
    });
    container.appendChild(fruitList);
  }
  
  // Function to create and attach event listeners (Examples 4-6)
  function createEventListeners(container) {
    const title = document.createElement('h2');
    title.textContent = 'Event Listeners';
    container.appendChild(title);
  
    // Example 4: Create three buttons with event listeners
    for (let i = 1; i <= 3; i++) {
      const button = document.createElement('button');
      button.textContent = `Button ${i}`;
      button.addEventListener('click', function() {
        console.log(`Button ${i} clicked!`);
      });
      container.appendChild(button);
    }
  
    // Example 5: Button to change paragraph text
    const paragraph = document.createElement('p');
    paragraph.textContent = 'Click the button to change this text.';
    container.appendChild(paragraph);
  
    const changeTextButton = document.createElement('button');
    changeTextButton.textContent = 'Change Text';
    changeTextButton.addEventListener('click', () => {
      paragraph.textContent = 'Text changed!';
    });
    container.appendChild(changeTextButton);
  }
  
  // Function to create a simple slideshow (Slideshow example)
  function createSlideshow(container) {
    const title = document.createElement('h2');
    title.textContent = 'Image Slideshow';
    container.appendChild(title);
  
    // Assuming imagePaths are defined and valid URLs
    let imagePaths = ['images/photo1.jpg', 'images/photo2.jpg', 'images/photo3.jpg'];
    let currentImageIndex = 0;
    let slideshowInterval;
  
    const imageElement = document.createElement('img');
    imageElement.style.maxWidth = '300px';
    imageElement.src = imagePaths[currentImageIndex];
    container.appendChild(imageElement);
  
    const startButton = document.createElement('button');
    startButton.textContent = 'Start Slideshow';
    startButton.addEventListener('click', () => {
      if (!slideshowInterval) {
        slideshowInterval = setInterval(() => {
          currentImageIndex = (currentImageIndex + 1) % imagePaths.length;
          imageElement.src = imagePaths[currentImageIndex];
        }, 2000);
      }
    });
    container.appendChild(startButton);
  
    const stopButton = document.createElement('button');
    stopButton.textContent = 'Stop Slideshow';
    stopButton.addEventListener('click', () => {
      clearInterval(slideshowInterval);
      slideshowInterval = null;
    });
    container.appendChild(stopButton);
  }
  
  // This function sets up the entire UI
  function setupUI() {
    // First, create the main 'app' div
    const app = createAppContainer();
  
    // Then create and setup the containers for each UI component
    const arrayOpsContainer = createContainer('array-operations', app);
    createArrayOperations(arrayOpsContainer);
  
    const eventListenersContainer = createContainer('event-listeners', app);
    createEventListeners(eventListenersContainer);
  
    const slideshowContainer = createContainer('slideshow', app);
    createSlideshow(slideshowContainer);
  }
  
  // Run the setup once the DOM is fully loaded
  document.addEventListener('DOMContentLoaded', setupUI);
  