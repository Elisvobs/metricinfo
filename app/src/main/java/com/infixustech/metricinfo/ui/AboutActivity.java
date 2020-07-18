package com.infixustech.metricinfo.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.infixustech.metricinfo.R;

import java.util.List;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle(R.string.about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void chatIntent(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.chat_whatsapp:
                String contact = "263777175291";
                String url = "https://api.whatsapp.com/send?phone=" + contact;
//                String url = "https://wa.me/263777175291";

                Intent chatIntent = new Intent(Intent.ACTION_VIEW);
                chatIntent.setData(Uri.parse(url));
                startActivity(chatIntent);
                break;

            case R.id.chat_instagram:
                Uri uri = Uri.parse("https://instagram.com/_u/infixustech");
                Intent instaIntent = new Intent(Intent.ACTION_VIEW, uri);
                instaIntent.setPackage("com.instagram.android");
                try {
                    startActivity(instaIntent);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://instagram.com/_u/infixustech")));
                }
                break;

            case R.id.chat_facebook:
                Uri uri1 = Uri.parse("https://www.facebook.com/InfixusTech");
                Intent fbIntent = new Intent(Intent.ACTION_VIEW, uri1);
                fbIntent.setPackage("com.facebook.katana");
                try {
                    startActivity(fbIntent);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/InfixusTech")));
                }
                break;

            case R.id.chat_phone:
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:263718892833"));
                if (phoneIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(phoneIntent);
                }
                break;

            case R.id.chat_email:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                emailIntent.setType("vnd.android.cursor.item/email");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"admin@infixustech.co.zw"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email content");
//                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Send email using..."));
                break;
        }

    }

    public static void openFacebook(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/InfixusTech"));
        } catch (Exception e) {
            new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/InfixusTech"));
        }
    }

    private boolean isIntentAvailable(Context context, Intent instaIntent) {
        final PackageManager pm = context.getPackageManager();
        List<ResolveInfo> list = pm.queryIntentActivities(
                instaIntent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}