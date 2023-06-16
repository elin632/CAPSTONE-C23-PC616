require('dotenv').config();

const express = require('express');
const app = express();
const axios = require('axios');

const { google } = require('googleapis');
const { auth } = require('google-auth-library');
const { Client } = require('@googlemaps/google-maps-services-js');

const client = auth.fromAPIKey(process.env.GOOGLE_MAPS_API_KEY);
const googleMapsClient = new Client({});

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

// Endpoint to fetch data from JSON file and generate heatmap response
app.get('/heatmap', async (req, res) => {
  try {
    const response = await axios.get('https://storage.googleapis.com/disaster-shield/heatmapData.json');
    const data = response.data;

    const heatmapResponse = await axios.post('https://model-fastapi-frlemfld5q-et.a.run.app/predict', { data }); // Send data to endpoint /heatmap using POST method

    const heatmapData = heatmapResponse.data.heatmap;
    // Generate a JSON response containing the heatmap data
    res.json({ heatmap: heatmapData });
    createHeatmap(heatmapData);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: 'Failed to fetch model data' });
  }
});

// start server
const port = process.env.PORT || 5000;
app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
