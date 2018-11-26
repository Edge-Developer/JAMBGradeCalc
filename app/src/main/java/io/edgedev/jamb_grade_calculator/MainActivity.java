package io.edgedev.jamb_grade_calculator;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatSpinner;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import io.edgedev.jamb_grade_calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button calculate;
    private AppCompatSpinner grade1;
    private AppCompatSpinner grade2;
    private AppCompatSpinner grade3;
    private AppCompatSpinner grade4;
    private AppCompatSpinner grade5;
    private EditText jamb_score_edit;
    private AppCompatRadioButton singleSitting, combinedSitting;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        jamb_score_edit = binding.jambScoreEdit;
        grade1 = binding.spinner1;
        grade2 = binding.spinner2;
        grade3 = binding.spinner3;
        grade4 = binding.spinner4;
        grade5 = binding.spinner5;
        singleSitting = binding.singleSitting;
        combinedSitting = binding.combinedSitting;
        calculate = binding.calculate;
        mAdView = binding.adView;

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcPoints();
            }
        });
    }

    public void calcPoints() {


        if (TextUtils.isEmpty(jamb_score_edit.getText().toString())) {
            jamb_score_edit.setError("Jamb Score Required");
        } else {

            int spinner_position1 = grade1.getSelectedItemPosition() + 1;
            int spinner_position2 = grade2.getSelectedItemPosition() + 1;
            int spinner_position3 = grade3.getSelectedItemPosition() + 1;
            int spinner_position4 = grade4.getSelectedItemPosition() + 1;
            int spinner_position5 = grade5.getSelectedItemPosition() + 1;


            int subject_point1 = 0;
            int subject_point2 = 0;
            int subject_point3 = 0;
            int subject_point4 = 0;
            int subject_point5 = 0;
            int sitting_points = 0;
            int jamb_score_point = 0;

            if (singleSitting.isChecked()) {
                sitting_points = 10;
            } else if (combinedSitting.isChecked()) {
                sitting_points = 2;
            }

            if (spinner_position1 == 1) {
                subject_point1 = 6;
            } else if (spinner_position1 == 2 || spinner_position1 == 3) {
                subject_point1 = 4;
            } else if (spinner_position1 == 4 || spinner_position1 == 5 || spinner_position1 == 6) {
                subject_point1 = 3;
            }

            if (spinner_position2 == 1) {
                subject_point2 = 6;
            } else if (spinner_position2 == 2 || spinner_position2 == 3) {
                subject_point2 = 4;
            } else if (spinner_position2 == 4 || spinner_position2 == 5 || spinner_position2 == 6) {
                subject_point2 = 3;
            }

            if (spinner_position3 == 1) {
                subject_point3 = 6;
            } else if (spinner_position3 == 2 || spinner_position3 == 3) {
                subject_point3 = 4;
            } else if (spinner_position3 == 4 || spinner_position3 == 5 || spinner_position3 == 6) {
                subject_point3 = 3;
            }

            if (spinner_position4 == 1) {
                subject_point4 = 6;
            } else if (spinner_position4 == 2 || spinner_position4 == 3) {
                subject_point4 = 4;
            } else if (spinner_position4 == 4 || spinner_position4 == 5 || spinner_position4 == 6) {
                subject_point4 = 3;
            }

            if (spinner_position5 == 1) {
                subject_point5 = 6;
            } else if (spinner_position5 == 2 || spinner_position5 == 3) {
                subject_point5 = 4;
            } else if (spinner_position5 == 4 || spinner_position5 == 5 || spinner_position5 == 6) {
                subject_point5 = 3;
            }

            String s = jamb_score_edit.getText().toString();

            Log.e(TAG, "-------------------------------------------------------");
            Log.e(TAG, "calcPoints: " + s);
            Log.e(TAG, "-------------------------------------------------------");

            int jamb_score = Integer.parseInt(s);
            Log.e(TAG, "calcPoints: " + jamb_score);

            if (jamb_score >= 180 && jamb_score <= 185) {
                jamb_score_point = 20;
            } else if (jamb_score >= 186 && jamb_score <= 190) {
                jamb_score_point = 21;
            } else if (jamb_score >= 191 && jamb_score <= 195) {
                jamb_score_point = 22;
            } else if (jamb_score >= 196 && jamb_score <= 200) {
                jamb_score_point = 23;
            } else if (jamb_score >= 201 && jamb_score <= 205) {
                jamb_score_point = 24;
            } else if (jamb_score >= 206 && jamb_score <= 210) {
                jamb_score_point = 25;
            } else if (jamb_score >= 211 && jamb_score <= 215) {
                jamb_score_point = 26;
            } else if (jamb_score >= 216 && jamb_score <= 220) {
                jamb_score_point = 27;
            } else if (jamb_score >= 221 && jamb_score <= 225) {
                jamb_score_point = 28;
            } else if (jamb_score >= 226 && jamb_score <= 230) {
                jamb_score_point = 29;
            } else if (jamb_score >= 231 && jamb_score <= 235) {
                jamb_score_point = 30;
            } else if (jamb_score >= 236 && jamb_score <= 240) {
                jamb_score_point = 31;
            } else if (jamb_score >= 241 && jamb_score <= 245) {
                jamb_score_point = 32;
            } else if (jamb_score >= 246 && jamb_score <= 250) {
                jamb_score_point = 33;
            } else if (jamb_score >= 251 && jamb_score <= 255) {
                jamb_score_point = 34;
            } else if (jamb_score >= 256 && jamb_score <= 260) {
                jamb_score_point = 35;
            } else if (jamb_score >= 261 && jamb_score <= 265) {
                jamb_score_point = 36;
            } else if (jamb_score >= 266 && jamb_score <= 270) {
                jamb_score_point = 37;
            } else if (jamb_score >= 271 && jamb_score <= 275) {
                jamb_score_point = 38;
            } else if (jamb_score >= 276 && jamb_score <= 280) {
                jamb_score_point = 39;
            } else if (jamb_score >= 281 && jamb_score <= 285) {
                jamb_score_point = 40;
            } else if (jamb_score >= 286 && jamb_score <= 290) {
                jamb_score_point = 41;
            } else if (jamb_score >= 291 && jamb_score <= 295) {
                jamb_score_point = 42;
            } else if (jamb_score >= 296 && jamb_score <= 390) {
                jamb_score_point = 43;
            } else if (jamb_score >= 391 && jamb_score <= 395) {
                jamb_score_point = 44;
            } else if (jamb_score >= 396 && jamb_score <= 400) {
                jamb_score_point = 45;
            }

            int xyz = subject_point1 + subject_point2 + subject_point3 + subject_point4 + subject_point5 + jamb_score_point + sitting_points;

            Context context = this;

            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(context);
            final View mView = layoutInflaterAndroid.inflate(R.layout.point_dialog, null);
            TextView textView = (TextView) mView.findViewById(R.id.points_txt_dialog);
            textView.setText("" + xyz);
            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(context);
            alertDialogBuilderUserInput.setView(mView);

            alertDialogBuilderUserInput.setCancelable(true);

            AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
            alertDialogAndroid.show();
        }
    }
}

