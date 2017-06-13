# 3rd_Camera

Refresh Image File

```java
MediaScannerConnection.scanFile(this,new String[] { photoFile.getAbsolutePath() }, null,new MediaScannerConnection.OnScanCompletedListener() {
    public void onScanCompleted(String path, Uri uri) {
        Log.i("ExternalStorage", "Scanned " + path + ":");
        Log.i("ExternalStorage", "-> uri=" + uri);
    }
});
```
