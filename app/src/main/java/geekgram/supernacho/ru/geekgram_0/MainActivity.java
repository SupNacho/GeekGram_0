package geekgram.supernacho.ru.geekgram_0;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_iss_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        button_iss_one = findViewById(R.id.raised_button);
        button_iss_one.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.raised_button:
                startDialog();
                break;
            default:
                Snackbar.make(button_iss_one, "No such button", Snackbar.LENGTH_SHORT).show();
        }
    }

    private void startDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("IMPORTATNT MESSAGE!")
                .setMessage("IT'S A LIFE IT'S A LIFE!!!")
                .setIcon(R.drawable.ic_chat_black_24dp)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.tool_bar_OK:
                Snackbar.make(button_iss_one, "Pressed OK", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.tool_bar_Close:
                Snackbar.make(button_iss_one, "Pressed Close", Snackbar.LENGTH_SHORT).show();
                break;
            default:
                Snackbar.make(button_iss_one, "No such item", Snackbar.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
