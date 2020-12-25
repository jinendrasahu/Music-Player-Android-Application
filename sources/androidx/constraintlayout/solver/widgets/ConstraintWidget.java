package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public VerticalWidgetRun verticalRun;
    public int[] wrapMeasure;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public WidgetRun getRun(int orientation) {
        if (orientation == 0) {
            return this.horizontalRun;
        }
        if (orientation == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public void setInVirtualLayout(boolean inVirtualLayout) {
        this.mInVirtuaLayout = inVirtualLayout;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int maxWidth) {
        this.mMaxDimension[0] = maxWidth;
    }

    public void setMaxHeight(int maxHeight) {
        this.mMaxDimension[1] = maxHeight;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void setHasBaseline(boolean hasBaseline2) {
        this.hasBaseline = hasBaseline2;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public void setInPlaceholder(boolean inPlaceholder2) {
        this.inPlaceholder = inPlaceholder2;
    }

    /* access modifiers changed from: protected */
    public void setInBarrier(int orientation, boolean value) {
        this.mIsInBarrier[orientation] = value;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int x, int y, int width, int height) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = x;
        this.mY = y;
        this.mWidth = width;
        this.mHeight = height;
        addAnchors();
    }

    public ConstraintWidget(int width, int height) {
        this(0, 0, width, height);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget widget) {
        this.mParent = widget;
    }

    public void setWidthWrapContent(boolean widthWrapContent) {
        this.mIsWidthWrapContent = widthWrapContent;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean heightWrapContent) {
        this.mIsHeightWrapContent = heightWrapContent;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget target, float angle, int radius) {
        immediateConnect(ConstraintAnchor.Type.CENTER, target, ConstraintAnchor.Type.CENTER, radius, 0);
        this.mCircleConstraintAngle = angle;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public void setVisibility(int visibility) {
        this.mVisibility = visibility;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String name) {
        this.mDebugName = name;
    }

    public void setDebugSolverName(LinearSystem system, String name) {
        this.mDebugName = name;
        SolverVariable left = system.createObjectVariable(this.mLeft);
        SolverVariable top = system.createObjectVariable(this.mTop);
        SolverVariable right = system.createObjectVariable(this.mRight);
        SolverVariable bottom = system.createObjectVariable(this.mBottom);
        left.setName(name + ".left");
        top.setName(name + ".top");
        right.setName(name + ".right");
        bottom.setName(name + ".bottom");
        if (this.mBaselineDistance > 0) {
            SolverVariable baseline = system.createObjectVariable(this.mBaseline);
            baseline.setName(name + ".baseline");
        }
    }

    public void createObjectVariables(LinearSystem system) {
        SolverVariable createObjectVariable = system.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = system.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = system.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = system.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            system.createObjectVariable(this.mBaseline);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(")");
        return sb.toString();
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mX;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mY;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int w;
        int w2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return w2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            w = Math.max(this.mMatchConstraintMinWidth, w2);
        } else if (this.mMatchConstraintMinWidth > 0) {
            w = this.mMatchConstraintMinWidth;
            this.mWidth = w;
        } else {
            w = 0;
        }
        int i = this.mMatchConstraintMaxWidth;
        if (i <= 0 || i >= w) {
            return w;
        }
        return this.mMatchConstraintMaxWidth;
    }

    public int getOptimizerWrapHeight() {
        int h;
        int h2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return h2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            h = Math.max(this.mMatchConstraintMinHeight, h2);
        } else if (this.mMatchConstraintMinHeight > 0) {
            h = this.mMatchConstraintMinHeight;
            this.mHeight = h;
        } else {
            h = 0;
        }
        int i = this.mMatchConstraintMaxHeight;
        if (i <= 0 || i >= h) {
            return h;
        }
        return this.mMatchConstraintMaxHeight;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getLength(int orientation) {
        if (orientation == 0) {
            return getWidth();
        }
        if (orientation == 1) {
            return getHeight();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public int getHorizontalMargin() {
        int margin = 0;
        ConstraintAnchor constraintAnchor = this.mLeft;
        if (constraintAnchor != null) {
            margin = 0 + constraintAnchor.mMargin;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        if (constraintAnchor2 != null) {
            return margin + constraintAnchor2.mMargin;
        }
        return margin;
    }

    public int getVerticalMargin() {
        int margin = 0;
        if (this.mLeft != null) {
            margin = 0 + this.mTop.mMargin;
        }
        if (this.mRight != null) {
            return margin + this.mBottom.mMargin;
        }
        return margin;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public float getBiasPercent(int orientation) {
        if (orientation == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (orientation == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int x) {
        this.mX = x;
    }

    public void setY(int y) {
        this.mY = y;
    }

    public void setOrigin(int x, int y) {
        this.mX = x;
        this.mY = y;
    }

    public void setOffset(int x, int y) {
        this.mOffsetX = x;
        this.mOffsetY = y;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int goneMargin) {
        int i = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i == 1) {
            this.mLeft.mGoneMargin = goneMargin;
        } else if (i == 2) {
            this.mTop.mGoneMargin = goneMargin;
        } else if (i == 3) {
            this.mRight.mGoneMargin = goneMargin;
        } else if (i == 4) {
            this.mBottom.mGoneMargin = goneMargin;
        }
    }

    public void setWidth(int w) {
        this.mWidth = w;
        int i = this.mWidth;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setHeight(int h) {
        this.mHeight = h;
        int i = this.mHeight;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setLength(int length, int orientation) {
        if (orientation == 0) {
            setWidth(length);
        } else if (orientation == 1) {
            setHeight(length);
        }
    }

    public void setHorizontalMatchStyle(int horizontalMatchStyle, int min, int max, float percent) {
        this.mMatchConstraintDefaultWidth = horizontalMatchStyle;
        this.mMatchConstraintMinWidth = min;
        this.mMatchConstraintMaxWidth = max == Integer.MAX_VALUE ? 0 : max;
        this.mMatchConstraintPercentWidth = percent;
        if (percent > 0.0f && percent < 1.0f && this.mMatchConstraintDefaultWidth == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int verticalMatchStyle, int min, int max, float percent) {
        this.mMatchConstraintDefaultHeight = verticalMatchStyle;
        this.mMatchConstraintMinHeight = min;
        this.mMatchConstraintMaxHeight = max == Integer.MAX_VALUE ? 0 : max;
        this.mMatchConstraintPercentHeight = percent;
        if (percent > 0.0f && percent < 1.0f && this.mMatchConstraintDefaultHeight == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setDimensionRatio(String ratio) {
        int commaIndex;
        if (ratio == null || ratio.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int dimensionRatioSide = -1;
        float dimensionRatio = 0.0f;
        int len = ratio.length();
        int commaIndex2 = ratio.indexOf(44);
        if (commaIndex2 <= 0 || commaIndex2 >= len - 1) {
            commaIndex = 0;
        } else {
            String dimension = ratio.substring(0, commaIndex2);
            if (dimension.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                dimensionRatioSide = 0;
            } else if (dimension.equalsIgnoreCase("H")) {
                dimensionRatioSide = 1;
            }
            commaIndex = commaIndex2 + 1;
        }
        int colonIndex = ratio.indexOf(58);
        if (colonIndex < 0 || colonIndex >= len - 1) {
            String r = ratio.substring(commaIndex);
            if (r.length() > 0) {
                try {
                    dimensionRatio = Float.parseFloat(r);
                } catch (NumberFormatException e) {
                }
            }
        } else {
            String nominator = ratio.substring(commaIndex, colonIndex);
            String denominator = ratio.substring(colonIndex + 1);
            if (nominator.length() > 0 && denominator.length() > 0) {
                try {
                    float nominatorValue = Float.parseFloat(nominator);
                    float denominatorValue = Float.parseFloat(denominator);
                    if (nominatorValue > 0.0f && denominatorValue > 0.0f) {
                        dimensionRatio = dimensionRatioSide == 1 ? Math.abs(denominatorValue / nominatorValue) : Math.abs(nominatorValue / denominatorValue);
                    }
                } catch (NumberFormatException e2) {
                }
            }
        }
        if (dimensionRatio > 0.0f) {
            this.mDimensionRatio = dimensionRatio;
            this.mDimensionRatioSide = dimensionRatioSide;
        }
    }

    public void setDimensionRatio(float ratio, int dimensionRatioSide) {
        this.mDimensionRatio = ratio;
        this.mDimensionRatioSide = dimensionRatioSide;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float horizontalBiasPercent) {
        this.mHorizontalBiasPercent = horizontalBiasPercent;
    }

    public void setVerticalBiasPercent(float verticalBiasPercent) {
        this.mVerticalBiasPercent = verticalBiasPercent;
    }

    public void setMinWidth(int w) {
        if (w < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = w;
        }
    }

    public void setMinHeight(int h) {
        if (h < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = h;
        }
    }

    public void setDimension(int w, int h) {
        this.mWidth = w;
        int i = this.mWidth;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
        this.mHeight = h;
        int i3 = this.mHeight;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    public void setFrame(int left, int top, int right, int bottom) {
        int w = right - left;
        int h = bottom - top;
        this.mX = left;
        this.mY = top;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && w < this.mWidth) {
            w = this.mWidth;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && h < this.mHeight) {
            h = this.mHeight;
        }
        this.mWidth = w;
        this.mHeight = h;
        int i = this.mHeight;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
        int i3 = this.mWidth;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setFrame(int start, int end, int orientation) {
        if (orientation == 0) {
            setHorizontalDimension(start, end);
        } else if (orientation == 1) {
            setVerticalDimension(start, end);
        }
    }

    public void setHorizontalDimension(int left, int right) {
        this.mX = left;
        this.mWidth = right - left;
        int i = this.mWidth;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setVerticalDimension(int top, int bottom) {
        this.mY = top;
        this.mHeight = bottom - top;
        int i = this.mHeight;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int orientation) {
        if (orientation == 0) {
            return this.mRelX;
        }
        if (orientation == 1) {
            return this.mRelY;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int offset, int orientation) {
        if (orientation == 0) {
            this.mRelX = offset;
        } else if (orientation == 1) {
            this.mRelY = offset;
        }
    }

    public void setBaselineDistance(int baseline) {
        this.mBaselineDistance = baseline;
        this.hasBaseline = baseline > 0;
    }

    public void setCompanionWidget(Object companion) {
        this.mCompanionWidget = companion;
    }

    public void setContainerItemSkip(int skip) {
        if (skip >= 0) {
            this.mContainerItemSkip = skip;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float horizontalWeight) {
        this.mWeight[0] = horizontalWeight;
    }

    public void setVerticalWeight(float verticalWeight) {
        this.mWeight[1] = verticalWeight;
    }

    public void setHorizontalChainStyle(int horizontalChainStyle) {
        this.mHorizontalChainStyle = horizontalChainStyle;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int verticalChainStyle) {
        this.mVerticalChainStyle = verticalChainStyle;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void immediateConnect(ConstraintAnchor.Type startType, ConstraintWidget target, ConstraintAnchor.Type endType, int margin, int goneMargin) {
        getAnchor(startType).connect(target.getAnchor(endType), margin, goneMargin, true);
    }

    public void connect(ConstraintAnchor from, ConstraintAnchor to, int margin) {
        if (from.getOwner() == this) {
            connect(from.getType(), to.getOwner(), to.getType(), margin);
        }
    }

    public void connect(ConstraintAnchor.Type constraintFrom, ConstraintWidget target, ConstraintAnchor.Type constraintTo) {
        connect(constraintFrom, target, constraintTo, 0);
    }

    public void connect(ConstraintAnchor.Type constraintFrom, ConstraintWidget target, ConstraintAnchor.Type constraintTo, int margin) {
        if (constraintFrom == ConstraintAnchor.Type.CENTER) {
            if (constraintTo == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor left = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor right = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor top = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor bottom = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean centerX = false;
                boolean centerY = false;
                if ((left == null || !left.isConnected()) && (right == null || !right.isConnected())) {
                    connect(ConstraintAnchor.Type.LEFT, target, ConstraintAnchor.Type.LEFT, 0);
                    connect(ConstraintAnchor.Type.RIGHT, target, ConstraintAnchor.Type.RIGHT, 0);
                    centerX = true;
                }
                if ((top == null || !top.isConnected()) && (bottom == null || !bottom.isConnected())) {
                    connect(ConstraintAnchor.Type.TOP, target, ConstraintAnchor.Type.TOP, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, target, ConstraintAnchor.Type.BOTTOM, 0);
                    centerY = true;
                }
                if (centerX && centerY) {
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(target.getAnchor(ConstraintAnchor.Type.CENTER), 0);
                } else if (centerX) {
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(target.getAnchor(ConstraintAnchor.Type.CENTER_X), 0);
                } else if (centerY) {
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(target.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0);
                }
            } else if (constraintTo == ConstraintAnchor.Type.LEFT || constraintTo == ConstraintAnchor.Type.RIGHT) {
                connect(ConstraintAnchor.Type.LEFT, target, constraintTo, 0);
                connect(ConstraintAnchor.Type.RIGHT, target, constraintTo, 0);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(target.getAnchor(constraintTo), 0);
            } else if (constraintTo == ConstraintAnchor.Type.TOP || constraintTo == ConstraintAnchor.Type.BOTTOM) {
                connect(ConstraintAnchor.Type.TOP, target, constraintTo, 0);
                connect(ConstraintAnchor.Type.BOTTOM, target, constraintTo, 0);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(target.getAnchor(constraintTo), 0);
            }
        } else if (constraintFrom == ConstraintAnchor.Type.CENTER_X && (constraintTo == ConstraintAnchor.Type.LEFT || constraintTo == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor left2 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor targetAnchor = target.getAnchor(constraintTo);
            ConstraintAnchor right2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            left2.connect(targetAnchor, 0);
            right2.connect(targetAnchor, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(targetAnchor, 0);
        } else if (constraintFrom == ConstraintAnchor.Type.CENTER_Y && (constraintTo == ConstraintAnchor.Type.TOP || constraintTo == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor targetAnchor2 = target.getAnchor(constraintTo);
            getAnchor(ConstraintAnchor.Type.TOP).connect(targetAnchor2, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(targetAnchor2, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(targetAnchor2, 0);
        } else if (constraintFrom == ConstraintAnchor.Type.CENTER_X && constraintTo == ConstraintAnchor.Type.CENTER_X) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), 0);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(target.getAnchor(constraintTo), 0);
        } else if (constraintFrom == ConstraintAnchor.Type.CENTER_Y && constraintTo == ConstraintAnchor.Type.CENTER_Y) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(target.getAnchor(ConstraintAnchor.Type.TOP), 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(target.getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(target.getAnchor(constraintTo), 0);
        } else {
            ConstraintAnchor fromAnchor = getAnchor(constraintFrom);
            ConstraintAnchor toAnchor = target.getAnchor(constraintTo);
            if (fromAnchor.isValidConnection(toAnchor)) {
                if (constraintFrom == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor top2 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor bottom2 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    if (top2 != null) {
                        top2.reset();
                    }
                    if (bottom2 != null) {
                        bottom2.reset();
                    }
                    margin = 0;
                } else if (constraintFrom == ConstraintAnchor.Type.TOP || constraintFrom == ConstraintAnchor.Type.BOTTOM) {
                    ConstraintAnchor baseline = getAnchor(ConstraintAnchor.Type.BASELINE);
                    if (baseline != null) {
                        baseline.reset();
                    }
                    ConstraintAnchor center = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (center.getTarget() != toAnchor) {
                        center.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(constraintFrom).getOpposite();
                    ConstraintAnchor centerY2 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                    if (centerY2.isConnected()) {
                        opposite.reset();
                        centerY2.reset();
                    }
                } else if (constraintFrom == ConstraintAnchor.Type.LEFT || constraintFrom == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor center2 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (center2.getTarget() != toAnchor) {
                        center2.reset();
                    }
                    ConstraintAnchor opposite2 = getAnchor(constraintFrom).getOpposite();
                    ConstraintAnchor centerX2 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                    if (centerX2.isConnected()) {
                        opposite2.reset();
                        centerX2.reset();
                    }
                }
                fromAnchor.connect(toAnchor, margin);
            }
        }
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor anchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor left = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor right = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor top = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor bottom = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor center = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor centerX = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor centerY = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (anchor == center) {
                if (left.isConnected() && right.isConnected() && left.getTarget() == right.getTarget()) {
                    left.reset();
                    right.reset();
                }
                if (top.isConnected() && bottom.isConnected() && top.getTarget() == bottom.getTarget()) {
                    top.reset();
                    bottom.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (anchor == centerX) {
                if (left.isConnected() && right.isConnected() && left.getTarget().getOwner() == right.getTarget().getOwner()) {
                    left.reset();
                    right.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (anchor == centerY) {
                if (top.isConnected() && bottom.isConnected() && top.getTarget().getOwner() == bottom.getTarget().getOwner()) {
                    top.reset();
                    bottom.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (anchor == left || anchor == right) {
                if (left.isConnected() && left.getTarget() == right.getTarget()) {
                    center.reset();
                }
            } else if ((anchor == top || anchor == bottom) && top.isConnected() && top.getTarget() == bottom.getTarget()) {
                center.reset();
            }
            anchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int mAnchorsSize = this.mAnchors.size();
            for (int i = 0; i < mAnchorsSize; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type anchorType) {
        switch (anchorType) {
            case LEFT:
                return this.mLeft;
            case TOP:
                return this.mTop;
            case RIGHT:
                return this.mRight;
            case BOTTOM:
                return this.mBottom;
            case BASELINE:
                return this.mBaseline;
            case CENTER:
                return this.mCenter;
            case CENTER_X:
                return this.mCenterX;
            case CENTER_Y:
                return this.mCenterY;
            case NONE:
                return null;
            default:
                throw new AssertionError(anchorType.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public DimensionBehaviour getDimensionBehaviour(int orientation) {
        if (orientation == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (orientation == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour behaviour) {
        this.mListDimensionBehaviors[0] = behaviour;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour behaviour) {
        this.mListDimensionBehaviors[1] = behaviour;
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget != null && this.mLeft.mTarget.mTarget == this.mLeft) {
            return true;
        }
        if (this.mRight.mTarget == null || this.mRight.mTarget.mTarget != this.mRight) {
            return false;
        }
        return true;
    }

    public ConstraintWidget getPreviousChainMember(int orientation) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (orientation == 0) {
            if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != (constraintAnchor2 = this.mLeft)) {
                return null;
            }
            return constraintAnchor2.mTarget.mOwner;
        } else if (orientation == 1 && this.mTop.mTarget != null && this.mTop.mTarget.mTarget == (constraintAnchor = this.mTop)) {
            return constraintAnchor.mTarget.mOwner;
        } else {
            return null;
        }
    }

    public ConstraintWidget getNextChainMember(int orientation) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (orientation == 0) {
            if (this.mRight.mTarget == null || this.mRight.mTarget.mTarget != (constraintAnchor2 = this.mRight)) {
                return null;
            }
            return constraintAnchor2.mTarget.mOwner;
        } else if (orientation == 1 && this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == (constraintAnchor = this.mBottom)) {
            return constraintAnchor.mTarget.mOwner;
        } else {
            return null;
        }
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintWidget found = null;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget tmp = this;
        while (found == null && tmp != null) {
            ConstraintAnchor anchor = tmp.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor targetAnchor = null;
            ConstraintAnchor targetOwner = anchor == null ? null : anchor.getTarget();
            ConstraintWidget target = targetOwner == null ? null : targetOwner.getOwner();
            if (target == getParent()) {
                return tmp;
            }
            if (target != null) {
                targetAnchor = target.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (targetAnchor == null || targetAnchor.getOwner() == tmp) {
                tmp = target;
            } else {
                found = tmp;
            }
        }
        return found;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget != null && this.mTop.mTarget.mTarget == this.mTop) {
            return true;
        }
        if (this.mBottom.mTarget == null || this.mBottom.mTarget.mTarget != this.mBottom) {
            return false;
        }
        return true;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintWidget found = null;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget tmp = this;
        while (found == null && tmp != null) {
            ConstraintAnchor anchor = tmp.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor targetAnchor = null;
            ConstraintAnchor targetOwner = anchor == null ? null : anchor.getTarget();
            ConstraintWidget target = targetOwner == null ? null : targetOwner.getOwner();
            if (target == getParent()) {
                return tmp;
            }
            if (target != null) {
                targetAnchor = target.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (targetAnchor == null || targetAnchor.getOwner() == tmp) {
                tmp = target;
            } else {
                found = tmp;
            }
        }
        return found;
    }

    private boolean isChainHead(int orientation) {
        int offset = orientation * 2;
        if (this.mListAnchors[offset].mTarget != null) {
            ConstraintAnchor constraintAnchor = this.mListAnchors[offset].mTarget.mTarget;
            ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
            return (constraintAnchor == constraintAnchorArr[offset] || constraintAnchorArr[offset + 1].mTarget == null || this.mListAnchors[offset + 1].mTarget.mTarget != this.mListAnchors[offset + 1]) ? false : true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: int} */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x028b, code lost:
        if (r0 == -1) goto L_0x028f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0401  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x044e  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x045f  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0462  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0465  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x052f  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x055a  */
    /* JADX WARNING: Removed duplicated region for block: B:263:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem r63) {
        /*
            r62 = this;
            r13 = r62
            r9 = r63
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mLeft
            androidx.constraintlayout.solver.SolverVariable r4 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mRight
            androidx.constraintlayout.solver.SolverVariable r3 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mTop
            androidx.constraintlayout.solver.SolverVariable r1 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mBottom
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r13.mBaseline
            androidx.constraintlayout.solver.SolverVariable r15 = r9.createObjectVariable(r2)
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            r5 = 1
            if (r2 == 0) goto L_0x002f
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r7 = r2.widgets
            long r7 = r7 + r5
            r2.widgets = r7
        L_0x002f:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r2 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.start
            boolean r2 = r2.resolved
            r14 = 8
            r12 = 1
            r11 = 0
            if (r2 == 0) goto L_0x00de
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r2 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            boolean r2 = r2.resolved
            if (r2 == 0) goto L_0x00de
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.start
            boolean r2 = r2.resolved
            if (r2 == 0) goto L_0x00de
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            boolean r2 = r2.resolved
            if (r2 == 0) goto L_0x00de
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r2 == 0) goto L_0x005e
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r7 = r2.graphSolved
            long r7 = r7 + r5
            r2.graphSolved = r7
        L_0x005e:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r2 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.start
            int r2 = r2.value
            r9.addEquality(r4, r2)
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r2 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.value
            r9.addEquality(r3, r2)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.start
            int r2 = r2.value
            r9.addEquality(r1, r2)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.value
            r9.addEquality(r0, r2)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.baseline
            int r2 = r2.value
            r9.addEquality(r15, r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r13.mParent
            if (r2 == 0) goto L_0x00dd
            if (r2 == 0) goto L_0x009b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r2.mListDimensionBehaviors
            r2 = r2[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r5) goto L_0x009b
            r2 = r12
            goto L_0x009c
        L_0x009b:
            r2 = r11
        L_0x009c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r13.mParent
            if (r5 == 0) goto L_0x00aa
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r5.mListDimensionBehaviors
            r5 = r5[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r6) goto L_0x00aa
            r5 = r12
            goto L_0x00ab
        L_0x00aa:
            r5 = r11
        L_0x00ab:
            if (r2 == 0) goto L_0x00c4
            boolean[] r6 = r13.isTerminalWidget
            boolean r6 = r6[r11]
            if (r6 == 0) goto L_0x00c4
            boolean r6 = r62.isInHorizontalChain()
            if (r6 != 0) goto L_0x00c4
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mRight
            androidx.constraintlayout.solver.SolverVariable r6 = r9.createObjectVariable(r6)
            r9.addGreaterThan(r6, r3, r11, r14)
        L_0x00c4:
            if (r5 == 0) goto L_0x00dd
            boolean[] r6 = r13.isTerminalWidget
            boolean r6 = r6[r12]
            if (r6 == 0) goto L_0x00dd
            boolean r6 = r62.isInVerticalChain()
            if (r6 != 0) goto L_0x00dd
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mBottom
            androidx.constraintlayout.solver.SolverVariable r6 = r9.createObjectVariable(r6)
            r9.addGreaterThan(r6, r0, r11, r14)
        L_0x00dd:
            return
        L_0x00de:
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r2 == 0) goto L_0x00e9
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r7 = r2.linearSolved
            long r7 = r7 + r5
            r2.linearSolved = r7
        L_0x00e9:
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            if (r8 == 0) goto L_0x017e
            if (r8 == 0) goto L_0x00fd
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r8.mListDimensionBehaviors
            r8 = r8[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 != r10) goto L_0x00fd
            r8 = r12
            goto L_0x00fe
        L_0x00fd:
            r8 = r11
        L_0x00fe:
            r6 = r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            if (r8 == 0) goto L_0x010d
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r8.mListDimensionBehaviors
            r8 = r8[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 != r10) goto L_0x010d
            r8 = r12
            goto L_0x010e
        L_0x010d:
            r8 = r11
        L_0x010e:
            r7 = r8
            boolean r8 = r13.isChainHead(r11)
            if (r8 == 0) goto L_0x011e
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r8
            r8.addChain(r13, r11)
            r2 = 1
            goto L_0x0122
        L_0x011e:
            boolean r2 = r62.isInHorizontalChain()
        L_0x0122:
            boolean r8 = r13.isChainHead(r12)
            if (r8 == 0) goto L_0x0131
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r8
            r8.addChain(r13, r12)
            r5 = 1
            goto L_0x0135
        L_0x0131:
            boolean r5 = r62.isInVerticalChain()
        L_0x0135:
            if (r2 != 0) goto L_0x0154
            if (r6 == 0) goto L_0x0154
            int r8 = r13.mVisibility
            if (r8 == r14) goto L_0x0154
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x0154
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x0154
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mRight
            androidx.constraintlayout.solver.SolverVariable r8 = r9.createObjectVariable(r8)
            r9.addGreaterThan(r8, r3, r11, r12)
        L_0x0154:
            if (r5 != 0) goto L_0x0177
            if (r7 == 0) goto L_0x0177
            int r8 = r13.mVisibility
            if (r8 == r14) goto L_0x0177
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x0177
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x0177
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mBaseline
            if (r8 != 0) goto L_0x0177
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mBottom
            androidx.constraintlayout.solver.SolverVariable r8 = r9.createObjectVariable(r8)
            r9.addGreaterThan(r8, r0, r11, r12)
        L_0x0177:
            r45 = r2
            r46 = r5
            r10 = r6
            r8 = r7
            goto L_0x0184
        L_0x017e:
            r45 = r2
            r46 = r5
            r10 = r6
            r8 = r7
        L_0x0184:
            int r2 = r13.mWidth
            int r5 = r13.mMinWidth
            if (r2 >= r5) goto L_0x018c
            int r2 = r13.mMinWidth
        L_0x018c:
            int r5 = r13.mHeight
            int r6 = r13.mMinHeight
            if (r5 >= r6) goto L_0x0194
            int r5 = r13.mMinHeight
        L_0x0194:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r13.mListDimensionBehaviors
            r6 = r6[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 == r7) goto L_0x019e
            r6 = r12
            goto L_0x019f
        L_0x019e:
            r6 = r11
        L_0x019f:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r13.mListDimensionBehaviors
            r7 = r7[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 == r12) goto L_0x01a9
            r7 = 1
            goto L_0x01aa
        L_0x01a9:
            r7 = r11
        L_0x01aa:
            r12 = r7
            r7 = 0
            int r11 = r13.mDimensionRatioSide
            r13.mResolvedDimensionRatioSide = r11
            float r11 = r13.mDimensionRatio
            r13.mResolvedDimensionRatio = r11
            int r14 = r13.mMatchConstraintDefaultWidth
            r20 = r0
            int r0 = r13.mMatchConstraintDefaultHeight
            r17 = 0
            int r11 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            r17 = r2
            if (r11 <= 0) goto L_0x026f
            int r11 = r13.mVisibility
            r2 = 8
            if (r11 == r2) goto L_0x026f
            r7 = 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r11 = 0
            r2 = r2[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r11) goto L_0x01d5
            if (r14 != 0) goto L_0x01d5
            r14 = 3
        L_0x01d5:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r11 = 1
            r2 = r2[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r11) goto L_0x01e1
            if (r0 != 0) goto L_0x01e1
            r0 = 3
        L_0x01e1:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r11 = 0
            r2 = r2[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r22 = r1
            r1 = 3
            if (r2 != r11) goto L_0x01ff
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r11 = 1
            r2 = r2[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r11) goto L_0x01ff
            if (r14 != r1) goto L_0x01ff
            if (r0 != r1) goto L_0x01ff
            r13.setupDimensionRatio(r10, r8, r6, r12)
            goto L_0x0271
        L_0x01ff:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r11 = 0
            r2 = r2[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r11) goto L_0x022f
            if (r14 != r1) goto L_0x022f
            r1 = 0
            r13.mResolvedDimensionRatioSide = r1
            float r1 = r13.mResolvedDimensionRatio
            int r2 = r13.mHeight
            float r2 = (float) r2
            float r1 = r1 * r2
            int r2 = (int) r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r13.mListDimensionBehaviors
            r11 = 1
            r1 = r1[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 == r11) goto L_0x0227
            r1 = 4
            r7 = 0
            r48 = r0
            r47 = r1
            r27 = r5
            r1 = r7
            goto L_0x027a
        L_0x0227:
            r48 = r0
            r27 = r5
            r1 = r7
            r47 = r14
            goto L_0x027a
        L_0x022f:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.mListDimensionBehaviors
            r11 = 1
            r2 = r2[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r11) goto L_0x0271
            if (r0 != r1) goto L_0x0271
            r1 = 1
            r13.mResolvedDimensionRatioSide = r1
            int r1 = r13.mDimensionRatioSide
            r2 = -1
            if (r1 != r2) goto L_0x0249
            r1 = 1065353216(0x3f800000, float:1.0)
            float r2 = r13.mResolvedDimensionRatio
            float r1 = r1 / r2
            r13.mResolvedDimensionRatio = r1
        L_0x0249:
            float r1 = r13.mResolvedDimensionRatio
            int r2 = r13.mWidth
            float r2 = (float) r2
            float r1 = r1 * r2
            int r5 = (int) r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r13.mListDimensionBehaviors
            r2 = 0
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 == r2) goto L_0x0265
            r0 = 4
            r7 = 0
            r48 = r0
            r27 = r5
            r1 = r7
            r47 = r14
            r2 = r17
            goto L_0x027a
        L_0x0265:
            r48 = r0
            r27 = r5
            r1 = r7
            r47 = r14
            r2 = r17
            goto L_0x027a
        L_0x026f:
            r22 = r1
        L_0x0271:
            r48 = r0
            r27 = r5
            r1 = r7
            r47 = r14
            r2 = r17
        L_0x027a:
            int[] r0 = r13.mResolvedMatchConstraintDefault
            r5 = 0
            r0[r5] = r47
            r5 = 1
            r0[r5] = r48
            r13.mResolvedHasRatio = r1
            if (r1 == 0) goto L_0x0292
            int r0 = r13.mResolvedDimensionRatioSide
            if (r0 == 0) goto L_0x028e
            r5 = -1
            if (r0 != r5) goto L_0x0293
            goto L_0x028f
        L_0x028e:
            r5 = -1
        L_0x028f:
            r17 = 1
            goto L_0x0295
        L_0x0292:
            r5 = -1
        L_0x0293:
            r17 = 0
        L_0x0295:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r13.mListDimensionBehaviors
            r7 = 0
            r0 = r0[r7]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r7) goto L_0x02a4
            boolean r0 = r13 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x02a4
            r0 = 1
            goto L_0x02a5
        L_0x02a4:
            r0 = 0
        L_0x02a5:
            r28 = r0
            if (r28 == 0) goto L_0x02ad
            r0 = 0
            r49 = r0
            goto L_0x02af
        L_0x02ad:
            r49 = r2
        L_0x02af:
            r0 = 1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r13.mCenter
            boolean r2 = r2.isConnected()
            if (r2 == 0) goto L_0x02bc
            r0 = 0
            r29 = r0
            goto L_0x02be
        L_0x02bc:
            r29 = r0
        L_0x02be:
            boolean[] r0 = r13.mIsInBarrier
            r2 = 0
            boolean r50 = r0[r2]
            r14 = 1
            boolean r51 = r0[r14]
            int r0 = r13.mHorizontalResolution
            r11 = 2
            r30 = 0
            if (r0 == r11) goto L_0x03da
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r0 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.start
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x0359
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r0 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x02e1
            r7 = 8
            goto L_0x035b
        L_0x02e1:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r0 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.start
            int r0 = r0.value
            r9.addEquality(r4, r0)
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r0 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r9.addEquality(r3, r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x0341
            if (r10 == 0) goto L_0x0329
            boolean[] r0 = r13.isTerminalWidget
            r2 = 0
            boolean r0 = r0[r2]
            if (r0 == 0) goto L_0x0329
            boolean r0 = r62.isInHorizontalChain()
            if (r0 != 0) goto L_0x0329
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            r7 = 8
            r9.addGreaterThan(r0, r3, r2, r7)
            r59 = r1
            r60 = r3
            r61 = r4
            r52 = r6
            r53 = r8
            r54 = r10
            r55 = r12
            r56 = r15
            r57 = r20
            r58 = r22
            goto L_0x03ee
        L_0x0329:
            r7 = 8
            r59 = r1
            r60 = r3
            r61 = r4
            r52 = r6
            r53 = r8
            r54 = r10
            r55 = r12
            r56 = r15
            r57 = r20
            r58 = r22
            goto L_0x03ee
        L_0x0341:
            r7 = 8
            r59 = r1
            r60 = r3
            r61 = r4
            r52 = r6
            r53 = r8
            r54 = r10
            r55 = r12
            r56 = r15
            r57 = r20
            r58 = r22
            goto L_0x03ee
        L_0x0359:
            r7 = 8
        L_0x035b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x0366
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            goto L_0x0368
        L_0x0366:
            r0 = r30
        L_0x0368:
            r16 = r7
            r7 = r0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x0376
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mLeft
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            goto L_0x0378
        L_0x0376:
            r0 = r30
        L_0x0378:
            r52 = r6
            r6 = r0
            r2 = 1
            r0 = r5
            boolean[] r5 = r13.isTerminalWidget
            r18 = 0
            boolean r5 = r5[r18]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r13.mListDimensionBehaviors
            r0 = r0[r18]
            r53 = r8
            r8 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mLeft
            r54 = r10
            r10 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mRight
            r2 = r18
            r11 = r0
            int r0 = r13.mX
            r55 = r12
            r12 = r0
            int r0 = r13.mMinWidth
            r14 = r0
            int[] r0 = r13.mMaxDimension
            r0 = r0[r2]
            r56 = r15
            r15 = r0
            float r0 = r13.mHorizontalBiasPercent
            r16 = r0
            int r0 = r13.mMatchConstraintMinWidth
            r23 = r0
            int r0 = r13.mMatchConstraintMaxWidth
            r24 = r0
            float r0 = r13.mMatchConstraintPercentWidth
            r25 = r0
            r57 = r20
            r0 = r62
            r59 = r1
            r58 = r22
            r1 = r63
            r60 = r3
            r3 = r54
            r61 = r4
            r4 = r53
            r9 = r28
            r13 = r49
            r18 = r45
            r19 = r46
            r20 = r50
            r21 = r47
            r22 = r48
            r26 = r29
            r2 = 1
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x03ee
        L_0x03da:
            r59 = r1
            r60 = r3
            r61 = r4
            r52 = r6
            r53 = r8
            r54 = r10
            r55 = r12
            r56 = r15
            r57 = r20
            r58 = r22
        L_0x03ee:
            r0 = 1
            r7 = r62
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r7.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.start
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x044e
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r7.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x044e
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r7.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.start
            int r1 = r1.value
            r8 = r63
            r9 = r58
            r8.addEquality(r9, r1)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r7.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.value
            r10 = r57
            r8.addEquality(r10, r1)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r7.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.baseline
            int r1 = r1.value
            r11 = r56
            r8.addEquality(r11, r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r7.mParent
            if (r1 == 0) goto L_0x0448
            if (r46 != 0) goto L_0x0443
            if (r53 == 0) goto L_0x0443
            boolean[] r2 = r7.isTerminalWidget
            r3 = 1
            boolean r2 = r2[r3]
            if (r2 == 0) goto L_0x0440
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mBottom
            androidx.constraintlayout.solver.SolverVariable r1 = r8.createObjectVariable(r1)
            r2 = 8
            r4 = 0
            r8.addGreaterThan(r1, r10, r4, r2)
            goto L_0x044c
        L_0x0440:
            r2 = 8
            goto L_0x0446
        L_0x0443:
            r2 = 8
            r3 = 1
        L_0x0446:
            r4 = 0
            goto L_0x044c
        L_0x0448:
            r2 = 8
            r3 = 1
            r4 = 0
        L_0x044c:
            r0 = 0
            goto L_0x045a
        L_0x044e:
            r8 = r63
            r11 = r56
            r10 = r57
            r9 = r58
            r2 = 8
            r3 = 1
            r4 = 0
        L_0x045a:
            int r1 = r7.mVerticalResolution
            r5 = 2
            if (r1 != r5) goto L_0x0462
            r0 = 0
            r12 = r0
            goto L_0x0463
        L_0x0462:
            r12 = r0
        L_0x0463:
            if (r12 == 0) goto L_0x052d
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r7.mListDimensionBehaviors
            r0 = r0[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r1) goto L_0x0473
            boolean r0 = r7 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x0473
            r0 = r3
            goto L_0x0474
        L_0x0473:
            r0 = r4
        L_0x0474:
            if (r0 == 0) goto L_0x0478
            r1 = 0
            goto L_0x047a
        L_0x0478:
            r1 = r27
        L_0x047a:
            if (r59 == 0) goto L_0x0486
            int r5 = r7.mResolvedDimensionRatioSide
            if (r5 == r3) goto L_0x0483
            r6 = -1
            if (r5 != r6) goto L_0x0486
        L_0x0483:
            r35 = r3
            goto L_0x0488
        L_0x0486:
            r35 = r4
        L_0x0488:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r7.mParent
            if (r5 == 0) goto L_0x0493
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mBottom
            androidx.constraintlayout.solver.SolverVariable r5 = r8.createObjectVariable(r5)
            goto L_0x0495
        L_0x0493:
            r5 = r30
        L_0x0495:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r7.mParent
            if (r6 == 0) goto L_0x04a2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mTop
            androidx.constraintlayout.solver.SolverVariable r6 = r8.createObjectVariable(r6)
            r24 = r6
            goto L_0x04a4
        L_0x04a2:
            r24 = r30
        L_0x04a4:
            int r6 = r7.mBaselineDistance
            if (r6 > 0) goto L_0x04ac
            int r6 = r7.mVisibility
            if (r6 != r2) goto L_0x04da
        L_0x04ac:
            int r6 = r62.getBaselineDistance()
            r8.addEquality(r11, r9, r6, r2)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r7.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x04d3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r7.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            androidx.constraintlayout.solver.SolverVariable r6 = r8.createObjectVariable(r6)
            r13 = 0
            r8.addEquality(r11, r6, r13, r2)
            r2 = 0
            if (r53 == 0) goto L_0x04d2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r7.mBottom
            androidx.constraintlayout.solver.SolverVariable r14 = r8.createObjectVariable(r14)
            r15 = 5
            r8.addGreaterThan(r5, r14, r4, r15)
        L_0x04d2:
            goto L_0x04dc
        L_0x04d3:
            int r6 = r7.mVisibility
            if (r6 != r2) goto L_0x04da
            r8.addEquality(r11, r9, r4, r2)
        L_0x04da:
            r2 = r29
        L_0x04dc:
            r20 = 0
            boolean[] r4 = r7.isTerminalWidget
            boolean r23 = r4[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r7.mListDimensionBehaviors
            r26 = r4[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r7.mTop
            r28 = r4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r7.mBottom
            r29 = r4
            int r4 = r7.mY
            r30 = r4
            int r4 = r7.mMinHeight
            r32 = r4
            int[] r4 = r7.mMaxDimension
            r33 = r4[r3]
            float r4 = r7.mVerticalBiasPercent
            r34 = r4
            int r4 = r7.mMatchConstraintMinHeight
            r41 = r4
            int r4 = r7.mMatchConstraintMaxHeight
            r42 = r4
            float r4 = r7.mMatchConstraintPercentHeight
            r43 = r4
            r18 = r62
            r19 = r63
            r21 = r53
            r22 = r54
            r25 = r5
            r27 = r0
            r31 = r1
            r36 = r46
            r37 = r45
            r38 = r51
            r39 = r48
            r40 = r47
            r44 = r2
            r18.applyConstraints(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            r28 = r0
            r27 = r1
            r29 = r2
        L_0x052d:
            if (r59 == 0) goto L_0x0552
            r13 = 8
            int r0 = r7.mResolvedDimensionRatioSide
            if (r0 != r3) goto L_0x0544
            float r5 = r7.mResolvedDimensionRatio
            r0 = r63
            r1 = r10
            r2 = r9
            r3 = r60
            r4 = r61
            r6 = r13
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x0552
        L_0x0544:
            float r5 = r7.mResolvedDimensionRatio
            r0 = r63
            r1 = r60
            r2 = r61
            r3 = r10
            r4 = r9
            r6 = r13
            r0.addRatio(r1, r2, r3, r4, r5, r6)
        L_0x0552:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x0578
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.getTarget()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.getOwner()
            float r1 = r7.mCircleConstraintAngle
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r7.mCenter
            int r2 = r2.getMargin()
            r8.addCenterPoint(r7, r0, r1, r2)
        L_0x0578:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.solver.LinearSystem):void");
    }

    /* access modifiers changed from: package-private */
    public boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    public void setupDimensionRatio(boolean hparentWrapContent, boolean vparentWrapContent, boolean horizontalDimensionFixed, boolean verticalDimensionFixed) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (horizontalDimensionFixed && !verticalDimensionFixed) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!horizontalDimensionFixed && verticalDimensionFixed) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide != -1) {
            return;
        }
        if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
            this.mResolvedDimensionRatioSide = 0;
        } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:189:0x03c2  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0403  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0418 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0419  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyConstraints(androidx.constraintlayout.solver.LinearSystem r36, boolean r37, boolean r38, boolean r39, boolean r40, androidx.constraintlayout.solver.SolverVariable r41, androidx.constraintlayout.solver.SolverVariable r42, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r43, boolean r44, androidx.constraintlayout.solver.widgets.ConstraintAnchor r45, androidx.constraintlayout.solver.widgets.ConstraintAnchor r46, int r47, int r48, int r49, int r50, float r51, boolean r52, boolean r53, boolean r54, boolean r55, int r56, int r57, int r58, int r59, float r60, boolean r61) {
        /*
            r35 = this;
            r0 = r35
            r10 = r36
            r11 = r41
            r12 = r42
            r13 = r45
            r14 = r46
            r15 = r49
            r9 = r50
            r8 = r57
            r1 = r58
            r2 = r59
            androidx.constraintlayout.solver.SolverVariable r7 = r10.createObjectVariable(r13)
            androidx.constraintlayout.solver.SolverVariable r6 = r10.createObjectVariable(r14)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r45.getTarget()
            androidx.constraintlayout.solver.SolverVariable r5 = r10.createObjectVariable(r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r46.getTarget()
            androidx.constraintlayout.solver.SolverVariable r4 = r10.createObjectVariable(r3)
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            if (r3 == 0) goto L_0x0040
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            long r12 = r3.nonresolvedWidgets
            r16 = 1
            long r12 = r12 + r16
            r3.nonresolvedWidgets = r12
        L_0x0040:
            boolean r12 = r45.isConnected()
            boolean r13 = r46.isConnected()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mCenter
            boolean r16 = r3.isConnected()
            r3 = 0
            r17 = 0
            if (r12 == 0) goto L_0x0055
            int r17 = r17 + 1
        L_0x0055:
            if (r13 == 0) goto L_0x0059
            int r17 = r17 + 1
        L_0x0059:
            if (r16 == 0) goto L_0x0060
            int r17 = r17 + 1
            r8 = r17
            goto L_0x0062
        L_0x0060:
            r8 = r17
        L_0x0062:
            if (r52 == 0) goto L_0x0069
            r17 = 3
            r14 = r17
            goto L_0x006b
        L_0x0069:
            r14 = r56
        L_0x006b:
            int[] r17 = androidx.constraintlayout.solver.widgets.ConstraintWidget.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour
            int r18 = r43.ordinal()
            r19 = r3
            r3 = r17[r18]
            r11 = 2
            r17 = r4
            r4 = 1
            if (r3 == r4) goto L_0x008f
            if (r3 == r11) goto L_0x008d
            r4 = 3
            if (r3 == r4) goto L_0x008b
            r4 = 4
            if (r3 == r4) goto L_0x0086
            r3 = r19
            goto L_0x0091
        L_0x0086:
            r3 = 1
            if (r14 != r4) goto L_0x0091
            r3 = 0
            goto L_0x0091
        L_0x008b:
            r3 = 0
            goto L_0x0091
        L_0x008d:
            r3 = 0
            goto L_0x0091
        L_0x008f:
            r3 = 0
        L_0x0091:
            int r4 = r0.mVisibility
            r11 = 8
            if (r4 != r11) goto L_0x009c
            r4 = 0
            r3 = 0
            r20 = r3
            goto L_0x00a0
        L_0x009c:
            r4 = r48
            r20 = r3
        L_0x00a0:
            if (r61 == 0) goto L_0x00bb
            if (r12 != 0) goto L_0x00ae
            if (r13 != 0) goto L_0x00ae
            if (r16 != 0) goto L_0x00ae
            r3 = r47
            r10.addEquality(r7, r3)
            goto L_0x00bb
        L_0x00ae:
            r3 = r47
            if (r12 == 0) goto L_0x00bb
            if (r13 != 0) goto L_0x00bb
            int r3 = r45.getMargin()
            r10.addEquality(r7, r5, r3, r11)
        L_0x00bb:
            r3 = 0
            if (r20 != 0) goto L_0x00ec
            if (r44 == 0) goto L_0x00d7
            r11 = 3
            r10.addEquality(r6, r7, r3, r11)
            if (r15 <= 0) goto L_0x00cc
            r3 = 8
            r10.addGreaterThan(r6, r7, r15, r3)
            goto L_0x00ce
        L_0x00cc:
            r3 = 8
        L_0x00ce:
            r11 = 2147483647(0x7fffffff, float:NaN)
            if (r9 >= r11) goto L_0x00db
            r10.addLowerThan(r6, r7, r9, r3)
            goto L_0x00db
        L_0x00d7:
            r3 = r11
            r10.addEquality(r6, r7, r4, r3)
        L_0x00db:
            r11 = r40
            r24 = r2
            r22 = r4
            r26 = r5
            r9 = r6
            r25 = r8
            r8 = r17
            r17 = r1
            goto L_0x0214
        L_0x00ec:
            r3 = 2
            if (r8 == r3) goto L_0x0118
            if (r52 != 0) goto L_0x0118
            r3 = 1
            if (r14 == r3) goto L_0x00f6
            if (r14 != 0) goto L_0x0118
        L_0x00f6:
            r20 = 0
            int r3 = java.lang.Math.max(r1, r4)
            if (r2 <= 0) goto L_0x0102
            int r3 = java.lang.Math.min(r2, r3)
        L_0x0102:
            r11 = 8
            r10.addEquality(r6, r7, r3, r11)
            r11 = r40
            r24 = r2
            r22 = r4
            r26 = r5
            r9 = r6
            r25 = r8
            r8 = r17
            r17 = r1
            goto L_0x0214
        L_0x0118:
            r3 = -2
            if (r1 != r3) goto L_0x011e
            r1 = r4
            r11 = r1
            goto L_0x011f
        L_0x011e:
            r11 = r1
        L_0x011f:
            if (r2 != r3) goto L_0x0124
            r1 = r4
            r3 = r1
            goto L_0x0125
        L_0x0124:
            r3 = r2
        L_0x0125:
            if (r4 <= 0) goto L_0x012b
            r1 = 1
            if (r14 == r1) goto L_0x012b
            r4 = 0
        L_0x012b:
            if (r11 <= 0) goto L_0x0136
            r1 = 8
            r10.addGreaterThan(r6, r7, r11, r1)
            int r4 = java.lang.Math.max(r4, r11)
        L_0x0136:
            if (r3 <= 0) goto L_0x014b
            r1 = 1
            if (r38 == 0) goto L_0x013f
            r2 = 1
            if (r14 != r2) goto L_0x013f
            r1 = 0
        L_0x013f:
            if (r1 == 0) goto L_0x0146
            r2 = 8
            r10.addLowerThan(r6, r7, r3, r2)
        L_0x0146:
            int r2 = java.lang.Math.min(r4, r3)
            r4 = r2
        L_0x014b:
            r2 = 1
            if (r14 != r2) goto L_0x017e
            if (r38 == 0) goto L_0x0157
            r1 = 8
            r10.addEquality(r6, r7, r4, r1)
            r1 = 5
            goto L_0x016d
        L_0x0157:
            r1 = 8
            if (r53 == 0) goto L_0x0165
            r1 = 5
            r10.addEquality(r6, r7, r4, r1)
            r2 = 8
            r10.addLowerThan(r6, r7, r4, r2)
            goto L_0x016d
        L_0x0165:
            r2 = r1
            r1 = 5
            r10.addEquality(r6, r7, r4, r1)
            r10.addLowerThan(r6, r7, r4, r2)
        L_0x016d:
            r24 = r3
            r22 = r4
            r26 = r5
            r9 = r6
            r25 = r8
            r8 = r17
            r17 = r11
            r11 = r40
            goto L_0x0214
        L_0x017e:
            r1 = 5
            r2 = 2
            if (r14 != r2) goto L_0x0203
            r2 = 0
            r22 = 0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = r45.getType()
            r58 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r1 == r2) goto L_0x01b7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = r45.getType()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r1 != r2) goto L_0x0198
            goto L_0x01b7
        L_0x0198:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.getAnchor(r2)
            androidx.constraintlayout.solver.SolverVariable r1 = r10.createObjectVariable(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.mParent
            r58 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r2.getAnchor(r1)
            androidx.constraintlayout.solver.SolverVariable r1 = r10.createObjectVariable(r1)
            r23 = r58
            r22 = r1
            goto L_0x01d5
        L_0x01b7:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.getAnchor(r2)
            androidx.constraintlayout.solver.SolverVariable r1 = r10.createObjectVariable(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.mParent
            r58 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r2.getAnchor(r1)
            androidx.constraintlayout.solver.SolverVariable r1 = r10.createObjectVariable(r1)
            r23 = r58
            r22 = r1
        L_0x01d5:
            androidx.constraintlayout.solver.ArrayRow r1 = r36.createRow()
            r24 = 5
            r18 = 1
            r2 = r6
            r24 = r3
            r25 = r8
            r8 = 0
            r3 = r7
            r8 = r17
            r9 = r18
            r17 = r4
            r4 = r22
            r26 = r5
            r5 = r23
            r9 = r6
            r6 = r60
            androidx.constraintlayout.solver.ArrayRow r1 = r1.createRowDimensionRatio(r2, r3, r4, r5, r6)
            r10.addConstraint(r1)
            r20 = 0
            r22 = r17
            r17 = r11
            r11 = r40
            goto L_0x0214
        L_0x0203:
            r24 = r3
            r26 = r5
            r9 = r6
            r25 = r8
            r8 = r17
            r17 = r4
            r1 = 1
            r22 = r17
            r17 = r11
            r11 = r1
        L_0x0214:
            if (r61 == 0) goto L_0x0520
            if (r53 == 0) goto L_0x022f
            r6 = r41
            r5 = r42
            r3 = r46
            r15 = r7
            r7 = r8
            r56 = r11
            r30 = r12
            r31 = r13
            r8 = r14
            r32 = r25
            r1 = r26
            r13 = r9
            r9 = 0
            goto L_0x0535
        L_0x022f:
            r6 = 5
            if (r12 != 0) goto L_0x0249
            if (r13 != 0) goto L_0x0249
            if (r16 != 0) goto L_0x0249
            r4 = r6
            r15 = r7
            r7 = r8
            r56 = r11
            r30 = r12
            r31 = r13
            r8 = r14
            r32 = r25
            r1 = r26
            r6 = r41
            r13 = r9
            goto L_0x0504
        L_0x0249:
            if (r12 == 0) goto L_0x0260
            if (r13 != 0) goto L_0x0260
            r4 = r6
            r15 = r7
            r7 = r8
            r56 = r11
            r30 = r12
            r31 = r13
            r8 = r14
            r32 = r25
            r1 = r26
            r6 = r41
            r13 = r9
            goto L_0x0504
        L_0x0260:
            if (r12 != 0) goto L_0x029d
            if (r13 == 0) goto L_0x029d
            int r1 = r46.getMargin()
            int r1 = -r1
            r2 = 8
            r10.addEquality(r9, r8, r1, r2)
            if (r38 == 0) goto L_0x0289
            r5 = r41
            r1 = 5
            r4 = 0
            r10.addGreaterThan(r7, r5, r4, r1)
            r4 = r6
            r15 = r7
            r7 = r8
            r56 = r11
            r30 = r12
            r31 = r13
            r8 = r14
            r32 = r25
            r1 = r26
            r6 = r5
            r13 = r9
            goto L_0x0504
        L_0x0289:
            r5 = r41
            r4 = r6
            r15 = r7
            r7 = r8
            r56 = r11
            r30 = r12
            r31 = r13
            r8 = r14
            r32 = r25
            r1 = r26
            r6 = r5
            r13 = r9
            goto L_0x0504
        L_0x029d:
            r5 = r41
            r3 = 3
            r4 = 0
            if (r12 == 0) goto L_0x04f4
            if (r13 == 0) goto L_0x04f4
            r1 = 1
            r2 = 0
            r21 = 0
            r23 = 0
            r27 = 5
            r28 = 4
            r29 = 6
            if (r38 == 0) goto L_0x02b5
            r27 = 5
        L_0x02b5:
            r3 = r45
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r4.mOwner
            r48 = r1
            r30 = r12
            r12 = r14
            r14 = r46
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r14.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r1.mOwner
            r31 = r13
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r35.getParent()
            if (r20 == 0) goto L_0x03a4
            if (r12 != 0) goto L_0x0305
            if (r24 != 0) goto L_0x02df
            if (r17 != 0) goto L_0x02df
            r21 = 1
            r18 = 8
            r19 = 8
            r27 = r18
            r28 = r19
            goto L_0x02e8
        L_0x02df:
            r2 = 1
            r18 = 5
            r19 = 5
            r27 = r18
            r28 = r19
        L_0x02e8:
            r58 = r2
            boolean r2 = r4 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r2 != 0) goto L_0x02fb
            boolean r2 = r1 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r2 == 0) goto L_0x02f3
            goto L_0x02fb
        L_0x02f3:
            r3 = r57
            r18 = r58
            r32 = r25
            goto L_0x03af
        L_0x02fb:
            r28 = 4
            r3 = r57
            r18 = r58
            r32 = r25
            goto L_0x03af
        L_0x0305:
            r58 = r2
            r2 = 1
            if (r12 != r2) goto L_0x0317
            r2 = 1
            r23 = 1
            r27 = 8
            r3 = r57
            r18 = r2
            r32 = r25
            goto L_0x03af
        L_0x0317:
            r2 = 3
            if (r12 != r2) goto L_0x039d
            int r2 = r0.mResolvedDimensionRatioSide
            r3 = -1
            if (r2 != r3) goto L_0x034c
            r2 = 1
            r23 = 1
            r21 = 1
            r27 = 8
            r28 = 5
            if (r54 == 0) goto L_0x0342
            r28 = 5
            r29 = 4
            if (r38 == 0) goto L_0x033a
            r29 = 5
            r3 = r57
            r18 = r2
            r32 = r25
            goto L_0x03af
        L_0x033a:
            r3 = r57
            r18 = r2
            r32 = r25
            goto L_0x03af
        L_0x0342:
            r29 = 8
            r3 = r57
            r18 = r2
            r32 = r25
            goto L_0x03af
        L_0x034c:
            r2 = 1
            r23 = 1
            r21 = 1
            if (r52 == 0) goto L_0x0370
            r3 = r57
            r58 = r2
            r32 = r25
            r2 = 2
            if (r3 == r2) goto L_0x0363
            r2 = 1
            if (r3 != r2) goto L_0x0360
            goto L_0x0363
        L_0x0360:
            r18 = 0
            goto L_0x0365
        L_0x0363:
            r18 = 1
        L_0x0365:
            r2 = r18
            if (r2 != 0) goto L_0x036d
            r27 = 8
            r28 = 5
        L_0x036d:
            r18 = r58
            goto L_0x03af
        L_0x0370:
            r3 = r57
            r58 = r2
            r32 = r25
            r27 = 5
            if (r24 <= 0) goto L_0x037f
            r28 = 5
            r18 = r58
            goto L_0x03af
        L_0x037f:
            if (r24 != 0) goto L_0x039a
            if (r17 != 0) goto L_0x039a
            if (r54 != 0) goto L_0x038a
            r28 = 8
            r18 = r58
            goto L_0x03af
        L_0x038a:
            if (r4 == r13) goto L_0x0392
            if (r1 == r13) goto L_0x0392
            r2 = 4
            r27 = r2
            goto L_0x0395
        L_0x0392:
            r2 = 5
            r27 = r2
        L_0x0395:
            r28 = 4
            r18 = r58
            goto L_0x03af
        L_0x039a:
            r18 = r58
            goto L_0x03af
        L_0x039d:
            r3 = r57
            r32 = r25
            r18 = r58
            goto L_0x03af
        L_0x03a4:
            r3 = r57
            r58 = r2
            r32 = r25
            r2 = 1
            r23 = 1
            r18 = r2
        L_0x03af:
            if (r23 == 0) goto L_0x03bc
            r2 = r26
            if (r2 != r8) goto L_0x03be
            if (r4 == r13) goto L_0x03be
            r23 = 0
            r19 = 0
            goto L_0x03c0
        L_0x03bc:
            r2 = r26
        L_0x03be:
            r19 = r48
        L_0x03c0:
            if (r18 == 0) goto L_0x0403
            r25 = r1
            int r1 = r0.mVisibility
            r26 = r2
            r2 = 8
            if (r1 != r2) goto L_0x03cf
            r1 = 4
            r29 = r1
        L_0x03cf:
            int r33 = r45.getMargin()
            int r34 = r46.getMargin()
            r2 = r25
            r1 = r36
            r14 = r2
            r48 = r26
            r25 = 3
            r2 = r7
            r56 = r11
            r11 = r25
            r3 = r48
            r11 = r4
            r26 = 0
            r4 = r33
            r40 = r12
            r12 = r5
            r5 = r51
            r15 = r6
            r6 = r8
            r33 = r15
            r15 = r7
            r7 = r9
            r12 = r8
            r8 = r34
            r58 = r13
            r13 = r9
            r9 = r29
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0412
        L_0x0403:
            r14 = r1
            r48 = r2
            r33 = r6
            r15 = r7
            r56 = r11
            r40 = r12
            r58 = r13
            r11 = r4
            r12 = r8
            r13 = r9
        L_0x0412:
            int r1 = r0.mVisibility
            r2 = 8
            if (r1 != r2) goto L_0x0419
            return
        L_0x0419:
            if (r23 == 0) goto L_0x0443
            if (r38 == 0) goto L_0x042d
            r1 = r48
            if (r1 == r12) goto L_0x042f
            if (r20 != 0) goto L_0x042f
            boolean r2 = r11 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r2 != 0) goto L_0x042b
            boolean r2 = r14 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r2 == 0) goto L_0x042f
        L_0x042b:
            r2 = 6
            goto L_0x0431
        L_0x042d:
            r1 = r48
        L_0x042f:
            r2 = r27
        L_0x0431:
            int r3 = r45.getMargin()
            r10.addGreaterThan(r15, r1, r3, r2)
            int r3 = r46.getMargin()
            int r3 = -r3
            r10.addLowerThan(r13, r12, r3, r2)
            r27 = r2
            goto L_0x0445
        L_0x0443:
            r1 = r48
        L_0x0445:
            if (r38 == 0) goto L_0x045c
            if (r55 == 0) goto L_0x045c
            boolean r2 = r11 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r2 != 0) goto L_0x045c
            boolean r2 = r14 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r2 != 0) goto L_0x045c
            r28 = 6
            r27 = 6
            r19 = 1
            r2 = r27
            r3 = r28
            goto L_0x0460
        L_0x045c:
            r2 = r27
            r3 = r28
        L_0x0460:
            if (r19 == 0) goto L_0x04af
            if (r21 == 0) goto L_0x048e
            if (r54 == 0) goto L_0x046c
            if (r39 == 0) goto L_0x0469
            goto L_0x046c
        L_0x0469:
            r5 = r58
            goto L_0x0490
        L_0x046c:
            r4 = r3
            r5 = r58
            if (r11 == r5) goto L_0x0473
            if (r14 != r5) goto L_0x0474
        L_0x0473:
            r4 = 6
        L_0x0474:
            boolean r6 = r11 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r6 != 0) goto L_0x047c
            boolean r6 = r14 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r6 == 0) goto L_0x047d
        L_0x047c:
            r4 = 5
        L_0x047d:
            boolean r6 = r11 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r6 != 0) goto L_0x0485
            boolean r6 = r14 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r6 == 0) goto L_0x0486
        L_0x0485:
            r4 = 5
        L_0x0486:
            if (r54 == 0) goto L_0x0489
            r4 = 5
        L_0x0489:
            int r3 = java.lang.Math.max(r4, r3)
            goto L_0x0490
        L_0x048e:
            r5 = r58
        L_0x0490:
            if (r38 == 0) goto L_0x049f
            int r3 = java.lang.Math.min(r2, r3)
            if (r52 == 0) goto L_0x049f
            if (r54 != 0) goto L_0x049f
            if (r11 == r5) goto L_0x049e
            if (r14 != r5) goto L_0x049f
        L_0x049e:
            r3 = 4
        L_0x049f:
            int r4 = r45.getMargin()
            r10.addEquality(r15, r1, r4, r3)
            int r4 = r46.getMargin()
            int r4 = -r4
            r10.addEquality(r13, r12, r4, r3)
            goto L_0x04b1
        L_0x04af:
            r5 = r58
        L_0x04b1:
            if (r38 == 0) goto L_0x04c8
            r4 = 0
            r6 = r41
            r7 = r12
            if (r6 != r1) goto L_0x04bd
            int r4 = r45.getMargin()
        L_0x04bd:
            if (r1 == r6) goto L_0x04c5
            r8 = r33
            r10.addGreaterThan(r15, r6, r4, r8)
            goto L_0x04cd
        L_0x04c5:
            r8 = r33
            goto L_0x04cd
        L_0x04c8:
            r6 = r41
            r7 = r12
            r8 = r33
        L_0x04cd:
            if (r38 == 0) goto L_0x04f0
            if (r20 == 0) goto L_0x04f0
            r4 = r8
            if (r49 != 0) goto L_0x04ed
            if (r17 != 0) goto L_0x04ed
            if (r20 == 0) goto L_0x04e6
            r8 = r40
            r9 = 3
            if (r8 != r9) goto L_0x04e4
            r9 = 0
            r12 = 8
            r10.addGreaterThan(r13, r15, r9, r12)
            goto L_0x0504
        L_0x04e4:
            r9 = 0
            goto L_0x04e9
        L_0x04e6:
            r8 = r40
            r9 = 0
        L_0x04e9:
            r10.addGreaterThan(r13, r15, r9, r4)
            goto L_0x0504
        L_0x04ed:
            r8 = r40
            goto L_0x0504
        L_0x04f0:
            r4 = r8
            r8 = r40
            goto L_0x0504
        L_0x04f4:
            r4 = r6
            r15 = r7
            r7 = r8
            r56 = r11
            r30 = r12
            r31 = r13
            r8 = r14
            r32 = r25
            r1 = r26
            r6 = r5
            r13 = r9
        L_0x0504:
            if (r38 == 0) goto L_0x051b
            if (r56 == 0) goto L_0x051b
            r2 = 0
            r3 = r46
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.mTarget
            if (r5 == 0) goto L_0x0513
            int r2 = r46.getMargin()
        L_0x0513:
            r5 = r42
            if (r7 == r5) goto L_0x051f
            r10.addGreaterThan(r5, r13, r2, r4)
            goto L_0x051f
        L_0x051b:
            r5 = r42
            r3 = r46
        L_0x051f:
            return
        L_0x0520:
            r6 = r41
            r5 = r42
            r3 = r46
            r15 = r7
            r7 = r8
            r56 = r11
            r30 = r12
            r31 = r13
            r8 = r14
            r32 = r25
            r1 = r26
            r13 = r9
            r9 = 0
        L_0x0535:
            r2 = r32
            r4 = 2
            if (r2 >= r4) goto L_0x057f
            if (r38 == 0) goto L_0x057f
            if (r56 == 0) goto L_0x057f
            r4 = 8
            r10.addGreaterThan(r15, r6, r9, r4)
            if (r37 != 0) goto L_0x054e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 != 0) goto L_0x054c
            goto L_0x054e
        L_0x054c:
            r4 = r9
            goto L_0x054f
        L_0x054e:
            r4 = 1
        L_0x054f:
            if (r37 != 0) goto L_0x0578
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r11.mTarget
            if (r11 == 0) goto L_0x0578
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r11.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r11.mOwner
            float r12 = r11.mDimensionRatio
            r14 = 0
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L_0x0577
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r12 = r11.mListDimensionBehaviors
            r12 = r12[r9]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r14) goto L_0x0577
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r12 = r11.mListDimensionBehaviors
            r14 = 1
            r12 = r12[r14]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r14) goto L_0x0577
            r4 = 1
            goto L_0x0578
        L_0x0577:
            r4 = 0
        L_0x0578:
            if (r4 == 0) goto L_0x057f
            r11 = 8
            r10.addGreaterThan(r5, r13, r9, r11)
        L_0x057f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.applyConstraints(androidx.constraintlayout.solver.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = new int[DimensionBehaviour.values().length];

        static {
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = new int[ConstraintAnchor.Type.values().length];
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    public void updateFromSolver(LinearSystem system) {
        int left = system.getObjectVariableValue(this.mLeft);
        int top = system.getObjectVariableValue(this.mTop);
        int right = system.getObjectVariableValue(this.mRight);
        int bottom = system.getObjectVariableValue(this.mBottom);
        if (this.horizontalRun.start.resolved && this.horizontalRun.end.resolved) {
            left = this.horizontalRun.start.value;
            right = this.horizontalRun.end.value;
        }
        if (this.verticalRun.start.resolved && this.verticalRun.end.resolved) {
            top = this.verticalRun.start.value;
            bottom = this.verticalRun.end.value;
        }
        int h = bottom - top;
        if (right - left < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
        }
        setFrame(left, top, right, bottom);
    }

    public void copy(ConstraintWidget src, HashMap<ConstraintWidget, ConstraintWidget> map) {
        this.mHorizontalResolution = src.mHorizontalResolution;
        this.mVerticalResolution = src.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = src.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = src.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = src.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = src.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = src.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = src.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = src.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = src.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = src.mIsWidthWrapContent;
        this.mIsHeightWrapContent = src.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = src.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = src.mResolvedDimensionRatio;
        int[] iArr3 = src.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = src.mCircleConstraintAngle;
        this.hasBaseline = src.hasBaseline;
        this.inPlaceholder = src.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget = null;
        this.mParent = this.mParent == null ? null : map.get(src.mParent);
        this.mWidth = src.mWidth;
        this.mHeight = src.mHeight;
        this.mDimensionRatio = src.mDimensionRatio;
        this.mDimensionRatioSide = src.mDimensionRatioSide;
        this.mX = src.mX;
        this.mY = src.mY;
        this.mRelX = src.mRelX;
        this.mRelY = src.mRelY;
        this.mOffsetX = src.mOffsetX;
        this.mOffsetY = src.mOffsetY;
        this.mBaselineDistance = src.mBaselineDistance;
        this.mMinWidth = src.mMinWidth;
        this.mMinHeight = src.mMinHeight;
        this.mHorizontalBiasPercent = src.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = src.mVerticalBiasPercent;
        this.mCompanionWidget = src.mCompanionWidget;
        this.mContainerItemSkip = src.mContainerItemSkip;
        this.mVisibility = src.mVisibility;
        this.mDebugName = src.mDebugName;
        this.mType = src.mType;
        this.mDistToTop = src.mDistToTop;
        this.mDistToLeft = src.mDistToLeft;
        this.mDistToRight = src.mDistToRight;
        this.mDistToBottom = src.mDistToBottom;
        this.mLeftHasCentered = src.mLeftHasCentered;
        this.mRightHasCentered = src.mRightHasCentered;
        this.mTopHasCentered = src.mTopHasCentered;
        this.mBottomHasCentered = src.mBottomHasCentered;
        this.mHorizontalWrapVisited = src.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = src.mVerticalWrapVisited;
        this.mOptimizerMeasurable = src.mOptimizerMeasurable;
        this.mGroupsToSolver = src.mGroupsToSolver;
        this.mHorizontalChainStyle = src.mHorizontalChainStyle;
        this.mVerticalChainStyle = src.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = src.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = src.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = src.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = src.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = src.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = src.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget2 == null ? null : map.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = src.mVerticalNextWidget;
        if (constraintWidget3 != null) {
            constraintWidget = map.get(constraintWidget3);
        }
        this.mVerticalNextWidget = constraintWidget;
    }

    public void updateFromRuns(boolean updateHorizontal, boolean updateVertical) {
        boolean updateHorizontal2 = updateHorizontal & this.horizontalRun.isResolved();
        boolean updateVertical2 = updateVertical & this.verticalRun.isResolved();
        int left = this.horizontalRun.start.value;
        int top = this.verticalRun.start.value;
        int right = this.horizontalRun.end.value;
        int bottom = this.verticalRun.end.value;
        int h = bottom - top;
        if (right - left < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
        }
        int w = right - left;
        int h2 = bottom - top;
        if (updateHorizontal2) {
            this.mX = left;
        }
        if (updateVertical2) {
            this.mY = top;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (updateHorizontal2) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && w < this.mWidth) {
                w = this.mWidth;
            }
            this.mWidth = w;
            int i = this.mWidth;
            int i2 = this.mMinWidth;
            if (i < i2) {
                this.mWidth = i2;
            }
        }
        if (updateVertical2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && h2 < this.mHeight) {
                h2 = this.mHeight;
            }
            this.mHeight = h2;
            int i3 = this.mHeight;
            int i4 = this.mMinHeight;
            if (i3 < i4) {
                this.mHeight = i4;
            }
        }
    }
}
