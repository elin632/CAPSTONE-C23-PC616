const express = require('express');
const app = express();
const fs = require('fs');


const { google } = require('googleapis');
const { auth } = require('google-auth-library');
const { Client } = require('@googlemaps/google-maps-services-js');

const client = auth.fromAPIKey('AIzaSyBFVqoYS94ZB5T5F52_MXKyDdl3OZ-YrKg');
const googleMapsClient = new Client({});

// Endpoint to fetch data from JSON file and generate heatmap response
app.get('/heatmap', (req, res) => {
  // read JSON file
  fs.readFile('heatmapData.json', 'utf8', (err, data) => {
    if (err) {
      console.error(err);
      return res.status(500).json({ error: 'Failed to read data file' });
    }

    try {
      const jsonData = JSON.parse(data);
      const heatmapData = processData(jsonData); // Process data

      // Generates a JSON response containing the heatmap data
      res.json({ heatmap: heatmapData });
    } catch (error) {
      console.error(error);
      return res.status(500).json({ error: 'Failed to process data' });
    }
  });
});

// function to process data 
function processData(data) {
  // Process data and prepare heatmap data
  const heatmapData = data.map(entry => ({
    lat: parseFloat(entry.lat),
    lng: parseFloat(entry.lng),
    weight: parseInt(entry.weight)
  }));

  return heatmapData;
}

// Using Google Maps JavaScript API to create heatmaps
function createHeatmap(heatmapData) {
  // Map and heatmap initialization using Google Maps JavaScript API
  const map = new google.maps.Map(document.getElementById('map'), {
    center: { lat: -6.1754, lng: 106.8272 },
    zoom: 10
  });

  const heatmap = new google.maps.visualization.HeatmapLayer({
    data: heatmapData,
    map: map
  });

  heatmap.setMap(map);
}

// start server
app.listen(8080, () => {
  console.log('Server running on port 8080');
});
