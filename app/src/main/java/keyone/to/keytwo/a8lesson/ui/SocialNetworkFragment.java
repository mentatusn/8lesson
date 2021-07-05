package keyone.to.keytwo.a8lesson.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import keyone.to.keytwo.a8lesson.R;


public class SocialNetworkFragment extends Fragment {


    public static SocialNetworkFragment newInstance() {
        return new SocialNetworkFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_social_network, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        String[] data = getResources().getStringArray(R.array.titles);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        SocialNetworkAdapter socialNetworkAdapter = new SocialNetworkAdapter(data);
        socialNetworkAdapter.SetOnMyClickListener(new OnMyClickListener() {
            @Override
            public void onMyClick(View view, int position) {
                Toast.makeText(view.getContext(), "Тост за то что работает " + ((TextView) view).getText()+" "+position, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(socialNetworkAdapter);
        return view;
    }
}