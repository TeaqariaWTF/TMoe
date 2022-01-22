package cc.ioctl.tmoe.base;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import cc.ioctl.tmoe.rtti.Bidirectional;
import cc.ioctl.tmoe.rtti.ProxyFragmentRttiHandler;

public abstract class BaseProxyFragment {

    private Bundle mArgs;
    private boolean mIsPaused = true;
    private final ProxyFragmentRttiHandler mProxyRttiHandler;

    protected BaseProxyFragment() {
        this(null);
    }

    protected BaseProxyFragment(Bundle args) {
        mArgs = args;
        mProxyRttiHandler = new ProxyFragmentRttiHandler(this);
    }

    public ProxyFragmentRttiHandler getProxyRttiHandler() {
        return mProxyRttiHandler;
    }

    public Object getProxyObject() {
        return mProxyRttiHandler.getProxyInstance();
    }

    public abstract View onCreateView(Context context);

    public Bundle getArguments() {
        return mArgs;
    }

    public boolean isSwipeBackEnabled(MotionEvent event) {
        return true;
    }

    public void setInBubbleMode(boolean value) {
        mProxyRttiHandler.setInBubbleMode(value);
    }

    public boolean isInBubbleMode() {
        return mProxyRttiHandler.isInBubbleMode();
    }

    public boolean isInPreviewMode() {
        return mProxyRttiHandler.getInPreviewMode();
    }

    public boolean isInPassivePreviewMode() {
        return mProxyRttiHandler.getInPassivePreviewMode();
    }

    @Bidirectional
    public void setInPreviewMode(boolean value) {
        mProxyRttiHandler.setInPreviewModeSuper(value);
    }

    protected void setInMenuMode(boolean value) {
        mProxyRttiHandler.setInMenuMode(value);
    }

    public void onPreviewOpenAnimationEnd() {
    }

    public boolean hideKeyboardOnShow() {
        return true;
    }

    protected void clearViews() {
        mProxyRttiHandler.clearViews();
    }

    public void onRemoveFromParent() {
    }

    public void setParentFragment(Object fragment) {
        mProxyRttiHandler.setParentFragment(fragment);
    }

    protected void setParentLayout(ViewGroup layout) {
        mProxyRttiHandler.setParentLayout(layout);
    }

    @Bidirectional
    public ViewGroup createActionBar(Context context) {
        return mProxyRttiHandler.createActionBarSuper(context);
    }

    @Bidirectional
    public void finishFragment() {
        mProxyRttiHandler.finishFragmentSuper();
    }

    public void finishFragment(boolean animated) {
        mProxyRttiHandler.finishFragmentSuper(animated);
    }

    @Bidirectional
    public void removeSelfFromStack() {
        mProxyRttiHandler.removeSelfFromStackSuper();
    }

    protected boolean isFinishing() {
        return mProxyRttiHandler.isFinishing();
    }

    public boolean onFragmentCreate() {
        return true;
    }

    @Bidirectional
    public void onFragmentDestroy() {
        mProxyRttiHandler.onFragmentDestroySuper();
    }

    public boolean needDelayOpenAnimation() {
        return false;
    }

    public void resumeDelayedFragmentAnimation() {
        mProxyRttiHandler.resumeDelayedFragmentAnimation();
    }

    @Bidirectional
    public void onResume() {
        mProxyRttiHandler.onResumeSuper();
        mIsPaused = false;
    }

    @Bidirectional
    public void onPause() {
        mProxyRttiHandler.onPauseSuper();
        mIsPaused = true;
    }

    protected boolean isPaused() {
        return mIsPaused;
    }

    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
    }

    public boolean onBackPressed() {
        return true;
    }

    public void onActivityResultFragment(int requestCode, int resultCode, Intent data) {
    }

    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
    }

    public void saveSelfArgs(Bundle args) {
    }

    public void restoreSelfArgs(Bundle args) {
    }

    public boolean isLastFragment() {
        return mProxyRttiHandler.isLastFragment();
    }

    public Activity getParentActivity() {
        return mProxyRttiHandler.getParentActivity();
    }

    protected void setParentActivityTitle(CharSequence title) {
        Activity activity = getParentActivity();
        if (activity != null) {
            activity.setTitle(title);
        }
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        mProxyRttiHandler.startActivityForResult(intent, requestCode);
    }

    @Bidirectional
    public void dismissCurrentDialog() {
        mProxyRttiHandler.dismissCurrentDialogSuper();
    }

    public boolean dismissDialogOnPause(Dialog dialog) {
        return true;
    }

    public boolean canBeginSlide() {
        return true;
    }

    public void onTransitionAnimationProgress(boolean isOpen, float progress) {
    }

    public void onTransitionAnimationStart(boolean isOpen, boolean backward) {
    }

    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
    }

    @Bidirectional
    public void onBecomeFullyVisible() {
        mProxyRttiHandler.onBecomeFullyVisibleSuper();
    }

    public int getPreviewHeight() {
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }

    public void onBecomeFullyHidden() {
    }

    public AnimatorSet onCustomTransitionAnimation(boolean isOpen, final Runnable callback) {
        return null;
    }

    public void onDialogDismiss(Dialog dialog) {
    }
}