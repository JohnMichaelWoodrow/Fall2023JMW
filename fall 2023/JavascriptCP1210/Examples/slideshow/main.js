// JavaScript to create the entire UI for the slideshow

// Array of image paths
const imagePaths = ['images/image1.gif', 'images/image2.gif', 'images/image3.gif'];
let currentImageIndex = 0;
let slideshowInterval;

// Get the root element to append our UI
const app = document.getElementById('app');

// Create slideshow container
const slideshowContainer = document.createElement('div');
slideshowContainer.id = 'slideshow-container';
app.appendChild(slideshowContainer);

// Create image element
const imageElement = document.createElement('img');
imageElement.id = 'slideshow-image';
imageElement.src = imagePaths[currentImageIndex];
slideshowContainer.appendChild(imageElement);

// Create buttons container
const buttonsContainer = document.createElement('div');
buttonsContainer.id = 'slideshow-controls';
slideshowContainer.appendChild(buttonsContainer);

// Function to create a button
function createButton(id, text) {
  const button = document.createElement('button');
  button.className = 'button';
  button.id = id;
  button.textContent = text;
  return button;
}

// Add Start Slideshow button
const startButton = createButton('start-slideshow', 'Start Slideshow');
startButton.addEventListener('click', () => {
  if (!slideshowInterval) {
    changeImage();
    slideshowInterval = setInterval(changeImage, 2000);
  }
});
buttonsContainer.appendChild(startButton);

// Add Stop Slideshow button
const stopButton = createButton('stop-slideshow', 'Stop Slideshow');
stopButton.addEventListener('click', () => {
  clearInterval(slideshowInterval);
  slideshowInterval = null;
});
buttonsContainer.appendChild(stopButton);

// Add Next Image button
const nextButton = createButton('next-image', 'Next Image');
nextButton.addEventListener('click', changeImage);
buttonsContainer.appendChild(nextButton);

// Function to change the image
function changeImage() {
  currentImageIndex = (currentImageIndex + 1) % imagePaths.length;
  imageElement.src = imagePaths[currentImageIndex];
}
