MainActivity.java
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,marks;
    Button ins, disp, upd, del;
    DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);
        name=(EditText)findViewById(R.id.editText);
        marks=(EditText)findViewById(R.id.editText2);
        ins=(Button)findViewById(R.id.button);
        disp=(Button)findViewById(R.id.button2);
        upd=(Button)findViewById(R.id.button3);
        del=(Button)findViewById(R.id.button4);

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.insert(name.getText().toString(),Integer.parseInt(marks.getText().toString()));
            }
        });

        disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer det= (StringBuffer) myDB.display();
                //showMessage("Display status ", det.toString());
            }
        });
    }


}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
DatabaseHelper.java
package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String db_name="dept.db";
    public static final String table_name="student_table";
    public static final String col1="ID";
    public static final String col2="Name";
    public static final String col3="Marks";
    SQLiteDatabase db;

    public DatabaseHelper(@Nullable Context context) {
        super(context, db_name, null, 1);
         db=this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_query= "create table "+ table_name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Marks INTEGER)";
        db.execSQL(sql_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ table_name);
        onCreate(db);
    }

    public void insert(String name, int marks) {
        String query = " INSERT INTO student_table VALUES (null,' "+name+" ', "+marks+ ");";
        db.execSQL(query);
    }

    public StringBuffer display() {
        StringBuffer buffer= new StringBuffer();
        Cursor c=db.rawQuery("SELECT * FROM student_table",null);
        if(c.getCount()==0){
            buffer.append(" error no record found");
            return(buffer);
        }
        while(c.moveToNext()){
            buffer.append("ID : "+ c.getString(0)+ "\n");
            buffer.append("Name : "+ c.getString(1)+ "\n");
            buffer.append("Marks : "+ c.getString(2)+ "\n");
        }return(buffer);
    }
}
