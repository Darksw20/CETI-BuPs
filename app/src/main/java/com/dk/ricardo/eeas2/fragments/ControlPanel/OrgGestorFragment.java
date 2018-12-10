package com.dk.ricardo.eeas2.fragments.ControlPanel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.dk.ricardo.eeas2.Adapters.RecyclerAdapter;
import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.utilidades.Items.ItemData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrgGestorFragment extends Fragment  implements RecyclerAdapter.ItemClickListener{

    RecyclerView orgGestor;
    RecyclerAdapter recyclerAdapter;
    ArrayList<ItemData> itemData=new ArrayList<>();

    String url="http://scoutbups.com/bupsWeb/sideBarOrga.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_org_gestor, container, false);



        WebView web = view.findViewById(R.id.webVisorOrgGest);
        web.setWebViewClient(new MyWebViewClient());
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.loadUrl(url);


        return view;
    }
    private class MyWebViewClient extends WebViewClient
    {
        public boolean shouldOverrideUrlLoading(WebView view,String url)
        {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "You clicked " + recyclerAdapter.getItem(position).getTitle().toString() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
