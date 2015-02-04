package materialtest.com.example.andr.materialtest;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.Calendar;


public class BuscaRotaActivity extends ActionBarActivity {


    private Toolbar toolbar;
    Button button;
    EditText dataEdit;
    EditText hourEdit;
    CheckBox checkBoxAgora;
    TextView textAgendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_rota);

        //Toolbar

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        //Spinner

        Spinner spinner = (Spinner) findViewById(R.id.spinnerPreferencias);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerRotas, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        //Botão
        button = (Button) findViewById(R.id.botaoBuscar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuscaRotaActivity.this, EscolhaRotaActivity.class);
                startActivity(intent);
            }
        });
        checkBoxAgora = (CheckBox) findViewById(R.id.checkboxAgora);
        textAgendar = (TextView) findViewById(R.id.textAgendar);

        //Data
        dataEdit = (EditText) findViewById(R.id.dataEditView);
        dataEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("André", "Abri o datePicker");
                checkBoxAgora.setChecked(false);
                enableAgendar();
                Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                System.out.println("the selected " + mDay);
                DatePickerDialog dialog = new DatePickerDialog(BuscaRotaActivity.this,
                        new mDateSetListener(), mYear, mMonth, mDay);
                dialog.show();


                /*DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    }
                };
                DatePickerDialog dialog = new DatePickerDialog(BuscaRotaActivity.this, callback, );
                DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
                boolean wrapInScrollView = true;
                new MaterialDialog.Builder(BuscaRotaActivity.this)

                        .customView(R.layout.date_picker, wrapInScrollView)
                        .positiveText(R.string.ok).positiveColor(R.color.primaryColor)
                        .build()
                        .show();*/
            }
        });

        hourEdit= (EditText) findViewById(R.id.horaEditView);
        hourEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("André", "Abri o hourPicker");
                checkBoxAgora.setChecked(false);
                enableAgendar();
                Calendar c = Calendar.getInstance();
                int mHour = c.get(Calendar.HOUR_OF_DAY);
                int mMinute = c.get(Calendar.MINUTE);
                boolean is24HourView = true;
                TimePickerDialog timePickerDialog = new TimePickerDialog(BuscaRotaActivity.this, new mTimeSetListener(),mHour,mMinute, is24HourView);

                timePickerDialog.show();

            }
        });



        checkBoxAgora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxAgora.isChecked()){
                    //Desabilita toda a parte de agendar e habilita checkbox
                    disableAgendar();
                } else if (!checkBoxAgora.isChecked()){
                    //Habilita parte de agendar e desabilita checkbox
                    enableAgendar();

                }
            }
        });
    }

    public void enableAgendar(){
        textAgendar.setTextColor(getResources().getColor(R.color.black));
        dataEdit.setTextColor(getResources().getColor(R.color.black));
        hourEdit.setTextColor(getResources().getColor(R.color.black));
        checkBoxAgora.setTextColor(getResources().getColor(R.color.colorHighlight));
    }
    public void disableAgendar(){
        textAgendar.setTextColor(getResources().getColor(R.color.colorHighlight));
        dataEdit.setTextColor(getResources().getColor(R.color.colorHighlight));
        hourEdit.setTextColor(getResources().getColor(R.color.colorHighlight));
        checkBoxAgora.setTextColor(getResources().getColor(R.color.black));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_busca_rota, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class mDateSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            // getCalender();
            int mYear = year;
            int mMonth = monthOfYear;
            int mDay = dayOfMonth;
            EditText v = (EditText) findViewById(R.id.dataEditView);
            v.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mDay).append("/").append(mMonth + 1).append("/")
                    .append(mYear).append(" "));
            System.out.println(v.getText().toString());


        }
    }

    class mTimeSetListener implements TimePickerDialog.OnTimeSetListener {


        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            int mHourOfDay = hourOfDay;
            int mMinute = minute;
            EditText hourText = (EditText) findViewById(R.id.horaEditView);
            hourText.setText(new StringBuilder().append(mHourOfDay).append(":").append(mMinute));

        }
    }
}
