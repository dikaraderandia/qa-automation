# 🚀 QA Automation Project - API Testing

## 📌 Overview

This project demonstrates **API Automation Testing** using Java.
The goal is to validate API endpoints automatically using a **data-driven testing approach** and reusable methods.

The automation covers:

* Positive testing
* Negative testing
* Data-driven testing
* Reusable API methods

---

## 🛠️ Tech Stack

* Java
* Rest Assured
* TestNG
* Maven
* Jackson (JSON Serializer)

---

## 📂 Project Structure

```
src
├── main
│   └── java
│       └── com.dikara
│           ├── api          → API layer (request handling)
│           └── dto          → Request & Response models (POJO)
│
├── test
│   └── java
│       └── com.dikara
│           └── test         → Test cases
```

---

## 🔧 Features Implemented

### ✅ API Testing

* GET Users
* GET User Detail
* POST Create User

### ✅ Validation

* Status code validation
* Response body validation
* JSON field validation

### ✅ Data-Driven Testing

Implemented using TestNG `@DataProvider` to execute tests with multiple input datasets.

---

## 🧪 Sample Test Case

### Create User (Data-Driven)

**Test Inputs:**

* Valid data
* Empty name
* Empty job

**Validations:**

* Status code verification
* Response body matches request payload
* ID is not null

---

## 🔁 Reusable API Method

Example:

```java
public Response createUser(UserRequest user){
    return given()
            .contentType("application/json")
            .body(user)
            .when()
            .post("/users");
}
```

---

## ▶️ How to Run

1. Clone the repository

```
git clone https://github.com/your-username/your-repo.git
```

2. Navigate to the project directory

```
cd your-repo
```

3. Run the tests

```
mvn clean test
```

---

## 🎯 Learning Outcomes

Through this project, I gained hands-on experience in:

* API automation using Rest Assured
* Implementing data-driven testing with TestNG
* Designing reusable API layers
* Response handling and assertions
* Applying QA mindset in API testing

---

## ⚠️ Notes

The API used in this project is a dummy API (JSONPlaceholder), therefore:

* Some validations are not enforced by the API
* Certain negative test cases still return successful responses

---

## 👤 Author

Dikara Derandia

---
