package com.example.tesla.jsonparsing;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        tvData = (TextView) findViewById(R.id.textHello);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new JSONTask().execute("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoItem.txt");
                new JSONTask().execute();
            }
        });
    }

    public class JSONTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            System.out.println("here");
            ObjectMapper mapper = new ObjectMapper();

            Staff staff = createDummyObject();

            try {
                // Convert object to JSON string and save into a file directly
                //mapper.writeValue(new File("D:\\staff.json"), staff);

                // Convert object to JSON string
                String jsonInString = mapper.writeValueAsString(staff);
                System.out.println(jsonInString);

                // Convert object to JSON string and pretty print
                //jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
                //System.out.println(jsonInString);

            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private Staff createDummyObject() {

            Staff staff = new Staff();

            staff.setName("mkyong");
            staff.setAge(33);
            staff.setPosition("Developer");
            //staff.setSalary(new BigDecimal("7500"));

            List<String> skills = new ArrayList<>();
            skills.add("java");
            skills.add("python");

            //staff.setSkills(skills);

            return staff;

        }
    }
}
