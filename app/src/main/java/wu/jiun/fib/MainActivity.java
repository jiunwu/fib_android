package wu.jiun.fib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] fibArray = new String[92];
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.listView);
        fibArray[0]="0";
        fibArray[1]="1";
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, fibArray);
        listView.setAdapter(adapter);

        fib(19);

    }

    public void fib(int n){
        //f(93) = -6246583658587674878 exceed MAX_LONG
        if (n < 1 || n > 92) {
            Log.e("error:","range of n is wrong");
        }

        long[] fib = new long[n+1];

        // base cases
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            //Log.i("fib:", Long.toString(fib[i])); test purpose
            fibArray[i] = Long.toString(fib[i]);
            listView.setAdapter(adapter);
        }
    }
}
