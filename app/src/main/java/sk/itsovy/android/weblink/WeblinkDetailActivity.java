package sk.itsovy.android.weblink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WeblinkDetailActivity extends AppCompatActivity {

    public static final String WEBLINK_TAG = "weblink";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weblink_detail);

        EditText editText = findViewById(R.id.weblinkDetailEditText);
        TextView textView = findViewById(R.id.weblinkDetailTextView);

        Intent intent = getIntent();
        Weblink weblink = (Weblink) intent.getSerializableExtra(WEBLINK_TAG);
        textView.setText(weblink.getUrl());
        editText.setText(weblink.getTitle());
    }
}