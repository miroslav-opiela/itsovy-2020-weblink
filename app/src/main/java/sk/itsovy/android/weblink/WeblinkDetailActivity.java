package sk.itsovy.android.weblink;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WeblinkDetailActivity extends AppCompatActivity {

    public static final String WEBLINK_TAG = "weblink";

    private EditText editText;
    private Weblink weblink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weblink_detail);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        editText = findViewById(R.id.weblinkDetailEditText);
        TextView textView = findViewById(R.id.weblinkDetailTextView);

        Intent intent = getIntent();
        weblink = (Weblink) intent.getSerializableExtra(WEBLINK_TAG);
        textView.setText(weblink.getUrl());
        editText.setText(weblink.getTitle());
    }

    public void save(View view) {
        String text = editText.getText().toString();
        weblink.setTitle(text);
        Intent intent = new Intent();
        intent.putExtra(WEBLINK_TAG, weblink);
        setResult(RESULT_OK, intent);
        finish();
    }
}