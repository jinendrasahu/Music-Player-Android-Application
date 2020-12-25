package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets = new ArrayList<>();

    public ChainRun(ConstraintWidget widget, int orientation) {
        super(widget);
        this.orientation = orientation;
        build();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        String log = sb.toString();
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            log = ((log + "<") + it.next()) + "> ";
        }
        return log;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsWrapComputation() {
        int count = this.widgets.size();
        for (int i = 0; i < count; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public long getWrapDimension() {
        int count = this.widgets.size();
        long wrapDimension = 0;
        for (int i = 0; i < count; i++) {
            WidgetRun run = this.widgets.get(i);
            wrapDimension = wrapDimension + ((long) run.start.margin) + run.getWrapDimension() + ((long) run.end.margin);
        }
        return wrapDimension;
    }

    private void build() {
        ConstraintWidget current = this.widget;
        ConstraintWidget previous = current.getPreviousChainMember(this.orientation);
        while (previous != null) {
            current = previous;
            previous = current.getPreviousChainMember(this.orientation);
        }
        this.widget = current;
        this.widgets.add(current.getRun(this.orientation));
        ConstraintWidget next = current.getNextChainMember(this.orientation);
        while (next != null) {
            ConstraintWidget current2 = next;
            this.widgets.add(current2.getRun(this.orientation));
            next = current2.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun run = it.next();
            if (this.orientation == 0) {
                run.widget.horizontalChainRun = this;
            } else if (this.orientation == 1) {
                run.widget.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl()) && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    public void update(Dependency dependency) {
        int i;
        float weights;
        int size;
        int position;
        boolean isInRtl;
        int i2;
        float bias;
        int position2;
        int position3;
        int position4;
        int position5;
        int matchConstraintsDimension;
        boolean isInRtl2;
        int size2;
        int dimension;
        int value;
        ConstraintWidget parent;
        ChainRun chainRun = this;
        if (chainRun.start.resolved && chainRun.end.resolved) {
            ConstraintWidget parent2 = chainRun.widget.getParent();
            boolean isInRtl3 = false;
            if (parent2 != null && (parent2 instanceof ConstraintWidgetContainer)) {
                isInRtl3 = ((ConstraintWidgetContainer) parent2).isRtl();
            }
            int distance = chainRun.end.value - chainRun.start.value;
            int size3 = 0;
            int numMatchConstraints = 0;
            float weights2 = 0.0f;
            int numVisibleWidgets = 0;
            int count = chainRun.widgets.size();
            int firstVisibleWidget = -1;
            int i3 = 0;
            while (true) {
                i = 8;
                if (i3 < count) {
                    if (chainRun.widgets.get(i3).widget.getVisibility() != 8) {
                        firstVisibleWidget = i3;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            int lastVisibleWidget = -1;
            int i4 = count - 1;
            while (true) {
                if (i4 >= 0) {
                    if (chainRun.widgets.get(i4).widget.getVisibility() != 8) {
                        lastVisibleWidget = i4;
                        break;
                    }
                    i4--;
                } else {
                    break;
                }
            }
            int j = 0;
            while (true) {
                if (j >= 2) {
                    weights = weights2;
                    break;
                }
                int i5 = numMatchConstraints;
                int size4 = size3;
                int i6 = 0;
                weights = weights2;
                int numMatchConstraints2 = i5;
                while (i6 < count) {
                    WidgetRun run = chainRun.widgets.get(i6);
                    if (run.widget.getVisibility() == i) {
                        parent = parent2;
                    } else {
                        numVisibleWidgets++;
                        if (i6 > 0 && i6 >= firstVisibleWidget) {
                            size4 += run.start.margin;
                        }
                        int dimension2 = run.dimension.value;
                        boolean treatAsFixed = run.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (!treatAsFixed) {
                            parent = parent2;
                            if (run.matchConstraintsType == 1 && j == 0) {
                                treatAsFixed = true;
                                dimension2 = run.dimension.wrapValue;
                                numMatchConstraints2++;
                            } else if (run.dimension.resolved) {
                                treatAsFixed = true;
                            }
                        } else if (chainRun.orientation != 0 || run.widget.horizontalRun.dimension.resolved) {
                            parent = parent2;
                            if (chainRun.orientation == 1 && !run.widget.verticalRun.dimension.resolved) {
                                return;
                            }
                        } else {
                            return;
                        }
                        if (!treatAsFixed) {
                            numMatchConstraints2++;
                            float weight = run.widget.mWeight[chainRun.orientation];
                            if (weight >= 0.0f) {
                                weights += weight;
                            }
                        } else {
                            size4 += dimension2;
                        }
                        if (i6 < count - 1 && i6 < lastVisibleWidget) {
                            size4 += -run.end.margin;
                        }
                    }
                    i6++;
                    parent2 = parent;
                    i = 8;
                }
                ConstraintWidget parent3 = parent2;
                if (size4 < distance || numMatchConstraints2 == 0) {
                    size3 = size4;
                    numMatchConstraints = numMatchConstraints2;
                } else {
                    numVisibleWidgets = 0;
                    size3 = 0;
                    weights2 = 0.0f;
                    j++;
                    numMatchConstraints = 0;
                    parent2 = parent3;
                    i = 8;
                }
            }
            int position6 = chainRun.start.value;
            if (isInRtl3) {
                position6 = chainRun.end.value;
            }
            if (size > distance) {
                if (isInRtl3) {
                    position6 += (int) ((((float) (size - distance)) / 2.0f) + 0.5f);
                } else {
                    position6 -= (int) ((((float) (size - distance)) / 2.0f) + 0.5f);
                }
            }
            if (numMatchConstraints > 0) {
                int matchConstraintsDimension2 = (int) ((((float) (distance - size)) / ((float) numMatchConstraints)) + 0.5f);
                int appliedLimits = 0;
                int i7 = 0;
                while (i7 < count) {
                    WidgetRun run2 = chainRun.widgets.get(i7);
                    if (run2.widget.getVisibility() == 8) {
                        position5 = position6;
                        isInRtl2 = isInRtl3;
                        size2 = size;
                        matchConstraintsDimension = matchConstraintsDimension2;
                    } else if (run2.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || run2.dimension.resolved) {
                        position5 = position6;
                        isInRtl2 = isInRtl3;
                        size2 = size;
                        matchConstraintsDimension = matchConstraintsDimension2;
                    } else {
                        int dimension3 = matchConstraintsDimension2;
                        if (weights > 0.0f) {
                            int i8 = dimension3;
                            dimension = (int) (((((float) (distance - size)) * run2.widget.mWeight[chainRun.orientation]) / weights) + 0.5f);
                        } else {
                            dimension = dimension3;
                        }
                        if (chainRun.orientation == 0) {
                            int max = run2.widget.mMatchConstraintMaxWidth;
                            size2 = size;
                            int min = run2.widget.mMatchConstraintMinWidth;
                            int value2 = dimension;
                            matchConstraintsDimension = matchConstraintsDimension2;
                            position5 = position6;
                            if (run2.matchConstraintsType == 1) {
                                value = Math.min(value2, run2.dimension.wrapValue);
                            } else {
                                value = value2;
                            }
                            int value3 = Math.max(min, value);
                            if (max > 0) {
                                value3 = Math.min(max, value3);
                            }
                            if (value3 != dimension) {
                                appliedLimits++;
                                dimension = value3;
                            }
                            isInRtl2 = isInRtl3;
                        } else {
                            position5 = position6;
                            size2 = size;
                            matchConstraintsDimension = matchConstraintsDimension2;
                            int max2 = run2.widget.mMatchConstraintMaxHeight;
                            int min2 = run2.widget.mMatchConstraintMinHeight;
                            int value4 = dimension;
                            isInRtl2 = isInRtl3;
                            if (run2.matchConstraintsType == 1) {
                                value4 = Math.min(value4, run2.dimension.wrapValue);
                            }
                            int value5 = Math.max(min2, value4);
                            if (max2 > 0) {
                                value5 = Math.min(max2, value5);
                            }
                            if (value5 != dimension) {
                                appliedLimits++;
                                dimension = value5;
                            }
                        }
                        run2.dimension.resolve(dimension);
                    }
                    i7++;
                    size = size2;
                    isInRtl3 = isInRtl2;
                    matchConstraintsDimension2 = matchConstraintsDimension;
                    position6 = position5;
                }
                position = position6;
                isInRtl = isInRtl3;
                int size5 = size;
                int i9 = matchConstraintsDimension2;
                if (appliedLimits > 0) {
                    numMatchConstraints -= appliedLimits;
                    int size6 = 0;
                    for (int i10 = 0; i10 < count; i10++) {
                        WidgetRun run3 = chainRun.widgets.get(i10);
                        if (run3.widget.getVisibility() != 8) {
                            if (i10 > 0 && i10 >= firstVisibleWidget) {
                                size6 += run3.start.margin;
                            }
                            size6 += run3.dimension.value;
                            if (i10 < count - 1 && i10 < lastVisibleWidget) {
                                size6 += -run3.end.margin;
                            }
                        }
                    }
                    size = size6;
                } else {
                    size = size5;
                }
                if (chainRun.chainStyle == 2 && appliedLimits == 0) {
                    chainRun.chainStyle = 0;
                }
            } else {
                position = position6;
                isInRtl = isInRtl3;
                int i11 = size;
            }
            if (size > distance) {
                i2 = 2;
                chainRun.chainStyle = 2;
            } else {
                i2 = 2;
            }
            if (numVisibleWidgets > 0 && numMatchConstraints == 0 && firstVisibleWidget == lastVisibleWidget) {
                chainRun.chainStyle = i2;
            }
            int i12 = chainRun.chainStyle;
            if (i12 == 1) {
                int gap = 0;
                if (numVisibleWidgets > 1) {
                    gap = (distance - size) / (numVisibleWidgets - 1);
                } else if (numVisibleWidgets == 1) {
                    gap = (distance - size) / 2;
                }
                if (numMatchConstraints > 0) {
                    gap = 0;
                }
                int position7 = position;
                for (int i13 = 0; i13 < count; i13++) {
                    int index = i13;
                    if (isInRtl) {
                        index = count - (i13 + 1);
                    }
                    WidgetRun run4 = chainRun.widgets.get(index);
                    if (run4.widget.getVisibility() == 8) {
                        run4.start.resolve(position7);
                        run4.end.resolve(position7);
                    } else {
                        if (i13 > 0) {
                            if (isInRtl) {
                                position7 -= gap;
                            } else {
                                position7 += gap;
                            }
                        }
                        if (i13 > 0 && i13 >= firstVisibleWidget) {
                            if (isInRtl) {
                                position7 -= run4.start.margin;
                            } else {
                                position7 += run4.start.margin;
                            }
                        }
                        if (isInRtl) {
                            run4.end.resolve(position7);
                        } else {
                            run4.start.resolve(position7);
                        }
                        int dimension4 = run4.dimension.value;
                        if (run4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && run4.matchConstraintsType == 1) {
                            dimension4 = run4.dimension.wrapValue;
                        }
                        if (isInRtl) {
                            position7 -= dimension4;
                        } else {
                            position7 += dimension4;
                        }
                        if (isInRtl) {
                            run4.start.resolve(position7);
                        } else {
                            run4.end.resolve(position7);
                        }
                        run4.resolved = true;
                        if (i13 < count - 1 && i13 < lastVisibleWidget) {
                            if (isInRtl) {
                                position7 -= -run4.end.margin;
                            } else {
                                position7 += -run4.end.margin;
                            }
                        }
                    }
                }
            } else if (i12 == 0) {
                int gap2 = (distance - size) / (numVisibleWidgets + 1);
                if (numMatchConstraints > 0) {
                    gap2 = 0;
                }
                int position8 = position;
                for (int i14 = 0; i14 < count; i14++) {
                    int index2 = i14;
                    if (isInRtl) {
                        index2 = count - (i14 + 1);
                    }
                    WidgetRun run5 = chainRun.widgets.get(index2);
                    if (run5.widget.getVisibility() == 8) {
                        run5.start.resolve(position8);
                        run5.end.resolve(position8);
                    } else {
                        if (isInRtl) {
                            position4 = position8 - gap2;
                        } else {
                            position4 = position8 + gap2;
                        }
                        if (i14 > 0 && i14 >= firstVisibleWidget) {
                            if (isInRtl) {
                                position4 -= run5.start.margin;
                            } else {
                                position4 += run5.start.margin;
                            }
                        }
                        if (isInRtl) {
                            run5.end.resolve(position4);
                        } else {
                            run5.start.resolve(position4);
                        }
                        int dimension5 = run5.dimension.value;
                        if (run5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && run5.matchConstraintsType == 1) {
                            dimension5 = Math.min(dimension5, run5.dimension.wrapValue);
                        }
                        if (isInRtl) {
                            position8 = position4 - dimension5;
                        } else {
                            position8 = position4 + dimension5;
                        }
                        if (isInRtl) {
                            run5.start.resolve(position8);
                        } else {
                            run5.end.resolve(position8);
                        }
                        if (i14 < count - 1 && i14 < lastVisibleWidget) {
                            if (isInRtl) {
                                position8 -= -run5.end.margin;
                            } else {
                                position8 += -run5.end.margin;
                            }
                        }
                    }
                }
            } else if (i12 == 2) {
                if (chainRun.orientation == 0) {
                    bias = chainRun.widget.getHorizontalBiasPercent();
                } else {
                    bias = chainRun.widget.getVerticalBiasPercent();
                }
                if (isInRtl) {
                    bias = 1.0f - bias;
                }
                int gap3 = (int) ((((float) (distance - size)) * bias) + 0.5f);
                if (gap3 < 0 || numMatchConstraints > 0) {
                    gap3 = 0;
                }
                if (isInRtl) {
                    position2 = position - gap3;
                } else {
                    position2 = position + gap3;
                }
                int i15 = 0;
                while (i15 < count) {
                    int index3 = i15;
                    if (isInRtl) {
                        index3 = count - (i15 + 1);
                    }
                    WidgetRun run6 = chainRun.widgets.get(index3);
                    if (run6.widget.getVisibility() == 8) {
                        run6.start.resolve(position2);
                        run6.end.resolve(position2);
                    } else {
                        if (i15 > 0 && i15 >= firstVisibleWidget) {
                            if (isInRtl) {
                                position2 -= run6.start.margin;
                            } else {
                                position2 += run6.start.margin;
                            }
                        }
                        if (isInRtl) {
                            run6.end.resolve(position2);
                        } else {
                            run6.start.resolve(position2);
                        }
                        int dimension6 = run6.dimension.value;
                        if (run6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            if (run6.matchConstraintsType == 1) {
                                dimension6 = run6.dimension.wrapValue;
                            }
                        }
                        if (isInRtl) {
                            position3 = position2 - dimension6;
                        } else {
                            position3 = position2 + dimension6;
                        }
                        if (isInRtl) {
                            run6.start.resolve(position2);
                        } else {
                            run6.end.resolve(position2);
                        }
                        if (i15 < count - 1 && i15 < lastVisibleWidget) {
                            if (isInRtl) {
                                position2 -= -run6.end.margin;
                            } else {
                                position2 += -run6.end.margin;
                            }
                        }
                    }
                    i15++;
                    chainRun = this;
                }
            }
        }
    }

    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            WidgetRun run = this.widgets.get(i);
            if (run.widget.getVisibility() != 8) {
                return run.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int i = this.widgets.size() - 1; i >= 0; i--) {
            WidgetRun run = this.widgets.get(i);
            if (run.widget.getVisibility() != 8) {
                return run.widget;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int count = this.widgets.size();
        if (count >= 1) {
            ConstraintWidget firstWidget = this.widgets.get(0).widget;
            ConstraintWidget lastWidget = this.widgets.get(count - 1).widget;
            if (this.orientation == 0) {
                ConstraintAnchor startAnchor = firstWidget.mLeft;
                ConstraintAnchor endAnchor = lastWidget.mRight;
                DependencyNode startTarget = getTarget(startAnchor, 0);
                int startMargin = startAnchor.getMargin();
                ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
                if (firstVisibleWidget != null) {
                    startMargin = firstVisibleWidget.mLeft.getMargin();
                }
                if (startTarget != null) {
                    addTarget(this.start, startTarget, startMargin);
                }
                DependencyNode endTarget = getTarget(endAnchor, 0);
                int endMargin = endAnchor.getMargin();
                ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
                if (lastVisibleWidget != null) {
                    endMargin = lastVisibleWidget.mRight.getMargin();
                }
                if (endTarget != null) {
                    addTarget(this.end, endTarget, -endMargin);
                }
            } else {
                ConstraintAnchor startAnchor2 = firstWidget.mTop;
                ConstraintAnchor endAnchor2 = lastWidget.mBottom;
                DependencyNode startTarget2 = getTarget(startAnchor2, 1);
                int startMargin2 = startAnchor2.getMargin();
                ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
                if (firstVisibleWidget2 != null) {
                    startMargin2 = firstVisibleWidget2.mTop.getMargin();
                }
                if (startTarget2 != null) {
                    addTarget(this.start, startTarget2, startMargin2);
                }
                DependencyNode endTarget2 = getTarget(endAnchor2, 1);
                int endMargin2 = endAnchor2.getMargin();
                ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
                if (lastVisibleWidget2 != null) {
                    endMargin2 = lastVisibleWidget2.mBottom.getMargin();
                }
                if (endTarget2 != null) {
                    addTarget(this.end, endTarget2, -endMargin2);
                }
            }
            this.start.updateDelegate = this;
            this.end.updateDelegate = this;
        }
    }
}
