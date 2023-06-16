# Menggunakan image Node.js sebagai base image
FROM node:14.21.2-alpine

# Menetapkan direktori kerja di dalam container
WORKDIR /app

# Menyalin package.json dan package-lock.json ke direktori kerja
COPY package*.json ./

# Menginstal dependensi yang diperlukan
RUN npm install

# Menyalin seluruh kode aplikasi ke direktori kerja
COPY . .

EXPOSE 5000
# Menetapkan command yang akan dijalankan saat container dijalankan
CMD ["npm", "start"]
