package sk.itsovy.android.weblink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnWeblinkClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        WeblinksAdapter adapter = new WeblinksAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onWeblinkClick(Weblink weblink) {
        Toast.makeText(this, "Kliklo sa na " + weblink.getTitle(),
                Toast.LENGTH_SHORT).show();
    }
}