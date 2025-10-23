package com.example.studentrdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentrdb.R;
import com.example.studentrdb.entity.Student;

import java.util.List;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sinle_student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.studentIDTV.setText(String.valueOf(student.getId()));
        holder.studentNameTV.setText(student.getStudentName());
        holder.studentEmailTV.setText(student.getStudentEmail());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView studentIDTV, studentNameTV, studentEmailTV;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            studentIDTV = itemView.findViewById(R.id.studentIDTV);
            studentNameTV = itemView.findViewById(R.id.studentNameTV);
            studentEmailTV = itemView.findViewById(R.id.studentEmailTV);

        }
    }
}
