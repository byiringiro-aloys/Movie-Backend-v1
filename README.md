# Movies API

A RESTful API for managing movies and reviews built with Spring Boot and MongoDB.

## Overview

This application provides a simple yet powerful API for managing movie information and user reviews. It's built using Spring Boot 3.5.4 with Java 24 and uses MongoDB as the database.

## Technology Stack

- **Framework**: Spring Boot 3.5.4
- **Language**: Java 24
- **Database**: MongoDB
- **Build Tool**: Maven
- **Lombok**: For reducing boilerplate code

## Project Structure

```
src/main/java/dev/aloys/Movies/
├── controller/
│   ├── MoviesController.java      # Handles movie-related HTTP requests
│   └── ReviewsController.java     # Handles review-related HTTP requests
├── model/
│   ├── Movies.java               # Movie entity
│   └── Reviews.java              # Review entity
├── repository/
│   ├── MoviesRepository.java     # Data access for movies
│   └── ReviewRepository.java     # Data access for reviews
├── service/
│   ├── MovieService.java         # Business logic for movies
│   └── ReviewService.java        # Business logic for reviews
└── MoviesApplication.java        # Main application class
```

## Features

### Movie Management
- Retrieve all movies
- Get movie by IMDB ID
- Store movie information (title, release date, genres, poster, etc.)

### Review System
- Create reviews for movies
- Link reviews to specific movies via IMDB ID

## Getting Started

### Prerequisites

- Java 24 or higher
- Maven 3.6+
- MongoDB instance

### Environment Setup

Create a `.env` file with:
```env
MONGO_URI=your_mongodb_connection_string
MONGO_DATABASE=your_database_name
```

### Installation

1. **Clone and navigate to project**
   ```bash
   cd Movies
   ```

2. **Build the project**
   ```bash
   ./mvnw clean install
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

The application starts on `http://localhost:8080`

## API Endpoints

### Movies

#### Get All Movies
```http
GET /api/v1/movies
```

#### Get Movie by IMDB ID
```http
GET /api/v1/movies/{imdbId}
```

### Reviews

#### Create a Review
```http
POST /api/v1/reviews
```

**Request Body:**
```json
{
  "reviewBody": "This is an amazing movie!",
  "imdbId": "tt1234567"
}
```

## Database Schema

### Movies Collection
```json
{
  "_id": "ObjectId",
  "imdbId": "String",
  "title": "String",
  "releaseDate": "String",
  "trailerLink": "String",
  "genres": ["String"],
  "poster": "String",
  "backdrops": ["String"],
  "reviewIds": ["ObjectId"]
}
```

### Reviews Collection
```json
{
  "_id": "ObjectId",
  "body": "String"
}
```

## Testing

Run tests with:
```bash
./mvnw test
```

## Dependencies

- `spring-boot-starter-web`: Web application support
- `spring-boot-starter-data-mongodb`: MongoDB integration
- `spring-boot-devtools`: Development tools
- `lombok`: Reduces boilerplate code
- `spring-dotenv`: Environment variable support 