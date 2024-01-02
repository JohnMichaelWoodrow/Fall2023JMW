document.addEventListener('DOMContentLoaded', function() {
    const userSelect = document.getElementById('userSelect');
    const albumList = document.getElementById('albumList');

    // Fetch users and populate list
    fetch('https://jsonplaceholder.typicode.com/users')
        .then(response => response.json())
        .then(users => {
            users.forEach(user => {
                let option = document.createElement('option');
                option.value = user.id;
                option.textContent = user.name;
                userSelect.appendChild(option);
            });
            fetchAlbums(users[0].id); // First user
        });

    // Fetch and display albums for a user
    function fetchAlbums(userId) {
        fetch(`https://jsonplaceholder.typicode.com/albums?userId=${userId}`)
            .then(response => response.json())
            .then(albums => {
                albumList.innerHTML = ''; // Clear existing albums
                albums.forEach(album => {
                    let listItem = document.createElement('li');
                    listItem.textContent = album.title;
                    albumList.appendChild(listItem);
                });
            });
    }

    // Event listener for user selection change
    userSelect.addEventListener('change', function() {
        fetchAlbums(this.value);
    });
});
