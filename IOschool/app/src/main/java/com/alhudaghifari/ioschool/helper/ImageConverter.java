package com.alhudaghifari.ioschool.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import com.alhudaghifari.ioschool.R;

/*adopted from http://ruibm.com/2009/06/16/rounded-corner-bitmaps-on-android/*/
public class ImageConverter {

    static Context context;

    /**
     * Untuk membuat gambar seperti bingkai foto
     * @param bitmap input bitmap
     * @param pixels berapa pixel
     * @return output bitmap roundedcircle
     */
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    /**
     * untuk membuat gambar menjadi bentuk circleimage
     * @param source sumber gambar (bimap)
     * @return gambar bitmap dalam bentuk circle
     */
    public static Bitmap getCircleImage(Bitmap source) {
        try {

            int size = Math.min(source.getWidth(), source.getHeight());

            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap
                    .createBitmap(source, x, y, size, size);
            if (squaredBitmap != source) {
                // source.recycle();
            }
            Bitmap bitmap = Bitmap.createBitmap(size, size,
                    squaredBitmap.getConfig());

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            BitmapShader shader = new BitmapShader(squaredBitmap,
                    BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setAntiAlias(true);

            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            // canvas.drawArc(rectf, -90, 360, false, lightRed);
            // squaredBitmap.recycle();
            return bitmap;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
    }
}