package com.dk.ricardo.eeas2.fragments.Comunication;


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
public class EvaluationFragment extends Fragment {


    String url="https://goo.gl/forms/mWPargOX9jcaszL52";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_evaluation, container, false);


        WebView web = view.findViewById(R.id.webVisorEv);
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
