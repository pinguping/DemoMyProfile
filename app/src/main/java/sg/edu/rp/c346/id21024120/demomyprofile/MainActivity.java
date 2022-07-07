package sg.edu.rp.c346.id21024120.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;
    RadioGroup rgGender;
    //Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);
        //btnSave = findViewById(R.id.buttonSave);

    }

    //Storing data
    @Override
    protected void onPause() {
        super.onPause();

        // step 1a: get the user input from the EditText and sotre it in a variable
        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());
        String gender;
        if (rgGender.getCheckedRadioButtonId() == R.id.radioButtonGenderMale){
            gender = "Male";
        } else {
            gender = "Female";
        }
        // step 1b: obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // step 1c: obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        // step 1d: add the key-value pair
        prefEdit.putString("name", strName);

        // save gpa too!!!!!!!!!!!!!!!!!
        prefEdit.putFloat("gpa", gpa);

        // save gender
        prefEdit.putString("gender", gender);
        // step 1e: call commit() to save the changes into SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // step 2a: obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // step 2b: retrieve the saved data from the SharedPreferences object
        String strName = prefs.getString("name", "John");
        // retrieve gpa!!!!!!!!!!!!!!
        float gpa = prefs.getFloat("gpa", 0);
        String gender = prefs.getString("gender", "Male");

        etName.setText(strName);
        etGPA.setText(gpa + "");

        // step 2c: update the UI element with the value???????????????

        if (gender.equals("Male") ){
            rgGender.check(R.id.radioButtonGenderMale);
        } else if ( gender.equals("Female") ){
            rgGender.check(R.id.radioButtonGenderFemale);
        }

    }
}