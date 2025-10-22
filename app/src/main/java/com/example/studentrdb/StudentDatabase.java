package com.example.studentrdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.studentrdb.entity.Student;


@Database(entities = Student.class, version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    private static StudentDatabase studentDatabaseInstance;
    /*🧠 The Concept: “Singleton Pattern”

    Room databases are expensive objects — they open file connections, manage threads, and maintain caches.
            So, Android best practice is to create only one instance of your database for the entire app.

            That’s why we use the Singleton pattern.

     */

    public abstract StudentDAO studentDAO();

    public static synchronized StudentDatabase getStudentDatabaseInstance(Context context) {
//Singleton pattern.
        if (studentDatabaseInstance == null) {
            studentDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                            StudentDatabase.class, "student_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() //avoid this in production
                    //.allowMainThreadQueries() → lets you query on the main thread (not recommended for real apps).
                    .build();
        }
        return studentDatabaseInstance;
    }
}

/*
✅ What happens here:

        First time → it creates the DB (instance = Room.databaseBuilder(...))

        Next time → it just returns the same instance (no new DB created)

        synchronized → makes it thread-safe (important when
        multiple threads access it)
 */
