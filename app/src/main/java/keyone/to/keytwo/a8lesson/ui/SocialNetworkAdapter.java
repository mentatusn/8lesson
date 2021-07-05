package keyone.to.keytwo.a8lesson.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

import keyone.to.keytwo.a8lesson.R;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.SocialNetworkViewHolder> {

    private String[] dataSource;


    private OnMyClickListener onMyClickListener;

    public void SetOnMyClickListener(OnMyClickListener onMyClickListener){
        this.onMyClickListener = onMyClickListener;
    }

    public SocialNetworkAdapter(String[] dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public SocialNetworkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new SocialNetworkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SocialNetworkViewHolder holder, int position) {
        holder.getTextView().setText(this.dataSource[position]);
        holder.getTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMyClickListener.onMyClick(view,position);
                Toast.makeText(view.getContext(), "Тост за то что работает " + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSource.length;
    }


    public class SocialNetworkViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public SocialNetworkViewHolder(View itemView) {
            super(itemView);
            textView = ((LinearLayout) itemView).findViewById(R.id.textView);
            /*textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onMyClickListener.onMyClick(view,getAdapterPosition());
                    Toast.makeText(view.getContext(), "Тост за то что работает " + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                }
            });*/
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
