# QuizApp

QuizApp is a Java-based web application built with Spring Boot that allows users to create, manage, and participate in quizzes. This application provides APIs for handling questions, quizzes, and results, offering a seamless experience for quiz management.

## Features

- **Manage Questions:** Add, retrieve, and filter questions by category.
- **Create Quizzes:** Generate quizzes based on a specific category and number of questions.
- **Quiz Participation:** Fetch quiz questions and submit responses.
- **Result Calculation:** Calculate and retrieve scores based on quiz submissions.

## Technologies Used

- **Backend:** Spring Boot
- **Language:** Java
- **Database:** Configurable (MySQL, H2, etc.)
- **Build Tool:** Maven
- **API Documentation:** Swagger (if implemented)

## Endpoints

### Question Controller

| HTTP Method | Endpoint                      | Description                               |
|-------------|-------------------------------|-------------------------------------------|
| GET         | `/question/getallquestions`   | Retrieve all questions.                   |
| GET         | `/question/category/{category}` | Retrieve questions by category.           |
| POST        | `/question/addquestion`       | Add a new question.                       |

### Quiz Controller

| HTTP Method | Endpoint                      | Description                               |
|-------------|-------------------------------|-------------------------------------------|
| POST        | `/quiz/create`                | Create a new quiz with a title and category. |
| GET         | `/quiz/get/{id}`              | Retrieve questions for a specific quiz.   |
| POST        | `/quiz/submit/{id}`           | Submit responses and calculate the result.|

## Project Structure

```plaintext
src/main/java/com/project/quizapp
|-- Controller        // Contains REST controllers for Questions and Quizzes.
|-- Model             // Defines the data models (e.g., Question, Response, QuestionWrapper).
|-- Service           // Contains business logic for handling questions and quizzes.
|-- Repository        // Interfaces for database operations (e.g., JPA repositories).
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- Database (e.g., MySQL, H2)

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/quizapp.git
   cd quizapp
   ```

2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/quizapp
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```


## Contribution

Contributions are welcome! Feel free to fork the repository, create a feature branch, and submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any queries or feedback, reach out to:
- **Author:** Rohith Reddy Kotha
- **Email:** [rohithreddykotha5424@gmail.com](mailto:rohithreddykotha5424@gmail.com)

---

Thank you for checking out QuizApp! 🚀

