package com.nostra13.universalimageloader.core.listener;

import android.widget.AbsListView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class PauseOnScrollListener implements AbsListView.OnScrollListener {
    private final AbsListView.OnScrollListener externalListener;
    private ImageLoader imageLoader;
    private final boolean pauseOnFling;
    private final boolean pauseOnScroll;

    public PauseOnScrollListener(ImageLoader imageLoader2, boolean pauseOnScroll2, boolean pauseOnFling2) {
        this(imageLoader2, pauseOnScroll2, pauseOnFling2, (AbsListView.OnScrollListener) null);
    }

    public PauseOnScrollListener(ImageLoader imageLoader2, boolean pauseOnScroll2, boolean pauseOnFling2, AbsListView.OnScrollListener customListener) {
        this.imageLoader = imageLoader2;
        this.pauseOnScroll = pauseOnScroll2;
        this.pauseOnFling = pauseOnFling2;
        this.externalListener = customListener;
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == 0) {
            this.imageLoader.resume();
        } else if (scrollState != 1) {
            if (scrollState == 2 && this.pauseOnFling) {
                this.imageLoader.pause();
            }
        } else if (this.pauseOnScroll) {
            this.imageLoader.pause();
        }
        AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(view, scrollState);
        }
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        AbsListView.OnScrollListener onScrollListener = this.externalListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }
}
