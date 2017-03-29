package org.brogrammer.Sample;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import org.brogrammer.materialiconview.DirectionOfTransition;
import org.brogrammer.materialiconview.MaterialAnimatorListenerAdapter;
import org.brogrammer.materialiconview.MaterialColor;
import org.brogrammer.materialiconview.MaterialIconView;
import org.brogrammer.materialiconview.TypeOfTransition;

import java.util.Random;

/**
 * Created by octo on 20/05/16.
 */
public class AnimationHelper {
    private final static Random rnd;

    static {
        rnd = new Random();
    }

    public static void launchHorizontalAnimation(final MaterialIconView mainView) {
        mainView.animateMaterial()
                .setTransition(TypeOfTransition.Line)
                .setDirection(DirectionOfTransition.LeftToRight)
                .toColor(MaterialHelper.getRandomMaterialColor())
                .setDuration(500 + rnd.nextInt(1000))

                .withPostAnimation()
                .setTransition(TypeOfTransition.Line)
                .setDirection(DirectionOfTransition.RightToLeft)
                .toColor(MaterialHelper.getRandomMaterialColor())
                .setDuration(500 + rnd.nextInt(1000))
                .setListener(new MaterialAnimatorListenerAdapter() {
                    /**
                     * <p>Notifies the end of the animation.</p>
                     *
                     * @param animation The animation which reached its end.
                     */
                    @Override
                    public void onAnimationEnd(ValueAnimator animation) {
                        super.onAnimationEnd(animation);
                        if (mainView.isClickable())
                            launchHorizontalAnimation(mainView);
                    }
                });
    }

    public static void launchVerticalAnimation(final MaterialIconView mainView) {
        mainView.animateMaterial()
                .setTransition(TypeOfTransition.Line)
                .setDirection(DirectionOfTransition.DownToUp)
                .toColor(MaterialHelper.getRandomMaterialColor(), MaterialHelper.getRandomMaterialColor())
                .setDuration(1500)

                .withPostAnimation()
                .setTransition(TypeOfTransition.Line)
                .setDirection(DirectionOfTransition.UpToDown)
                .toColor(MaterialHelper.getRandomMaterialColor(), MaterialHelper.getRandomMaterialColor())
                .setDuration(1500)
                .setListener(new MaterialAnimatorListenerAdapter() {
                    /**
                     * <p>Notifies the end of the animation.</p>
                     *
                     * @param animation The animation which reached its end.
                     */
                    @Override
                    public void onAnimationEnd(ValueAnimator animation) {
                        super.onAnimationEnd(animation);
                        if (mainView.isClickable())
                            launchVerticalAnimation(mainView);
                    }
                });
    }

    public static void launchCircleAnimation(final MaterialIconView mainView) {
        int color = MaterialHelper.getRandomMaterialColor();
        mainView.animateMaterial()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 100))
                .setDirection(DirectionOfTransition.UpRightToDownLeft)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 200))
                .setDirection(DirectionOfTransition.RightToLeft)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 300))
                .setDirection(DirectionOfTransition.DownRightToUpLeft)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 400))
                .setDirection(DirectionOfTransition.DownToUp)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 500))
                .setDirection(DirectionOfTransition.DownLeftToUpRight)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 600))
                .setDirection(DirectionOfTransition.LeftToRight)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 700))
                .setDirection(DirectionOfTransition.UpLeftToDownRight)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 800))
                .setDirection(DirectionOfTransition.UpToDown)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())
                .setListener(new MaterialAnimatorListenerAdapter() {
                    /**
                     * <p>Notifies the end of the animation.</p>
                     *
                     * @param animation The animation which reached its end.
                     */
                    @Override
                    public void onAnimationStart(ValueAnimator animation) {
                        super.onAnimationStart(animation);
                        if (mainView.isClickable())
                            launchCircleAnimation(mainView);
                    }
                });
    }

    public static void launchRectangleAnimation(final MaterialIconView mainView) {
        int color = MaterialHelper.getRandomMaterialColor();
        mainView.animateMaterial()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 100))
                .setTransition(TypeOfTransition.Rect)
                .setDirection(DirectionOfTransition.UpRightToDownLeft)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 200))
                .setTransition(TypeOfTransition.Rect)
                .setDirection(DirectionOfTransition.RightToLeft)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 300))
                .setTransition(TypeOfTransition.Rect)
                .setDirection(DirectionOfTransition.DownRightToUpLeft)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 400))
                .setTransition(TypeOfTransition.Rect)
                .setDirection(DirectionOfTransition.DownToUp)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 500))
                .setTransition(TypeOfTransition.Rect)
                .setDirection(DirectionOfTransition.DownLeftToUpRight)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 600))
                .setTransition(TypeOfTransition.Rect)
                .setDirection(DirectionOfTransition.LeftToRight)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 700))
                .setTransition(TypeOfTransition.Rect)
                .setDirection(DirectionOfTransition.UpLeftToDownRight)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 800))
                .setTransition(TypeOfTransition.Rect)
                .setDirection(DirectionOfTransition.UpToDown)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())
                .setListener(new MaterialAnimatorListenerAdapter() {
                    /**
                     * <p>Notifies the end of the animation.</p>
                     *
                     * @param animation The animation which reached its end.
                     */
                    @Override
                    public void onAnimationStart(ValueAnimator animation) {
                        super.onAnimationStart(animation);
                        if (mainView.isClickable())
                            launchRectangleAnimation(mainView);
                    }
                });

    }

    public static void launchLineAnimation(final MaterialIconView mainView) {
        int color = MaterialHelper.getRandomMaterialColor();
        mainView.animateMaterial()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 100))
                .setTransition(TypeOfTransition.Line)
                .setDirection(DirectionOfTransition.UpRightToDownLeft)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 200))
                .setTransition(TypeOfTransition.Line)
                .setDirection(DirectionOfTransition.RightToLeft)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 300))
                .setTransition(TypeOfTransition.Line)
                .setDirection(DirectionOfTransition.DownRightToUpLeft)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 400))
                .setTransition(TypeOfTransition.Line)
                .setDirection(DirectionOfTransition.DownToUp)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 500))
                .setTransition(TypeOfTransition.Line)
                .setDirection(DirectionOfTransition.DownLeftToUpRight)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 600))
                .setTransition(TypeOfTransition.Line)
                .setDirection(DirectionOfTransition.LeftToRight)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 700))
                .setTransition(TypeOfTransition.Line)
                .setDirection(DirectionOfTransition.UpLeftToDownRight)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())

                .withConcurrentAnimation()
                .toColor(MaterialColor.getMaterialColorByIndice(color, 800))
                .setTransition(TypeOfTransition.Line)
                .setDirection(DirectionOfTransition.UpToDown)
                .endingArea(0.55f)
                .setDuration(350)
                .setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator())
                .setListener(new MaterialAnimatorListenerAdapter() {
                    /**
                     * <p>Notifies the end of the animation.</p>
                     *
                     * @param animation The animation which reached its end.
                     */
                    @Override
                    public void onAnimationStart(ValueAnimator animation) {
                        super.onAnimationStart(animation);
                        if (mainView.isClickable())
                            launchLineAnimation(mainView);
                    }
                });
    }

    public static void launchAndroidAnimation(final MaterialIconView mainView) {
        if (rnd.nextInt(5) == 0)
            mainView.animateMaterial()
                    .setDuration(300 + rnd.nextInt(700))
                    .fromPoint(MaterialHelper.getRandomOrigin(mainView))
                    .setTransition(TypeOfTransition.Circle)
                    .setDirection(MaterialHelper.getRandomDirectOfTransition())
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .toColor(MaterialHelper.getRandomMaterialColor())
                    .endingArea(rnd.nextFloat())
                    .setListener(new MaterialAnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(ValueAnimator animation) {
                            super.onAnimationEnd(animation);
                            if (mainView.isClickable())
                                launchAndroidAnimation(mainView);
                        }
                    });
        else
            mainView.animateMaterial()
                    .setDuration(300 + rnd.nextInt(700))
                    .setTransition(MaterialHelper.getRandomTypeOfTransition())
                    .setDirection(MaterialHelper.getRandomDirectOfTransition())
                    .toColor(MaterialHelper.getRandomMaterialColor())
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .endingArea(rnd.nextFloat())
                    .setListener(new MaterialAnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(ValueAnimator animation) {
                            super.onAnimationEnd(animation);
                            if (mainView.isClickable())
                                launchAndroidAnimation(mainView);
                        }
                    });
    }

    public static void launchTouchAnimation(final MaterialIconView mainView) {
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    mainView.animateMaterial()
                            .setDuration(800)
                            .fromPoint(new Point((int)event.getX(), (int)event.getY()))
                            .setTransition(TypeOfTransition.Circle)
                            .setInterpolator(new AccelerateDecelerateInterpolator())
                            .toColor(MaterialHelper.getRandomMaterialColor(), MaterialHelper.getRandomMaterialColor())

                            .withConcurrentAnimation()
                            .setStartDelay(10 + rnd.nextInt(80))
                            .setDuration(800)
                            .fromPoint(new Point((int)event.getX(), (int)event.getY()))
                            .setTransition(TypeOfTransition.Circle)
                            .setInterpolator(new AccelerateDecelerateInterpolator())
                            .toColor(MaterialColor.White);
                    return true;
                }
                return false;
            }
        });
    }
}
