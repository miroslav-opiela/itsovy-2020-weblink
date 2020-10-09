package sk.itsovy.android.weblink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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

    public void update(Weblink weblink) {
        for (int i = 0; i < this.weblinks.size(); i++) {
            if (weblinks.get(i).getUuid().equals(weblink.getUuid())) {
                weblinks.set(i, weblink);
            }
        }
        notifyDataSetChanged();
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
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onWeblinkClick(weblink);
                }
            });
            textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onWeblinkLongClick(weblink);
                    return true;
                }
            });
            ratingBar.setRating(weblink.getRating());
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    weblink.setRating((int) rating);
                }
            });
        }
    }
}
