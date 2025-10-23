package com.example.studentrdb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentrdb.adapter.StudentAdapter;
import com.example.studentrdb.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText studentNameET, studentEmailET;
    private Button submitBTN, fetchBTN, deleteBTN;
    private RecyclerView studentRV;
    private List<Student> allStudentListFromDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentNameET = findViewById(R.id.studentNameET);
        studentEmailET = findViewById(R.id.studentEmailET);
        submitBTN = findViewById(R.id.submitBTN);
        fetchBTN = findViewById(R.id.fetchBTN);
        deleteBTN = findViewById(R.id.deleteBTN);
        studentRV = findViewById(R.id.studentRV);

        studentRV.setLayoutManager(new LinearLayoutManager(this));

        //create db instance
        StudentDatabase studentDatabase = StudentDatabase.getStudentDatabaseInstance(MainActivity.this);

        StudentDAO studentDAO = studentDatabase.studentDAO();


        submitBTN.setOnClickListener(v -> {

            String studentName = studentNameET.getText().toString().trim();
            String studentEmail = studentEmailET.getText().toString().trim();

            //insert to db
            studentDAO.insertStudent(new Student(studentName, studentEmail));
            studentNameET.setText("");
            studentEmailET.setText("");
            Toast.makeText(this, "Inserted Successfully !", Toast.LENGTH_SHORT).show();


        });
        fetchBTN.setOnClickListener(v -> {

            //Fetch all users
            allStudentListFromDB = studentDAO.getAllStudentList();

            // Safe null check
            if (allStudentListFromDB == null || allStudentListFromDB.isEmpty()) {

                //But if there’s a chance that method returns null, it’s still safer to do:
                allStudentListFromDB = new ArrayList<>();
                Toast.makeText(this, "No records found!", Toast.LENGTH_SHORT).show();
                return;
            }

            StudentAdapter studentAdapter = new StudentAdapter(allStudentListFromDB);
            studentRV.setVisibility(View.VISIBLE);
            studentRV.setAdapter(studentAdapter);

        });

        deleteBTN.setOnClickListener(v -> {
            studentDAO.deleteAll();
            studentDAO.resetAutoIncrement();
            /*
            ✅ Solution: Reset the Auto-Increment Counter

                In SQLite, the auto-increment value is stored
                  in a special table named sqlite_sequence.
                So you can reset it manually after deleting all rows.

             */
            Toast.makeText(this, "Records deleted and ID reset successfully", Toast.LENGTH_SHORT).show();
        });
    }
}