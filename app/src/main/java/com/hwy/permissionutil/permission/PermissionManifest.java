package com.hwy.permissionutil.permission;

import android.Manifest;

/**
 * 作者: hewenyu
 * 日期: 2018/9/20 15:26
 * 说明: 权限清单，可以根据项目来配置
 */
public class PermissionManifest {

    /**
     * 相机权限
     */
    public static final String CAMERA = Manifest.permission.CAMERA;

    /**
     * 读取外部存储权限
     */
    public static final String READ_EXTERNAL = Manifest.permission.READ_EXTERNAL_STORAGE;

    /**
     * 写入外部存储权限
     */
    public static final String WRITE_EXTERNAL = Manifest.permission.WRITE_EXTERNAL_STORAGE;

    /**
     * 电话权限
     */
    public static final String CALL_PHONE = Manifest.permission.CALL_PHONE;

}
