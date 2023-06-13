import os
import uvicorn
import tensorflow as tf
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

# Load Model
model = tf.keras.models.load_model('disaster_shield.h5')
scaler = None  # Define your scaler here if needed

# Input Schema
class InputData(BaseModel):
    latitude: float
    longitude: float
    magnitude: float
    depth: float

# Endpoint untuk prediksi
@app.post("/predict")
def predict(data: InputData):
    # Preprocess the input data if needed
    input_data = [[data.latitude, data.longitude, data.magnitude, data.depth]]
    if scaler is not None:
        input_data = scaler.transform(input_data)

    # Perform prediction using the loaded model
    prediction = model.predict(input_data)

    # Format the prediction result as needed
    result = {
        "prediction": prediction[0][0]
    }
    return result

if __name__ == "__main__":
    # Starting the server
    port = int(os.environ.get("PORT", 8000))
    uvicorn.run(app, host="0.0.0.0", port=port)
