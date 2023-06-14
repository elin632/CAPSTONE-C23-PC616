//get data

const axios = require('axios');

axios.get('http://localhost:8080/heatmap')
  .then(response => {
    console.log(response.data);
  })
  .catch(error => {
    console.error(error);
  });