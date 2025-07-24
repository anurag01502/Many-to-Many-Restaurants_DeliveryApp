# Many-to-Many-Restaurants_DeliveryApp

# 🍽️ Restaurant and Delivery App Manager

A Spring Boot REST API project demonstrating a **many-to-many relationship** between `Restaurant` and `DeliveryApp` entities.

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **DTOs and Mapper Classes**

---

## ✅ Key Features

- Demonstrates a many-to-many relationship using JPA
- Uses DTOs to avoid infinite recursion
- Clean and organized REST API structure
- CRUD operations with both full (`PUT`) and partial (`PATCH`) updates

---

## 🔧 API Overview

### 📤 GET Endpoints
- `/restaurants` – Get all restaurants with associated delivery apps
- `/delivery_app` – Get all delivery apps with associated restaurants
- `/restaurant/{id}` – Get a specific restaurant by ID
- `/delivery_app/{id}` – Get a specific delivery app by ID
- `/restaurant?name=Yourname` – Get a restaurant by name

### 📥 POST Endpoint
- `/delivery_app` – Add a new delivery app with associated restaurants

### ♻️ PATCH Endpoint
- `/restaurant` – Partially update a restaurant
- `/delivery_app` – Partially update a delivery app

### 🔁 PUT Endpoint
- `/restaurant` – Fully update a restaurant
- `/delivery_app/{id}` – Fully update a delivery app

### 🗑️ DELETE Endpoints
- `/delivery_app` – Delete all delivery apps and their restaurants
- `/delivery_app/{id}` – Delete an app and associated restaurants

---

## 🚀 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/anurag01502/Many-to-Many-Restaurants_DeliveryApp.git
