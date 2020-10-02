package sk.itsovy.android.weblink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WeblinksAdapter
        extends RecyclerView.Adapter<WeblinksAdapter.WeblinksViewHolder> {

    private List<String> weblinks;

    public WeblinksAdapter() {
        weblinks = new ArrayList<>();
        weblinks.add("Vermilion flycatcher");
        weblinks.add("HMS Royalist");
        weblinks.add("Leonor Tomásia de Távora, 3rd Marquise of Távora");
        weblinks.add("Tomomi Seo");
        weblinks.add("Signomial");
        weblinks.add("2015 Kyrgyz parliamentary election");
        weblinks.add("Iberian ribbed newt");

    }

    @NonNull
    @Override
    public WeblinksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weblink_layout, parent, false);
        return new WeblinksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeblinksViewHolder holder, int position) {
        holder.bind(weblinks.get(position));
    }

    @Override
    public int getItemCount() {
        return weblinks.size();
    }

    public class WeblinksViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public WeblinksViewHolder(@NonNull View layout) {
            super(layout);
            textView = layout.findViewById(R.id.textViewWeblinkTitle);
        }

        public void bind(String weblink) {
            textView.setText(weblink);
        }
    }
}
