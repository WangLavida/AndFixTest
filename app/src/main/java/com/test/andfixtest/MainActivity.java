package com.test.andfixtest;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private String downloadUrl = "http://192.168.253.15:8080/fix.apatch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.test);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(MainActivity.this, FixActivity.class);
                startActivity(inten);

            }
        });
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Boolean aBoolean) {
                if (aBoolean) {
                    showDialog();
                } else {
                    Toast.makeText(MainActivity.this, "请打开权限", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    private void showDialog() {
        AlertDialog.Builder progressDialog = new AlertDialog.Builder(this);
        progressDialog.setMessage("是否更新");
        progressDialog.setNegativeButton("更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                download();
            }
        }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    private void download() {

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("正在下载");
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        OkGo.<File>get(downloadUrl).execute(new FileCallback() {
            @Override
            public void downloadProgress(Progress progress) {
                super.downloadProgress(progress);
                progressDialog.setProgress((int) progress.fraction * 100);
            }

            @Override
            public void onSuccess(Response<File> response) {
                Log.i("路径", response.body().getPath());
                Toast.makeText(MainActivity.this, "下载完成", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
                try {
                    MainApplication.patchManager.addPatch(response.body().getPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        progressDialog.show();
    }
}
