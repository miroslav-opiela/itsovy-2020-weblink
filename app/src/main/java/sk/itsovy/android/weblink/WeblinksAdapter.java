package sk.itsovy.android.weblink;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WeblinksAdapter
        extends RecyclerView.Adapter<WeblinksAdapter.WeblinksViewHolder> {

    @NonNull
    @Override
    public WeblinksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WeblinksViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class WeblinksViewHolder extends RecyclerView.ViewHolder {

        public WeblinksViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
