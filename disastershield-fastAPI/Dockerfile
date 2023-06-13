# Menggunakan base image Python 3.8
FROM python:3.8

# Mengatur direktori kerja ke /app
WORKDIR /app

# Menyalin file requirements.txt ke dalam image dan menginstal dependensi Python
COPY requirements.txt .

# Menginstal dependensi Python menggunakan pip
RUN pip install --no-cache-dir -r requirements.txt

# Menyalin kode aplikasi Anda ke dalam image
COPY . .

# Menjalankan server FastAPI ketika container dijalankan
CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8080"]
