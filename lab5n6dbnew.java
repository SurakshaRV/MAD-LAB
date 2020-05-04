DatabaseHelper.java

package com.example.lab5n6db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "department.db";
    public static final String TABLE_NAME="student_table";
    public static final String COLUMN_ID="ID";
    public static final String COLUMN_NAME="Name";
    public static final String COLUMN_MARKS="Marks";
    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists "+TABLE_NAME+"(" + COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUMN_NAME+" TEXT,"+COLUMN_MARKS+" INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public void insert_record(String name,int marks)
    {
        String query="INSERT INTO student_table VALUES(null,'"+name+"',"+marks+");";
        db.execSQL(query);
    }
    public StringBuffer display_all_records(){
        StringBuffer buffer=new StringBuffer();
        Cursor c=db.rawQuery("SELECT * FROM student_table", null);
        if(c.getCount()==0)    {
            buffer.append("Error"+ "No records found");
            return(buffer);     }
        while(c.moveToNext())
        {
            buffer.append("ID: "+c.getString(0)+"\n");
            buffer.append("Name: "+c.getString(1)+"\n");
            buffer.append("Name: "+c.getString(2)+"\n\n");
        }
        return(buffer); }
    public void update_record(String name, int marks) {
        String query = "UPDATE student_table SET Marks=" + marks + " WHERE Name='" + name + "';";
        db.execSQL(query);
    }
    public void delete_record(String name){
        String query="DELETE FROM student_table WHERE Name='"+name+"';";
        db.execSQL(query);
    }


}
///////////////////////////////////////////////////////////////////////////////////////////////////
MainActivity.java

package com.example.lab5n6db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDbHelper;
    EditText name_txt,marks_txt;
    TextView display_txt;
    Button insert_btn,display_btn,update_btn,delete_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDbHelper = new DatabaseHelper(MainActivity.this);
        name_txt = (EditText) findViewById(R.id.editText);
        marks_txt = (EditText) findViewById(R.id.editText2);
        insert_btn = (Button) findViewById(R.id.button);
        display_txt = (TextView) findViewById(R.id.textView4);
        update_btn = (Button) findViewById(R.id.button3);
        delete_btn=(Button)findViewById(R.id.button4);
        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDbHelper.insert_record(name_txt.getText().toString(),
                        Integer.parseInt(marks_txt.getText().toString()));
                showMessage("Success Record inserted");
            }
        });
        display_btn = (Button) findViewById(R.id.button2);
        display_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer record_details = (StringBuffer) myDbHelper.display_all_records();
                showMessage("display status" + record_details.toString());
            }
        });
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDbHelper.update_record(name_txt.getText().toString(),
                        Integer.parseInt(marks_txt.getText().toString()));
                clearText();
                showMessage("Success Record Updated");
            }
        });
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDbHelper.delete_record(name_txt.getText().toString());
                clearText();
                showMessage("Success Record Deleted");
            }
        });
    }

    private void clearText() {
    }

    private void showMessage (String s)
    {
        display_txt.setText(s);
    }
}
