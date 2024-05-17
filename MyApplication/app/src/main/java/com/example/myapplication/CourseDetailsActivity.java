package com.example.myapplication;

import static com.amplifyframework.api.graphql.GraphQLRequest.*;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;




import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.api.aws.GsonVariablesSerializer;
import com.amplifyframework.api.graphql.SimpleGraphQLRequest;
import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.datastore.generated.model.StudentIDName;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;

import com.amplifyframework.api.graphql.GraphQLRequest;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.api.graphql.GraphQLResponse;
import com.google.gson.Gson;


public class CourseDetailsActivity extends AppCompatActivity{

    private LinearLayout linearLayoutExams;
    private static final int REQUEST_CODE_CSV = 123;
    public static  int i=0;

    private TextView filename;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_details_activity);
        filename  = findViewById(R.id.FileName);
        linearLayoutExams = findViewById(R.id.coursedetailsactivitylayout);

        String courseName = getIntent().getStringExtra("courseName");

        TextView textViewCourseName = findViewById(R.id.courseName);
        textViewCourseName.setText(courseName);



        Button addExam = findViewById(R.id.addExam);
        addExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogToAddExam();
            }
        });

        Button uploadclassroster = findViewById(R.id.classroster);
        uploadclassroster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilePicker();
            }
        });

        Button viewClassButton = findViewById(R.id.viewClassButton);
        viewClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayClassRoster();
            }
        });

        //Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("StudentInfo",MODE_PRIVATE);
    }
    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, "Select CSV"), REQUEST_CODE_CSV);

    }

    private void showDialogToAddExam() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_exam, null);
        final EditText editTextExamName = dialogView.findViewById(R.id.editTextExamName);

        builder.setView(dialogView)
                .setTitle("Add New Exam")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String ExamName = editTextExamName.getText().toString();
                        addExamBox(ExamName);
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void addExamBox(String ExamName) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, 0, 0, 16);

        LinearLayout ExamBoxLayout = new LinearLayout(this);
        ExamBoxLayout.setLayoutParams(layoutParams);
        ExamBoxLayout.setOrientation(LinearLayout.VERTICAL);

        TextView textViewExamName = new TextView(this);
        textViewExamName.setText(ExamName);
        textViewExamName.setTextColor(Color.BLACK);
        textViewExamName.setTypeface(null, Typeface.BOLD);
        ExamBoxLayout.addView(textViewExamName);

        Button viewExamButton = new Button(this);
        viewExamButton.setText("View Exam");
        viewExamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseDetailsActivity.this, ExamDetailsActivity.class);
                intent.putExtra("ExamName_", ExamName);

                startActivity(intent);
            }
        });
        ExamBoxLayout.addView(viewExamButton);

        linearLayoutExams.addView(ExamBoxLayout);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CSV && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                Uri uri = data.getData();
                if (uri != null) {
                    String fileName = getFileName(uri);
                    filename = (TextView) findViewById(R.id.FileName);
                    filename.setText(fileName);
                    parseCSVFile(uri);
                }
            }
        }
    }
    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            try (Cursor cursor = getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME));
                }
            }
        }
        if (result == null) {
            result = uri.getLastPathSegment();
        }
        return result;
    }

    class Student {
        String UMBCID;
        String studentName;

        public Student(String UMBCID, String studentName) {
            this.UMBCID = UMBCID;
            this.studentName = studentName;
        }
    }

    private void parseCSVFile(Uri uri){
        List<Student> students = new ArrayList<>();
        try{

            InputStream inputStream = getContentResolver().openInputStream(uri);
            if(inputStream!=null){
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = reader.readLine();
                while (line != null) {
                    //Format: Name,UMBC id
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String studentName = parts[0];
                        String umbcId = parts[1];
                        students.add(new Student(umbcId, studentName));
                        storeStudentInfo(studentName, umbcId);
                        filename.setVisibility(View.VISIBLE);
                        findViewById(R.id.viewClassButton).setVisibility(View.VISIBLE);
                    }
                    line = reader.readLine();
                }
                reader.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        uploadStudents(students);
    }

    private void uploadStudents(List<Student> students) {

        Log.d("CourseDetailsActivity", "Starting to upload students");

        for (Student student : students) {
            //Log.d("CourseDetailsActivity", "Uploading student: " + student.UMBCID);
            createStudentRecord(student);
        }
        Log.d("CourseDetailsActivity", "All students uploaded");
    }

    private void createStudentRecord(Student student) {

        String mutation = "mutation CreateStudentIDName($input: CreateStudentIDNameInput!, $condition: ModelStudentIDNameConditionInput) {" +
                "  createStudentIDName(input: $input, condition: $condition) {" +
                "    UMBCID" +
                "    studentName" +
                "  }" +
                "}";
        Map<String, Object> variables = new HashMap<>();
        i+=1;
        //variables.put("id",i);
        variables.put("UMBCID", "student.UMBCID");
        variables.put("studentName", student.studentName);
        Log.d("Hello",student.UMBCID+student.studentName);
        Gson gson = new Gson();
        String inputJson = gson.toJson(variables);
        if (inputJson == null || inputJson.isEmpty()) {
            Log.e("CreateStudent", "Failed to serialize input.");
            return; // Skip sending the mutation
        }
        if (variables.containsKey("UMBCID") && variables.containsKey("studentName")) {
            Log.d("CreateStudent", "Sending input: " + inputJson);
            GraphQLRequest<StudentIDName> request = new SimpleGraphQLRequest<>(
                    mutation,
                    variables,
                    StudentIDName.class,
                    new GsonVariablesSerializer());

            Amplify.API.mutate(request,
                    response -> handleResponse(response),
                    error -> Log.e("uploadStudents", "Failed to add student", error)
            );
        }
        else {
            Log.e("CreateStudent", "Missing required fields in input map.");
        }

    }

    private void handleResponse(GraphQLResponse<StudentIDName> response) {
        if (response.hasData()) {
            StudentIDName student = response.getData();
            Log.i("ApiQuickstart", "Created student with ID: " + student.getId());
        } else if (response.hasErrors()) {
            Log.e("ApiQuickstart", "Errors: " + response.getErrors().toString());
        }
    }



    private void storeStudentInfo(String studentName, String umbcId){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(umbcId,studentName);
        editor.apply();


    }

    private void displayClassRoster() {
        // Create a BottomSheetDialog
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.dialog_view_class_roster); // Create a layout file for the dialog

        // Retrieve the LinearLayout from the dialog layout
        LinearLayout rosterLayout = bottomSheetDialog.findViewById(R.id.rosterLayout);

        // Retrieve and display stored student names and IDs
        Map<String, ?> allEntries = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String studentName = entry.getValue().toString();
            String umbcId = entry.getKey();
            TextView studentInfoTextView = new TextView(this);
            studentInfoTextView.setText("Name: " + studentName + ", UMBC ID: " + umbcId);
            studentInfoTextView.setTextColor(Color.BLACK);
            studentInfoTextView.setTextSize(16);
            // Add the TextView to the layout inside the dialog
            rosterLayout.addView(studentInfoTextView);
        }

        // Show the BottomSheetDialog
        bottomSheetDialog.show();
    }

}