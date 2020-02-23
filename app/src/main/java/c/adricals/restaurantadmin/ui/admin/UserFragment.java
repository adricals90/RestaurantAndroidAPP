package c.adricals.restaurantadmin.ui.admin;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import c.adricals.restaurantadmin.R;



public class UserFragment extends Fragment {

    UserViewModel viewModel = new UserViewModel();


    EditText mInputEmail;
    EditText mInputPassoword;
    Button mSignIn;
    TextView mText;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.content_main,container,false);
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);


        mInputEmail = view.findViewById(R.id.emial_field);
        mInputPassoword = view.findViewById(R.id.password_field);
        mSignIn = view.findViewById(R.id.sign_in_button);
        mText = view.findViewById(R.id.title);


        mSignIn.setOnClickListener(listener);




        return view;
    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            URL u = null;
            try {
                u = new URL("https://www.google.com");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            // new AuthenticateTask().execute(u);

            //   Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
            //  startActivity(intent);


            Log.i("email", "password"+ u.toString());
        }
    };

    public class AuthenticateTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {

            URL url = urls[0];

            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int responseCode = connection.getResponseCode();
                Log.i("response code","code "+responseCode);

                if(responseCode == HttpURLConnection.HTTP_OK){

                    String a = (String) connection.getResponseMessage();
                    return a;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return "error";
        }



        @Override
        protected void onPostExecute(String string) {
            //  super.onPostExecute(aBoolean);

            mText.setText(string);

        }
    }




}
