package com.adrienfenech.materialiconview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

public class MaterialIconView extends AppCompatImageView
{
    Context context;
    Bitmap originalBitmap = null;
    Bitmap canvasBitmap;
    Canvas canvas;
    int lastColor;
    int originalBitmapWidth = 0;
    int originalBitmapHeight = 0;

    final List<MaterialPropertyAnimator> animators = new ArrayList<>();

    public MaterialIconView(Context context) {
        super(context);
        init(context);
    }

    public MaterialIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MaterialIconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public MaterialIconView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        BitmapDrawable bitmapDrawable = ((BitmapDrawable)getDrawable());
        if (bitmapDrawable != null)
            setMaterialImageBitmap(bitmapDrawable.getBitmap());
    }


    /**
     * This method returns a MaterialPropertyAnimator object, which can be used to animate
     * specific properties on this View. Instead of {animate()}, you can call this method several
     * times in order to compute different animation.
     *
     * @return MaterialPropertyAnimator A new MaterialPropertyAnimator associated with this View.
     */
    public MaterialPropertyAnimator animateMaterial() {
        if (originalBitmap == null)
            throw new MaterialIconViewError("Bitmap null. Did you miss a call to setMaterialImageBitmap() ?");
        return new MaterialPropertyAnimator(this, false);
    }

    MaterialPropertyAnimator animateMaterial(MaterialPropertyAnimator animator) {
        if (originalBitmap == null)
            throw new MaterialIconViewError("Bitmap null. Did you miss a call to setMaterialImageBitmap() ?");
        return animator;
    }

    /**
     * Set a Bitmap Image to this view.
     * @param bitmap Image to set
     */
    public void setMaterialImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.originalBitmap = bitmap;
        originalBitmapWidth = bitmap.getWidth();
        originalBitmapHeight = bitmap.getHeight();

        resetMaterialImageBitmap();
    }

    /**
     * Reset the canvas (and the bitmap) as it was when {setMaterialImageBitmap} was called.
     */
    public void resetMaterialImageBitmap() {
        canvasBitmap = Bitmap.createBitmap(originalBitmapWidth, originalBitmapHeight, originalBitmap.getConfig());
        canvasBitmap.eraseColor(Color.parseColor("#00FFFFFF"));
        canvas = new Canvas(canvasBitmap);
        clearColorFilter();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(originalBitmap, null, new Rect(0, 0, originalBitmapWidth, originalBitmapHeight), paint);
    }

    public void cancelAllMaterialAnimation() {
        for (int i = animators.size() - 1; i >= 0; i--)
            animators.get(i).cancel();
    }

    void removeMaterialAnimator(MaterialPropertyAnimator animator) {
        animators.remove(animator);
    }

    public int getBitmapWidth() {
        return originalBitmapWidth;
    }

    public int getBitmapHeight() {
        return originalBitmapHeight;
    }

    class MaterialIconViewError extends Error {
        public MaterialIconViewError(String message) {
            super(message);
        }
    }
}

