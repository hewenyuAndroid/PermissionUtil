# PermissionUtil
### Android中权限申请操作的工具类；

申请单个权限：

![single](https://github.com/hewenyuAndroid/PermissionUtil/blob/master/screen/applySingle.gif)

申请多个权限

![multi](https://github.com/hewenyuAndroid/PermissionUtil/blob/master/screen/applyMulti.gif)

### 引用方式

> compile 'com.hewenyu:Permission:1.0'

### 使用方式

1. 在对应的Activity/Fragment（包含v4）的 onRequestPermissionResult 方法中注册；
```Java
 @Override
public void onRequestPermissionsResult(int requestCode, 
                @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    PermissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
}

```

2. 在需要申请权限的地方调用
```Java
// 申请单个权限
PermissionHelper.requestPermission(this,
            // 需要申请的权限
            PermissionManifest.CALL_PHONE,
            new PermissionHelper.OnRequestPermissionListener() {
                @Override
                public void onPermissionGranted() {
                    // 申请权限成功
                    Toast.makeText(mContext, "申请单个权限成功", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPermissionDenied() {
                    // 申请失败，跳转到系统设置里面
                    PermissionHelper.showTipsDialog(mContext);
                }
            });
            
            
PermissionHelper.requestPermission(this,
            // 需要申请的权限组
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
```

