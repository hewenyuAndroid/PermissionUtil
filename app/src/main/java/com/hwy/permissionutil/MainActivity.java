package com.hwy.permissionutil;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hwy.permissionutil.permission.PermissionHelper;
import com.hwy.permissionutil.permission.PermissionManifest;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
    }

    /**
     * 申请单个权限
     *
     * @param view
     */
    public void applySingle(View view) {
        PermissionHelper.requestPermission(this,
                PermissionManifest.CALL_PHONE,
                new PermissionHelper.OnRequestPermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        Toast.makeText(mContext, "申请单个权限成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionDenied() {
                        PermissionHelper.showTipsDialog(mContext);
                    }
                });
    }

    /**
     * 申请多个权限
     *
     * @param view
     */
    public void applyMulti(View view) {
        PermissionHelper.requestPermission(this,
                new String[]{PermissionManifest.READ_EXTERNAL, PermissionManifest.CAMERA},
                new PermissionHelper.OnRequestPermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        Toast.makeText(mContext, "申请多个权限成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionDenied() {
                        PermissionHelper.showTipsDialog(mContext);
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
