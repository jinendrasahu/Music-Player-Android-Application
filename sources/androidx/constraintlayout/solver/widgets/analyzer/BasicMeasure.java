package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private Measure mMeasure = new Measure();
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();

    public static class Measure {
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public boolean useCurrentDimensions;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public enum MeasureType {
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public void updateHierarchy(ConstraintWidgetContainer layout) {
        this.mVariableDimensionsWidgets.clear();
        int childCount = layout.mChildren.size();
        for (int i = 0; i < childCount; i++) {
            ConstraintWidget widget = (ConstraintWidget) layout.mChildren.get(i);
            if (widget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || widget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || widget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || widget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                this.mVariableDimensionsWidgets.add(widget);
            }
        }
        layout.invalidateGraph();
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer2) {
        this.constraintWidgetContainer = constraintWidgetContainer2;
    }

    private void measureChildren(ConstraintWidgetContainer layout) {
        int childCount = layout.mChildren.size();
        Measurer measurer = layout.getMeasurer();
        for (int i = 0; i < childCount; i++) {
            ConstraintWidget child = (ConstraintWidget) layout.mChildren.get(i);
            if (!(child instanceof Guideline) && (!child.horizontalRun.dimension.resolved || !child.verticalRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour widthBehavior = child.getDimensionBehaviour(0);
                boolean skip = true;
                ConstraintWidget.DimensionBehaviour heightBehavior = child.getDimensionBehaviour(1);
                if (widthBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || child.mMatchConstraintDefaultWidth == 1 || heightBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || child.mMatchConstraintDefaultHeight == 1) {
                    skip = false;
                }
                if (!skip) {
                    measure(measurer, child, false);
                    if (layout.mMetrics != null) {
                        layout.mMetrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer layout, String reason, int w, int h) {
        int minWidth = layout.getMinWidth();
        int minHeight = layout.getMinHeight();
        layout.setMinWidth(0);
        layout.setMinHeight(0);
        layout.setWidth(w);
        layout.setHeight(h);
        layout.setMinWidth(minWidth);
        layout.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer layout, int optimizationLevel, int paddingX, int paddingY, int widthMode, int widthSize, int heightMode, int heightSize, int lastMeasureWidth, int lastMeasureHeight) {
        boolean optimize;
        int heightSize2;
        int heightSize3;
        int widthSize2;
        int optimizations;
        long layoutTime;
        int startingHeight;
        int startingWidth;
        int j;
        Measurer measurer;
        int maxIterations;
        int startingHeight2;
        int startingWidth2;
        int optimizations2;
        boolean needSolverPass;
        boolean allSolved;
        boolean allSolved2;
        ConstraintWidgetContainer constraintWidgetContainer2 = layout;
        int i = optimizationLevel;
        int i2 = widthMode;
        int i3 = heightMode;
        Measurer measurer2 = layout.getMeasurer();
        long layoutTime2 = 0;
        int childCount = constraintWidgetContainer2.mChildren.size();
        int startingWidth3 = layout.getWidth();
        int startingHeight3 = layout.getHeight();
        boolean optimizeWrap = Optimizer.enabled(i, 128);
        boolean optimize2 = optimizeWrap || Optimizer.enabled(i, 64);
        if (optimize2) {
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    optimize = optimize2;
                    break;
                }
                ConstraintWidget child = (ConstraintWidget) constraintWidgetContainer2.mChildren.get(i4);
                boolean matchWidth = child.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean optimize3 = optimize2;
                boolean ratio = matchWidth && (child.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && child.getDimensionRatio() > 0.0f;
                if (!child.isInHorizontalChain() || !ratio) {
                    if (child.isInVerticalChain() && ratio) {
                        optimize = false;
                        break;
                    }
                    boolean z = matchWidth;
                    if (child instanceof VirtualLayout) {
                        optimize = false;
                        break;
                    } else if (child.isInHorizontalChain() || child.isInVerticalChain()) {
                        optimize = false;
                    } else {
                        i4++;
                        int i5 = optimizationLevel;
                        optimize2 = optimize3;
                    }
                } else {
                    optimize = false;
                    break;
                }
            }
        } else {
            optimize = optimize2;
        }
        if (optimize && LinearSystem.sMetrics != null) {
            LinearSystem.sMetrics.measures++;
        }
        boolean allSolved3 = false;
        boolean optimize4 = optimize & ((i2 == 1073741824 && i3 == 1073741824) || optimizeWrap);
        int computations = 0;
        if (optimize4) {
            int widthSize3 = Math.min(layout.getMaxWidth(), widthSize);
            int heightSize4 = Math.min(layout.getMaxHeight(), heightSize);
            if (i2 == 1073741824 && layout.getWidth() != widthSize3) {
                constraintWidgetContainer2.setWidth(widthSize3);
                layout.invalidateGraph();
            }
            if (i3 == 1073741824 && layout.getHeight() != heightSize4) {
                constraintWidgetContainer2.setHeight(heightSize4);
                layout.invalidateGraph();
            }
            if (i2 == 1073741824 && i3 == 1073741824) {
                allSolved = constraintWidgetContainer2.directMeasure(optimizeWrap);
                computations = 2;
            } else {
                allSolved = constraintWidgetContainer2.directMeasureSetup(optimizeWrap);
                if (i2 == 1073741824) {
                    allSolved &= constraintWidgetContainer2.directMeasureWithOrientation(optimizeWrap, 0);
                    computations = 0 + 1;
                }
                if (i3 == 1073741824) {
                    allSolved &= constraintWidgetContainer2.directMeasureWithOrientation(optimizeWrap, 1);
                    computations++;
                }
            }
            if (allSolved) {
                allSolved2 = allSolved;
                constraintWidgetContainer2.updateFromRuns(i2 == 1073741824, i3 == 1073741824);
            } else {
                allSolved2 = allSolved;
            }
            allSolved3 = allSolved2;
            heightSize2 = heightSize4;
            heightSize3 = widthSize3;
            widthSize2 = computations;
        } else {
            heightSize3 = widthSize;
            heightSize2 = heightSize;
            widthSize2 = 0;
        }
        if (allSolved3) {
            boolean z2 = allSolved3;
            if (widthSize2 == 2) {
                Measurer measurer3 = measurer2;
                int i6 = childCount;
                int i7 = startingWidth3;
                int i8 = startingHeight3;
                boolean z3 = optimizeWrap;
                int i9 = widthSize2;
                int i10 = heightSize3;
                int i11 = heightSize2;
                boolean z4 = optimize4;
                return 0;
            }
        }
        if (childCount > 0) {
            measureChildren(layout);
        }
        int optimizations3 = layout.getOptimizationLevel();
        int sizeDependentWidgetsCount = this.mVariableDimensionsWidgets.size();
        if (childCount > 0) {
            solveLinearSystem(constraintWidgetContainer2, "First pass", startingWidth3, startingHeight3);
        }
        if (sizeDependentWidgetsCount > 0) {
            int i12 = childCount;
            boolean containerWrapWidth = layout.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z5 = optimizeWrap;
            boolean containerWrapHeight = layout.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            int i13 = widthSize2;
            int i14 = 0;
            boolean needSolverPass2 = false;
            int i15 = heightSize3;
            int minWidth = Math.max(layout.getWidth(), this.constraintWidgetContainer.getMinWidth());
            int minWidth2 = heightSize2;
            int minHeight = Math.max(layout.getHeight(), this.constraintWidgetContainer.getMinHeight());
            while (i14 < sizeDependentWidgetsCount) {
                boolean optimize5 = optimize4;
                ConstraintWidget widget = this.mVariableDimensionsWidgets.get(i14);
                long layoutTime3 = layoutTime2;
                if (!(widget instanceof VirtualLayout)) {
                    optimizations2 = optimizations3;
                    startingWidth2 = startingWidth3;
                    startingHeight2 = startingHeight3;
                } else {
                    int preWidth = widget.getWidth();
                    int preHeight = widget.getHeight();
                    optimizations2 = optimizations3;
                    boolean needSolverPass3 = needSolverPass2 | measure(measurer2, widget, true);
                    if (constraintWidgetContainer2.mMetrics != null) {
                        startingWidth2 = startingWidth3;
                        startingHeight2 = startingHeight3;
                        constraintWidgetContainer2.mMetrics.measuredMatchWidgets++;
                    } else {
                        startingWidth2 = startingWidth3;
                        startingHeight2 = startingHeight3;
                    }
                    int measuredWidth = widget.getWidth();
                    int measuredHeight = widget.getHeight();
                    if (measuredWidth != preWidth) {
                        widget.setWidth(measuredWidth);
                        if (!containerWrapWidth || widget.getRight() <= minWidth) {
                        } else {
                            boolean z6 = needSolverPass3;
                            minWidth = Math.max(minWidth, widget.getRight() + widget.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                        }
                        needSolverPass = true;
                    } else {
                        needSolverPass = needSolverPass3;
                    }
                    if (measuredHeight != preHeight) {
                        widget.setHeight(measuredHeight);
                        if (containerWrapHeight && widget.getBottom() > minHeight) {
                            minHeight = Math.max(minHeight, widget.getBottom() + widget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                        }
                        needSolverPass = true;
                    }
                    needSolverPass2 = needSolverPass | ((VirtualLayout) widget).needSolverPass();
                }
                i14++;
                optimize4 = optimize5;
                layoutTime2 = layoutTime3;
                optimizations3 = optimizations2;
                startingWidth3 = startingWidth2;
                startingHeight3 = startingHeight2;
            }
            optimizations = optimizations3;
            layoutTime = layoutTime2;
            int startingWidth4 = startingWidth3;
            int startingHeight4 = startingHeight3;
            boolean z7 = optimize4;
            int maxIterations2 = 2;
            int j2 = 0;
            while (j2 < maxIterations2) {
                int i16 = 0;
                while (i16 < sizeDependentWidgetsCount) {
                    ConstraintWidget widget2 = this.mVariableDimensionsWidgets.get(i16);
                    if ((!(widget2 instanceof Helper) || (widget2 instanceof VirtualLayout)) && !(widget2 instanceof Guideline) && widget2.getVisibility() != 8 && ((!widget2.horizontalRun.dimension.resolved || !widget2.verticalRun.dimension.resolved) && !(widget2 instanceof VirtualLayout))) {
                        int preWidth2 = widget2.getWidth();
                        int preHeight2 = widget2.getHeight();
                        int preBaselineDistance = widget2.getBaselineDistance();
                        maxIterations = maxIterations2;
                        needSolverPass2 |= measure(measurer2, widget2, true);
                        if (constraintWidgetContainer2.mMetrics != null) {
                            measurer = measurer2;
                            j = j2;
                            constraintWidgetContainer2.mMetrics.measuredMatchWidgets++;
                        } else {
                            measurer = measurer2;
                            j = j2;
                        }
                        int measuredWidth2 = widget2.getWidth();
                        int measuredHeight2 = widget2.getHeight();
                        if (measuredWidth2 != preWidth2) {
                            widget2.setWidth(measuredWidth2);
                            if (!containerWrapWidth || widget2.getRight() <= minWidth) {
                            } else {
                                int i17 = measuredWidth2;
                                minWidth = Math.max(minWidth, widget2.getRight() + widget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            needSolverPass2 = true;
                        }
                        if (measuredHeight2 != preHeight2) {
                            widget2.setHeight(measuredHeight2);
                            if (containerWrapHeight && widget2.getBottom() > minHeight) {
                                minHeight = Math.max(minHeight, widget2.getBottom() + widget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                            needSolverPass2 = true;
                        }
                        if (widget2.hasBaseline() && preBaselineDistance != widget2.getBaselineDistance()) {
                            needSolverPass2 = true;
                        }
                    } else {
                        maxIterations = maxIterations2;
                        measurer = measurer2;
                        j = j2;
                    }
                    i16++;
                    maxIterations2 = maxIterations;
                    measurer2 = measurer;
                    j2 = j;
                }
                int maxIterations3 = maxIterations2;
                Measurer measurer4 = measurer2;
                int j3 = j2;
                if (needSolverPass2) {
                    startingWidth = startingWidth4;
                    startingHeight = startingHeight4;
                    solveLinearSystem(constraintWidgetContainer2, "intermediate pass", startingWidth, startingHeight);
                    needSolverPass2 = false;
                } else {
                    startingWidth = startingWidth4;
                    startingHeight = startingHeight4;
                }
                startingWidth4 = startingWidth;
                startingHeight4 = startingHeight;
                measurer2 = measurer4;
                j2 = j3 + 1;
                maxIterations2 = maxIterations3;
            }
            Measurer measurer5 = measurer2;
            int i18 = j2;
            int startingWidth5 = startingWidth4;
            int startingHeight5 = startingHeight4;
            if (needSolverPass2) {
                solveLinearSystem(constraintWidgetContainer2, "2nd pass", startingWidth5, startingHeight5);
                boolean needSolverPass4 = false;
                if (layout.getWidth() < minWidth) {
                    constraintWidgetContainer2.setWidth(minWidth);
                    needSolverPass4 = true;
                }
                if (layout.getHeight() < minHeight) {
                    constraintWidgetContainer2.setHeight(minHeight);
                    needSolverPass4 = true;
                }
                if (needSolverPass4) {
                    solveLinearSystem(constraintWidgetContainer2, "3rd pass", startingWidth5, startingHeight5);
                }
            }
        } else {
            optimizations = optimizations3;
            Measurer measurer6 = measurer2;
            layoutTime = 0;
            int i19 = childCount;
            int i20 = startingWidth3;
            int i21 = startingHeight3;
            boolean z8 = optimizeWrap;
            int i22 = widthSize2;
            int i23 = heightSize3;
            int i24 = heightSize2;
            boolean z9 = optimize4;
        }
        constraintWidgetContainer2.setOptimizationLevel(optimizations);
        return layoutTime;
    }

    private boolean measure(Measurer measurer, ConstraintWidget widget, boolean useCurrentDimensions) {
        this.mMeasure.horizontalBehavior = widget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = widget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = widget.getWidth();
        this.mMeasure.verticalDimension = widget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.useCurrentDimensions = useCurrentDimensions;
        boolean horizontalMatchConstraints = measure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean verticalMatchConstraints = this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean horizontalUseRatio = horizontalMatchConstraints && widget.mDimensionRatio > 0.0f;
        boolean verticalUseRatio = verticalMatchConstraints && widget.mDimensionRatio > 0.0f;
        if (horizontalUseRatio && widget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (verticalUseRatio && widget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(widget, this.mMeasure);
        widget.setWidth(this.mMeasure.measuredWidth);
        widget.setHeight(this.mMeasure.measuredHeight);
        widget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        widget.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure measure2 = this.mMeasure;
        measure2.useCurrentDimensions = false;
        return measure2.measuredNeedsSolverPass;
    }
}
