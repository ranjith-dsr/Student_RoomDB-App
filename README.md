# 🎓 StudentRDB — Room Database + RecyclerView App (Java)

An Android app built in **Java** using **Room Database** to store, fetch, and manage student records with a simple RecyclerView UI.

---

## 🚀 Features

✅ Add new student records (Name & Email)  
✅ View all stored students in a RecyclerView  
✅ Delete all student records instantly  
✅ Reset auto-increment ID counter after deletion  
✅ Built using **Room Persistence Library** for local storage  

---

## 🧠 Project Flow

1️⃣ User enters student name & email → taps **Submit**  
2️⃣ Record is inserted into Room Database  
3️⃣ User taps **Fetch** → displays all students in RecyclerView  
4️⃣ User taps **Delete** → clears all records & resets auto-increment ID  
5️⃣ Next record starts again from **ID = 1**

---

## 🧩 Tech Stack

| Layer | Technology Used |
|--------|----------------|
| Language | Java |
| Database | Room (SQLite) |
| UI | RecyclerView, XML Layouts |
| Architecture | Simple MVVM-ready structure |

---

## 📁 Folder Structure

app/
├── java/
│ └── com.example.studentrdb/
│ ├── MainActivity.java
│ ├── entity/
│ │ └── Student.java
│ ├── adapter/
│ │ └── StudentAdapter.java
│ ├── StudentDAO.java
│ └── StudentDatabase.java
└── res/
├── layout/
│ ├── activity_main.xml
│ └── activity_single_student_item.xml
└── values/
└── colors.xml, strings.xml

---

## 🧰 How to Run

1. Clone the repo:
   
   git clone https://github.com/ranjith-dsr/Student_RoomDB-App.git

Run on an emulator or physical Android device.

🧑‍💻 Author
Ranjith D S
Android Developer (Java)
📧 ranjithforchatgpt@gmail.com


💡 Future Enhancements
Add update & delete for individual records

Implement ViewModel + LiveData

Improve UI with Material Design components

---
