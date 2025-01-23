document.addEventListener('DOMContentLoaded', () => {
  const userForm = document.getElementById('userForm');
  const userTable = document.getElementById('userTable').getElementsByTagName('tbody')[0];
  const apiBaseUrl = 'http://localhost:8080/api/users';

  function fetchUsers() {
      fetch(apiBaseUrl)
          .then(response => response.json())
          .then(data => {
              userTable.innerHTML = '';
              data.forEach(user => {
                  const row = userTable.insertRow();
                  row.innerHTML = `
                      <td>${user.id}</td>
                      <td>${user.firstName}</td>
                      <td>${user.lastName}</td>
                      <td>${user.email}</td>
                      <td>
                          <button onclick="editUser(${user.id})">Edit</button>
                          <button onclick="deleteUser(${user.id})">Delete</button>
                      </td>
                  `;
              });
          });
  }

  userForm.addEventListener('submit', (e) => {
      e.preventDefault();
      const id = document.getElementById('userId').value;
      const firstName = document.getElementById('firstName').value;
      const lastName = document.getElementById('lastName').value;
      const email = document.getElementById('email').value;
      const method = id ? 'PUT' : 'POST';
      const url = id ? `${apiBaseUrl}/${id}` : apiBaseUrl;

      fetch(url, {
          method: method,
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify({ firstName, lastName, email })
      })
      .then(response => response.json())
      .then(() => {
          userForm.reset();
          fetchUsers();
      });
  });

  window.editUser = function (id) {
      fetch(`${apiBaseUrl}/${id}`)
          .then(response => response.json())
          .then(user => {
              document.getElementById('userId').value = user.id;
              document.getElementById('firstName').value = user.firstName;
              document.getElementById('lastName').value = user.lastName;
              document.getElementById('email').value = user.email;
          });
  };

  window.deleteUser = function (id) {
      fetch(`${apiBaseUrl}/${id}`, {
          method: 'DELETE'
      }).then(() => fetchUsers());
  };

  fetchUsers();
});