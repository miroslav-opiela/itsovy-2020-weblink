package sk.itsovy.android.weblink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WeblinksAdapter
        extends RecyclerView.Adapter<WeblinksAdapter.WeblinksViewHolder> {

    private List<Weblink> weblinks;
    private OnWeblinkClickListener listener;

    public WeblinksAdapter(OnWeblinkClickListener listener) {
        this.listener = listener;
        List<String> stringList = new ArrayList<>();
        stringList.add("Vermilion flycatcher");
        stringList.add("HMS Royalist");
        stringList.add("Leonor Tomásia de Távora, 3rd Marquise of Távora");
        stringList.add("Tomomi Seo");
        stringList.add("Signomial");
        stringList.add("2015 Kyrgyz parliamentary election");
        stringList.add("Iberian ribbed newt");
        weblinks = new ArrayList<>();
        for (String s : stringList) {
            weblinks.add(new Weblink(s));
        }
        weblinks.get(0).setRating(1);
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
        holder.bind(weblinks.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return weblinks.size();
    }

    public class WeblinksViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private RatingBar ratingBar;

        public WeblinksViewHolder(@NonNull View layout) {
            super(layout);
            textView = layout.findViewById(R.id.textViewWeblinkTitle);
            ratingBar = layout.findViewById(R.id.ratingBar);
        }

        public void bind(final Weblink weblink, final OnWeblinkClickListener listener) {
            textView.setText(weblink.getTitle());
            ratingBar.setRating(weblink.getRating());

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onWeblinkClick(weblink);
                }
            });
        }
    }
}
