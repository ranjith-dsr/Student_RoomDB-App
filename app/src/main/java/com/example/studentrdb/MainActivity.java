package com.example.studentrdb;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentrdb.entity.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText studentNameET, studentEmailET;
    private Button submitBTN, fetchBTN, deleteBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentNameET = findViewById(R.id.studentNameET);
        studentEmailET = findViewById(R.id.studentEmailET);
        submitBTN = findViewById(R.id.submitBTN);
        fetchBTN = findViewById(R.id.fetchBTN);
        deleteBTN = findViewById(R.id.deleteBTN);

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
            List<Student> allStudentList = studentDAO.getAllStudentList();
            if (allStudentList.isEmpty()) {
                Toast.makeText(this, "No records found!", Toast.LENGTH_SHORT).show();
                return;
            }

            for (Student student1 : allStudentList) {
                Toast.makeText(this, "name : " + student1.getStudentName(), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "email : " + student1.getStudentEmail(), Toast.LENGTH_SHORT).show();
            }


        });

        deleteBTN.setOnClickListener(v -> {
            studentDAO.deleteAll();
            Toast.makeText(this, "Records deleted successfully ", Toast.LENGTH_SHORT).show();
        });
    }
}