package com.dk.ricardo.eeas2.fragments.MedicFiles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.fragments.ControlPanel.ActGestorFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment {


    String url="https://www.google.com/maps/d/u/0/edit?mid=1CZ6nTmGGJ8cdsVNIyBGvuPqjNrGIukdX&ll=20.708657259690106%2C-103.39505621474262&z=17";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        WebView web = view.findViewById(R.id.MapsLoca);
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

}
