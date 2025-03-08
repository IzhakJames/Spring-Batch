# Spring Batch CSV to H2 Database Example

## 📋 Project Overview
This project is a Spring Boot application that demonstrates how to use **Spring Batch** to read data from a CSV file and write it into an **in-memory H2 database**. The batch job is configured to run automatically on application startup or can be manually triggered.

## 🚀 Features
- **Read CSV Files:** Utilizes `FlatFileItemReader` to parse CSV files.
- **Process Data:** Implements a custom `ItemProcessor` to process each record.
- **Write to H2 Database:** Uses `RepositoryItemWriter` to save data to an in-memory H2 database.
- **Batch Processing:** Reads, processes, and writes data in chunks of 10.
- **Logging:** Displays processing logs using Lombok's `@Slf4j` annotation.
- **H2 Console:** View and query the in-memory database using a web interface.

## 🛠️ Prerequisites
- **Java 17**
- **Maven 3.8+**
- **Spring Boot 3.4.3**

## 📂 Project Structure
```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.batch.spring_batch
│   │   │       ├── config
│   │   │       │   └── SpringBatchConfig.java
│   │   │       ├── entity
│   │   │       │   └── Person.java
│   │   │       ├── processor
│   │   │       │   └── PersonProcessor.java
│   │   │       ├── repository
│   │   │       │   └── PersonRepository.java
│   │   │       └── SpringBatchApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── people-1000.csv
└── pom.xml
```

## ⚙️ Setup Instructions
1. **Clone the Repository:**
```bash
git clone https://github.com/your-repo/spring-batch-csv-to-h2.git
cd spring-batch-csv-to-h2
```

2. **Build the Project:**
```bash
mvn clean install
```

3. **Run the Application:**
```bash
mvn spring-boot:run
```

## 🛠️ Configuration
### `application.properties`
```properties
spring.application.name=spring-batch
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=root
spring.datasource.password=root
spring.batch.jdbc.initialize-schema=always
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.batch.job.name=importPersons
logging.level.com.batch=DEBUG
```

## 🕹️ Running the Batch Job
- **Automatic Execution:** The job runs automatically when the application starts.
- **Manual Trigger:** The job can be manually triggered using a `CommandLineRunner`.

### H2 Console Access
- **URL:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `root`
- **Password:** `root`

## 🧠 How the Batch Job Works
1. **Reader:** Reads data from `people-1000.csv` using `FlatFileItemReader`.
2. **Processor:** Processes each `Person` record using `PersonProcessor`.
3. **Writer:** Writes the processed data to the H2 database via `PersonRepository`.
4. **Chunk Processing:** Executes in chunks of 10 items.

## 📊 Example Output
In the **H2 Console**, you can run the following query to view the data:
```sql
SELECT * FROM PERSON;
```
You should see the records imported from the CSV file.

## 🐛 Troubleshooting
- **No Logs Shown:** Make sure the logging level is set correctly in `application.properties`.
- **Job Not Running:** Ensure the job name is correctly specified as `spring.batch.job.name=importPersons`.
- **H2 Console Not Working:** Verify the `spring.h2.console.enabled=true` property.

## 📚 Additional Resources
- [Spring Batch Documentation](https://docs.spring.io/spring-batch/reference/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [H2 Database](https://www.h2database.com/html/main.html)

## 💡 Author
Developed by [Your Name](https://github.com/your-profile)

