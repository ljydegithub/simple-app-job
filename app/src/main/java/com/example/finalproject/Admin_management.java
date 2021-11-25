package com.example.finalproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin_management extends AppCompatActivity implements View.OnClickListener {
    private ListView stumes;
    StunNmberOpenHelper helper;
    List<String> list;
    private EditText stumes_id;
    private EditText stumes_name;
    private EditText stumes_number;
    private Button btn_delete;
    private Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_management);
        initView();
        query();
    }

    private void initView() {
        stumes = (ListView) findViewById(R.id.stumes);
        stumes_id = (EditText) findViewById(R.id.stumes_id);
        stumes_id.setOnClickListener(this);
        stumes_name = (EditText) findViewById(R.id.stumes_name);
        stumes_name.setOnClickListener(this);
        stumes_number = (EditText) findViewById(R.id.stumes_number);
        stumes_number.setOnClickListener(this);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(this);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);
    }

    public void query() {
        helper = new StunNmberOpenHelper(this);
        list = helper.listQuery();
        String[] id = new String[list.size() / 3];
        String[] name = new String[list.size() / 3];
        String[] number = new String[list.size() / 3];
        int j = 0, k = 1, l = 2, p1, p2, p3;
        p1 = p2 = p3 = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == j) {
                id[p1] = list.get(i);
                p1++;
                j += 3;
            } else if (i == k) {
                name[p2] = list.get(i);
                p2++;
                k += 3;
            } else if (i == l) {
                number[p3] = list.get(i);
                p3++;
                l += 3;
            }
        }
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("_id", id[i]);
            map.put("name", name[i]);
            map.put("number", number[i]);
            data.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.stumes_list_demo
                , new String[]{"_id", "name", "number"}, new int[]{R.id.list_id, R.id.list_name, R.id.list_number});
        stumes.setAdapter(simpleAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_delete:
                String id = stumes_id.getText().toString().trim();
                if (TextUtils.isEmpty(id)) {
                    Toast.makeText(this, "ID不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    if(helper.delete(stumes_id.getText().toString())){
                        Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "删除失败", Toast.LENGTH_SHORT).show();
                    }
                    query();
                }

                break;
            case R.id.btn_update:
                if (submit()){
                    if(helper.update(stumes_id.getText().toString(),stumes_name.getText().toString(),stumes_number.getText().toString())){
                        Toast.makeText(this, "更改成功", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "更改失败", Toast.LENGTH_SHORT).show();
                    }
                    query();
                }
                break;
        }
    }

    private boolean submit() {
        // validate
        if(true) {
            String id = stumes_id.getText().toString().trim();
            if (TextUtils.isEmpty(id)) {
                Toast.makeText(this, "ID不能为空", Toast.LENGTH_SHORT).show();
                return false;
            }
            String name = stumes_name.getText().toString().trim();
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show();
                return false;
            }

            String number = stumes_number.getText().toString().trim();
            if (TextUtils.isEmpty(number)) {
                Toast.makeText(this, "学号不能为空", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
        // TODO validate success, do something
    }
}
