package com.example.rahulmedhasoft;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rahulmedhasoft.entity.StudentInfo;

import java.util.ArrayList;
import java.util.HashMap;

//public class DetailsAdaptor extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.list_row);
//        DataBaseHelper db = new DataBaseHelper(this);
//        ArrayList<ArrayList<String>> studentList = db.getStudentDetails();
//        ListView lv = findViewById(R.id.listViewStudents);
//        ListAdapter adapter = new SimpleAdapter(DetailsAdaptor.this, studentList, R.layout.list_row, new String[]{"BeneficieryName"}, new int[]{R.id.studentName});
//        lv.setAdapter(adapter);
//    }


public class DetailsAdaptor extends BaseAdapter {

    LayoutInflater mInflater;
    Context context;
    String Totclasses;
    int countChecked = 0;

    ArrayList<StudentInfo> data = new ArrayList<>();
    private HashMap<String, String> textValues = new HashMap<>();

    public DetailsAdaptor(Context activity, ArrayList<StudentInfo> contact) {
        this.context = activity;
        this.data = contact;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        view = mInflater.inflate(R.layout.list_row_adaptor, null);
        holder = new ViewHolder();
        holder.studentName = view.findViewById(R.id.studentName);
        holder.fatherName = view.findViewById(R.id.fatherName);
        holder.motherName = view.findViewById(R.id.motherName);

        view.setTag(holder);
        countChecked = 0;
        int pos = i+1;

        if (data != null) {
            StudentInfo country = data.get(i);
            String studentName = country.getBeneficieryName();
            if (studentName != null) {
                holder.studentName.setText("Name: " + studentName);
            }
            String fatherName = country.getFHName();
            if (fatherName != null) {
                holder.fatherName.setText("FName: " + fatherName);
            }
            String motherName = country.getMName();
            if (motherName != null) {
                holder.motherName.setText("MName: " + motherName);
            }
        }
        notifyDataSetChanged();
        return view;
    }

    private class ViewHolder
    {
        TextView studentName, fatherName, motherName;
        LinearLayout list_row_detail;
    }
}
