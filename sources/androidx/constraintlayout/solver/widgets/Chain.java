package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem system, int orientation) {
        ChainHead[] chainsArray;
        int chainsSize;
        int offset;
        if (orientation == 0) {
            offset = 0;
            chainsSize = constraintWidgetContainer.mHorizontalChainsSize;
            chainsArray = constraintWidgetContainer.mHorizontalChainsArray;
        } else {
            offset = 2;
            chainsSize = constraintWidgetContainer.mVerticalChainsSize;
            chainsArray = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i = 0; i < chainsSize; i++) {
            ChainHead first = chainsArray[i];
            first.define();
            applyChainConstraints(constraintWidgetContainer, system, orientation, offset, first);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:299:0x066c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0680  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0685  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x068c  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0691  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0694  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x06ac  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x06b0  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x06bc  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x06bf A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r45, androidx.constraintlayout.solver.LinearSystem r46, int r47, int r48, androidx.constraintlayout.solver.widgets.ChainHead r49) {
        /*
            r0 = r45
            r10 = r46
            r11 = r49
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r11.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r11.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r11.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = r11.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r11.mHead
            r1 = r12
            r2 = 0
            r3 = 0
            float r4 = r11.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r11.mFirstMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r11.mLastMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r0.mListDimensionBehaviors
            r5 = r5[r47]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r16 = r1
            if (r5 != r6) goto L_0x0025
            r5 = 1
            goto L_0x0026
        L_0x0025:
            r5 = 0
        L_0x0026:
            r18 = r5
            r5 = 0
            r6 = 0
            r19 = 0
            if (r47 != 0) goto L_0x0052
            int r1 = r9.mHorizontalChainStyle
            if (r1 != 0) goto L_0x0034
            r1 = 1
            goto L_0x0035
        L_0x0034:
            r1 = 0
        L_0x0035:
            int r5 = r9.mHorizontalChainStyle
            r22 = r1
            r1 = 1
            if (r5 != r1) goto L_0x003e
            r1 = 1
            goto L_0x003f
        L_0x003e:
            r1 = 0
        L_0x003f:
            int r5 = r9.mHorizontalChainStyle
            r6 = 2
            if (r5 != r6) goto L_0x0046
            r5 = 1
            goto L_0x0047
        L_0x0046:
            r5 = 0
        L_0x0047:
            r21 = r1
            r23 = r2
            r19 = r5
            r6 = r16
            r16 = r3
            goto L_0x0075
        L_0x0052:
            int r1 = r9.mVerticalChainStyle
            if (r1 != 0) goto L_0x0058
            r1 = 1
            goto L_0x0059
        L_0x0058:
            r1 = 0
        L_0x0059:
            int r5 = r9.mVerticalChainStyle
            r22 = r1
            r1 = 1
            if (r5 != r1) goto L_0x0062
            r1 = 1
            goto L_0x0063
        L_0x0062:
            r1 = 0
        L_0x0063:
            int r5 = r9.mVerticalChainStyle
            r6 = 2
            if (r5 != r6) goto L_0x006a
            r5 = 1
            goto L_0x006b
        L_0x006a:
            r5 = 0
        L_0x006b:
            r21 = r1
            r23 = r2
            r19 = r5
            r6 = r16
            r16 = r3
        L_0x0075:
            if (r16 != 0) goto L_0x016a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r6.mListAnchors
            r3 = r3[r48]
            r24 = 4
            if (r19 == 0) goto L_0x0081
            r24 = 1
        L_0x0081:
            int r25 = r3.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r6.mListDimensionBehaviors
            r1 = r1[r47]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r5) goto L_0x0095
            int[] r1 = r6.mResolvedMatchConstraintDefault
            r1 = r1[r47]
            if (r1 != 0) goto L_0x0095
            r1 = 1
            goto L_0x0096
        L_0x0095:
            r1 = 0
        L_0x0096:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.mTarget
            if (r5 == 0) goto L_0x00a7
            if (r6 == r12) goto L_0x00a7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.mTarget
            int r5 = r5.getMargin()
            int r25 = r25 + r5
            r5 = r25
            goto L_0x00a9
        L_0x00a7:
            r5 = r25
        L_0x00a9:
            if (r19 == 0) goto L_0x00b1
            if (r6 == r12) goto L_0x00b1
            if (r6 == r14) goto L_0x00b1
            r24 = 5
        L_0x00b1:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r3.mTarget
            if (r2 == 0) goto L_0x00e7
            if (r6 != r14) goto L_0x00c6
            androidx.constraintlayout.solver.SolverVariable r2 = r3.mSolverVariable
            r28 = r4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r29 = r7
            r7 = 6
            r10.addGreaterThan(r2, r4, r5, r7)
            goto L_0x00d5
        L_0x00c6:
            r28 = r4
            r29 = r7
            androidx.constraintlayout.solver.SolverVariable r2 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r7 = 8
            r10.addGreaterThan(r2, r4, r5, r7)
        L_0x00d5:
            if (r1 == 0) goto L_0x00db
            if (r19 != 0) goto L_0x00db
            r2 = 5
            goto L_0x00dd
        L_0x00db:
            r2 = r24
        L_0x00dd:
            androidx.constraintlayout.solver.SolverVariable r4 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            r10.addEquality(r4, r7, r5, r2)
            goto L_0x00ed
        L_0x00e7:
            r28 = r4
            r29 = r7
            r2 = r24
        L_0x00ed:
            if (r18 == 0) goto L_0x012e
            int r4 = r6.getVisibility()
            r7 = 8
            if (r4 == r7) goto L_0x0117
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r6.mListDimensionBehaviors
            r4 = r4[r47]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r7) goto L_0x0117
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r6.mListAnchors
            int r7 = r48 + 1
            r4 = r4[r7]
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r6.mListAnchors
            r7 = r7[r48]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            r24 = r1
            r25 = r2
            r1 = 5
            r2 = 0
            r10.addGreaterThan(r4, r7, r2, r1)
            goto L_0x011b
        L_0x0117:
            r24 = r1
            r25 = r2
        L_0x011b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r6.mListAnchors
            r1 = r1[r48]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r0.mListAnchors
            r2 = r2[r48]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            r4 = 8
            r7 = 0
            r10.addGreaterThan(r1, r2, r7, r4)
            goto L_0x0132
        L_0x012e:
            r24 = r1
            r25 = r2
        L_0x0132:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r6.mListAnchors
            int r2 = r48 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x0158
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r1.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r2.mListAnchors
            r4 = r4[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x0154
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r2.mListAnchors
            r4 = r4[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r4.mOwner
            if (r4 == r6) goto L_0x0151
            goto L_0x0154
        L_0x0151:
            r23 = r2
            goto L_0x015b
        L_0x0154:
            r2 = 0
            r23 = r2
            goto L_0x015b
        L_0x0158:
            r2 = 0
            r23 = r2
        L_0x015b:
            if (r23 == 0) goto L_0x0161
            r2 = r23
            r6 = r2
            goto L_0x0164
        L_0x0161:
            r2 = 1
            r16 = r2
        L_0x0164:
            r4 = r28
            r7 = r29
            goto L_0x0075
        L_0x016a:
            r28 = r4
            r29 = r7
            if (r15 == 0) goto L_0x01d7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x01d7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r15.mListDimensionBehaviors
            r3 = r3[r47]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x0190
            int[] r3 = r15.mResolvedMatchConstraintDefault
            r3 = r3[r47]
            if (r3 != 0) goto L_0x0190
            r3 = 1
            goto L_0x0191
        L_0x0190:
            r3 = 0
        L_0x0191:
            if (r3 == 0) goto L_0x01ab
            if (r19 != 0) goto L_0x01ab
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r4.mOwner
            if (r4 != r0) goto L_0x01ab
            androidx.constraintlayout.solver.SolverVariable r4 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            int r7 = r2.getMargin()
            int r7 = -r7
            r1 = 5
            r10.addEquality(r4, r5, r7, r1)
            goto L_0x01c2
        L_0x01ab:
            if (r19 == 0) goto L_0x01c2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r1.mOwner
            if (r1 != r0) goto L_0x01c2
            androidx.constraintlayout.solver.SolverVariable r1 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            int r5 = r2.getMargin()
            int r5 = -r5
            r7 = 4
            r10.addEquality(r1, r4, r5, r7)
        L_0x01c2:
            androidx.constraintlayout.solver.SolverVariable r1 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r13.mListAnchors
            int r5 = r48 + 1
            r4 = r4[r5]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            int r5 = r2.getMargin()
            int r5 = -r5
            r7 = 6
            r10.addLowerThan(r1, r4, r5, r7)
        L_0x01d7:
            if (r18 == 0) goto L_0x01f8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r0.mListAnchors
            int r2 = r48 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            int r4 = r48 + 1
            r3 = r3[r4]
            int r3 = r3.getMargin()
            r4 = 8
            r10.addGreaterThan(r1, r2, r3, r4)
        L_0x01f8:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r7 = r11.mWeightedMatchConstraintsWidgets
            if (r7 == 0) goto L_0x02e0
            int r1 = r7.size()
            r2 = 1
            if (r1 <= r2) goto L_0x02d7
            r3 = 0
            r4 = 0
            boolean r5 = r11.mHasUndefinedWeights
            if (r5 == 0) goto L_0x0212
            boolean r5 = r11.mHasComplexMatchWeights
            if (r5 != 0) goto L_0x0212
            int r5 = r11.mWidgetsMatchCount
            float r5 = (float) r5
            r28 = r5
        L_0x0212:
            r5 = 0
        L_0x0213:
            if (r5 >= r1) goto L_0x02cc
            java.lang.Object r20 = r7.get(r5)
            r2 = r20
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r2
            float[] r0 = r2.mWeight
            r0 = r0[r47]
            r20 = 0
            int r26 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r26 >= 0) goto L_0x0255
            r26 = r0
            boolean r0 = r11.mHasComplexMatchWeights
            if (r0 == 0) goto L_0x024b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r2.mListAnchors
            int r20 = r48 + 1
            r0 = r0[r20]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r38 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r2.mListAnchors
            r1 = r1[r48]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            r39 = r6
            r24 = r7
            r6 = 4
            r7 = 0
            r10.addEquality(r0, r1, r7, r6)
            r17 = r8
            r8 = 0
            goto L_0x02bd
        L_0x024b:
            r38 = r1
            r39 = r6
            r24 = r7
            r6 = 4
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x025e
        L_0x0255:
            r26 = r0
            r38 = r1
            r39 = r6
            r24 = r7
            r6 = 4
        L_0x025e:
            int r1 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r1 != 0) goto L_0x0279
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r2.mListAnchors
            int r7 = r48 + 1
            r1 = r1[r7]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r2.mListAnchors
            r7 = r7[r48]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            r17 = r8
            r6 = 8
            r8 = 0
            r10.addEquality(r1, r7, r8, r6)
            goto L_0x02bd
        L_0x0279:
            r17 = r8
            r8 = 0
            if (r3 == 0) goto L_0x02b7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r3.mListAnchors
            r1 = r1[r48]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r3.mListAnchors
            int r7 = r48 + 1
            r6 = r6[r7]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r2.mListAnchors
            r7 = r7[r48]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            int r30 = r48 + 1
            r8 = r8[r30]
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            r40 = r3
            androidx.constraintlayout.solver.ArrayRow r3 = r46.createRow()
            r30 = r3
            r31 = r4
            r32 = r28
            r33 = r0
            r34 = r1
            r35 = r6
            r36 = r7
            r37 = r8
            r30.createRowEqualMatchDimensions(r31, r32, r33, r34, r35, r36, r37)
            r10.addConstraint(r3)
            goto L_0x02b9
        L_0x02b7:
            r40 = r3
        L_0x02b9:
            r1 = r2
            r3 = r0
            r4 = r3
            r3 = r1
        L_0x02bd:
            int r5 = r5 + 1
            r2 = 1
            r0 = r45
            r8 = r17
            r7 = r24
            r1 = r38
            r6 = r39
            goto L_0x0213
        L_0x02cc:
            r38 = r1
            r40 = r3
            r39 = r6
            r24 = r7
            r17 = r8
            goto L_0x02e6
        L_0x02d7:
            r38 = r1
            r39 = r6
            r24 = r7
            r17 = r8
            goto L_0x02e6
        L_0x02e0:
            r39 = r6
            r24 = r7
            r17 = r8
        L_0x02e6:
            if (r14 == 0) goto L_0x0378
            if (r14 == r15) goto L_0x02f9
            if (r19 == 0) goto L_0x02ed
            goto L_0x02f9
        L_0x02ed:
            r35 = r9
            r32 = r39
            r44 = r29
            r29 = r24
            r24 = r44
            goto L_0x0382
        L_0x02f9:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            if (r3 == 0) goto L_0x030c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x030d
        L_0x030c:
            r3 = 0
        L_0x030d:
            r20 = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r2.mTarget
            if (r3 == 0) goto L_0x0318
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0319
        L_0x0318:
            r3 = 0
        L_0x0319:
            r25 = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            r8 = r3[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            int r3 = r48 + 1
            r7 = r1[r3]
            if (r20 == 0) goto L_0x0368
            if (r25 == 0) goto L_0x0368
            r1 = 1056964608(0x3f000000, float:0.5)
            if (r47 != 0) goto L_0x0332
            float r1 = r9.mHorizontalBiasPercent
            r26 = r1
            goto L_0x0336
        L_0x0332:
            float r1 = r9.mVerticalBiasPercent
            r26 = r1
        L_0x0336:
            int r27 = r8.getMargin()
            int r30 = r7.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r8.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r6 = r7.mSolverVariable
            r31 = 7
            r1 = r46
            r3 = r20
            r4 = r27
            r5 = r26
            r33 = r6
            r32 = r39
            r6 = r25
            r34 = r7
            r44 = r29
            r29 = r24
            r24 = r44
            r7 = r33
            r33 = r8
            r8 = r30
            r35 = r9
            r9 = r31
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0376
        L_0x0368:
            r34 = r7
            r33 = r8
            r35 = r9
            r32 = r39
            r44 = r29
            r29 = r24
            r24 = r44
        L_0x0376:
            goto L_0x066a
        L_0x0378:
            r35 = r9
            r32 = r39
            r44 = r29
            r29 = r24
            r24 = r44
        L_0x0382:
            if (r22 == 0) goto L_0x04d1
            if (r14 == 0) goto L_0x04d1
            r1 = r14
            r2 = r14
            int r3 = r11.mWidgetsMatchCount
            if (r3 <= 0) goto L_0x0395
            int r3 = r11.mWidgetsCount
            int r4 = r11.mWidgetsMatchCount
            if (r3 != r4) goto L_0x0395
            r25 = 1
            goto L_0x0397
        L_0x0395:
            r25 = 0
        L_0x0397:
            r20 = r25
            r9 = r1
            r8 = r2
        L_0x039b:
            if (r9 == 0) goto L_0x04c9
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r9.mNextChainWidget
            r1 = r1[r47]
            r7 = r1
        L_0x03a2:
            if (r7 == 0) goto L_0x03b1
            int r1 = r7.getVisibility()
            r5 = 8
            if (r1 != r5) goto L_0x03b3
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r7.mNextChainWidget
            r7 = r1[r47]
            goto L_0x03a2
        L_0x03b1:
            r5 = 8
        L_0x03b3:
            if (r7 != 0) goto L_0x03c1
            if (r9 != r15) goto L_0x03b8
            goto L_0x03c1
        L_0x03b8:
            r0 = r5
            r39 = r7
            r40 = r8
            r41 = r9
            goto L_0x04b7
        L_0x03c1:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r9.mListAnchors
            r6 = r1[r48]
            androidx.constraintlayout.solver.SolverVariable r4 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            if (r1 == 0) goto L_0x03d0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            goto L_0x03d1
        L_0x03d0:
            r1 = 0
        L_0x03d1:
            if (r8 == r9) goto L_0x03de
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r8.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r1 = r2.mSolverVariable
            r23 = r1
            goto L_0x03fa
        L_0x03de:
            if (r9 != r14) goto L_0x03f8
            if (r8 != r9) goto L_0x03f8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            r2 = r2[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x03f3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            r2 = r2[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x03f4
        L_0x03f3:
            r2 = 0
        L_0x03f4:
            r1 = r2
            r23 = r1
            goto L_0x03fa
        L_0x03f8:
            r23 = r1
        L_0x03fa:
            r1 = 0
            r2 = 0
            r3 = 0
            int r25 = r6.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r9.mListAnchors
            int r26 = r48 + 1
            r0 = r0[r26]
            int r0 = r0.getMargin()
            if (r7 == 0) goto L_0x0422
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r1 = r5[r48]
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r9.mListAnchors
            int r30 = r48 + 1
            r5 = r5[r30]
            androidx.constraintlayout.solver.SolverVariable r3 = r5.mSolverVariable
            r30 = r1
            r31 = r2
            r32 = r3
            goto L_0x043c
        L_0x0422:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r13.mListAnchors
            int r30 = r48 + 1
            r5 = r5[r30]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r5.mTarget
            if (r1 == 0) goto L_0x042e
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
        L_0x042e:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r9.mListAnchors
            int r30 = r48 + 1
            r5 = r5[r30]
            androidx.constraintlayout.solver.SolverVariable r3 = r5.mSolverVariable
            r30 = r1
            r31 = r2
            r32 = r3
        L_0x043c:
            if (r30 == 0) goto L_0x0443
            int r1 = r30.getMargin()
            int r0 = r0 + r1
        L_0x0443:
            if (r8 == 0) goto L_0x0451
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            int r2 = r48 + 1
            r1 = r1[r2]
            int r1 = r1.getMargin()
            int r25 = r25 + r1
        L_0x0451:
            if (r4 == 0) goto L_0x04a9
            if (r23 == 0) goto L_0x04a9
            if (r31 == 0) goto L_0x04a9
            if (r32 == 0) goto L_0x04a9
            r1 = r25
            if (r9 != r14) goto L_0x0468
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            r2 = r2[r48]
            int r1 = r2.getMargin()
            r33 = r1
            goto L_0x046a
        L_0x0468:
            r33 = r1
        L_0x046a:
            r1 = r0
            if (r9 != r15) goto L_0x047a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            int r1 = r2.getMargin()
            r34 = r1
            goto L_0x047c
        L_0x047a:
            r34 = r1
        L_0x047c:
            r1 = 5
            if (r20 == 0) goto L_0x0484
            r1 = 8
            r36 = r1
            goto L_0x0486
        L_0x0484:
            r36 = r1
        L_0x0486:
            r5 = 1056964608(0x3f000000, float:0.5)
            r1 = r46
            r2 = r4
            r3 = r23
            r37 = r4
            r4 = r33
            r38 = r0
            r0 = 8
            r26 = r6
            r6 = r31
            r39 = r7
            r7 = r32
            r40 = r8
            r8 = r34
            r41 = r9
            r9 = r36
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x04b7
        L_0x04a9:
            r38 = r0
            r37 = r4
            r26 = r6
            r39 = r7
            r40 = r8
            r41 = r9
            r0 = 8
        L_0x04b7:
            int r1 = r41.getVisibility()
            if (r1 == r0) goto L_0x04c1
            r1 = r41
            r8 = r1
            goto L_0x04c3
        L_0x04c1:
            r8 = r40
        L_0x04c3:
            r9 = r39
            r23 = r39
            goto L_0x039b
        L_0x04c9:
            r40 = r8
            r41 = r9
            r32 = r41
            goto L_0x066a
        L_0x04d1:
            r0 = 8
            if (r21 == 0) goto L_0x066a
            if (r14 == 0) goto L_0x066a
            r1 = r14
            r2 = r14
            int r3 = r11.mWidgetsMatchCount
            if (r3 <= 0) goto L_0x04e6
            int r3 = r11.mWidgetsCount
            int r4 = r11.mWidgetsMatchCount
            if (r3 != r4) goto L_0x04e6
            r25 = 1
            goto L_0x04e8
        L_0x04e6:
            r25 = 0
        L_0x04e8:
            r20 = r25
            r9 = r1
            r8 = r2
        L_0x04ec:
            if (r9 == 0) goto L_0x05d9
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r9.mNextChainWidget
            r1 = r1[r47]
        L_0x04f2:
            if (r1 == 0) goto L_0x04ff
            int r2 = r1.getVisibility()
            if (r2 != r0) goto L_0x04ff
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r2 = r1.mNextChainWidget
            r1 = r2[r47]
            goto L_0x04f2
        L_0x04ff:
            if (r9 == r14) goto L_0x05c0
            if (r9 == r15) goto L_0x05c0
            if (r1 == 0) goto L_0x05c0
            if (r1 != r15) goto L_0x050a
            r1 = 0
            r7 = r1
            goto L_0x050b
        L_0x050a:
            r7 = r1
        L_0x050b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r9.mListAnchors
            r6 = r1[r48]
            androidx.constraintlayout.solver.SolverVariable r5 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            if (r1 == 0) goto L_0x051a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            goto L_0x051b
        L_0x051a:
            r1 = 0
        L_0x051b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r8.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r4 = r2.mSolverVariable
            r1 = 0
            r2 = 0
            r3 = 0
            int r23 = r6.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r9.mListAnchors
            int r25 = r48 + 1
            r0 = r0[r25]
            int r0 = r0.getMargin()
            if (r7 == 0) goto L_0x0551
            r25 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r7.mListAnchors
            r1 = r1[r48]
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
            r25 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 == 0) goto L_0x0549
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x054a
        L_0x0549:
            r2 = 0
        L_0x054a:
            r31 = r2
            r30 = r25
            r25 = r1
            goto L_0x0569
        L_0x0551:
            r25 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            r1 = r1[r48]
            if (r1 == 0) goto L_0x055b
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
        L_0x055b:
            r25 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r9.mListAnchors
            int r30 = r48 + 1
            r1 = r1[r30]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            r31 = r1
            r30 = r2
        L_0x0569:
            if (r25 == 0) goto L_0x0570
            int r1 = r25.getMargin()
            int r0 = r0 + r1
        L_0x0570:
            if (r8 == 0) goto L_0x057e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            int r2 = r48 + 1
            r1 = r1[r2]
            int r1 = r1.getMargin()
            int r23 = r23 + r1
        L_0x057e:
            r1 = 4
            if (r20 == 0) goto L_0x0586
            r1 = 8
            r32 = r1
            goto L_0x0588
        L_0x0586:
            r32 = r1
        L_0x0588:
            if (r5 == 0) goto L_0x05b1
            if (r4 == 0) goto L_0x05b1
            if (r30 == 0) goto L_0x05b1
            if (r31 == 0) goto L_0x05b1
            r33 = 1056964608(0x3f000000, float:0.5)
            r1 = r46
            r2 = r5
            r3 = r4
            r34 = r4
            r4 = r23
            r36 = r5
            r5 = r33
            r33 = r6
            r6 = r30
            r37 = r7
            r7 = r31
            r38 = r8
            r8 = r0
            r39 = r9
            r9 = r32
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x05bd
        L_0x05b1:
            r34 = r4
            r36 = r5
            r33 = r6
            r37 = r7
            r38 = r8
            r39 = r9
        L_0x05bd:
            r23 = r37
            goto L_0x05c6
        L_0x05c0:
            r38 = r8
            r39 = r9
            r23 = r1
        L_0x05c6:
            int r0 = r39.getVisibility()
            r1 = 8
            if (r0 == r1) goto L_0x05d2
            r0 = r39
            r8 = r0
            goto L_0x05d4
        L_0x05d2:
            r8 = r38
        L_0x05d4:
            r9 = r23
            r0 = r1
            goto L_0x04ec
        L_0x05d9:
            r38 = r8
            r39 = r9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r1.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            int r2 = r48 + 1
            r8 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            int r2 = r48 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r1.mTarget
            r6 = 5
            if (r9 == 0) goto L_0x0645
            if (r14 == r15) goto L_0x060e
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r2 = r9.mSolverVariable
            int r3 = r0.getMargin()
            r10.addEquality(r1, r2, r3, r6)
            r31 = r6
            r42 = r7
            r43 = r8
            r25 = r9
            goto L_0x064d
        L_0x060e:
            if (r7 == 0) goto L_0x063c
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r3 = r9.mSolverVariable
            int r4 = r0.getMargin()
            androidx.constraintlayout.solver.SolverVariable r1 = r8.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r5 = r7.mSolverVariable
            int r26 = r8.getMargin()
            r30 = r1
            r1 = r46
            r25 = r5
            r5 = 1056964608(0x3f000000, float:0.5)
            r31 = r6
            r6 = r30
            r42 = r7
            r7 = r25
            r43 = r8
            r8 = r26
            r25 = r9
            r9 = r31
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x064d
        L_0x063c:
            r31 = r6
            r42 = r7
            r43 = r8
            r25 = r9
            goto L_0x064d
        L_0x0645:
            r31 = r6
            r42 = r7
            r43 = r8
            r25 = r9
        L_0x064d:
            r1 = r42
            if (r1 == 0) goto L_0x0664
            if (r14 == r15) goto L_0x0664
            r2 = r43
            androidx.constraintlayout.solver.SolverVariable r3 = r2.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r4 = r1.mSolverVariable
            int r5 = r2.getMargin()
            int r5 = -r5
            r6 = r31
            r10.addEquality(r3, r4, r5, r6)
            goto L_0x0668
        L_0x0664:
            r6 = r31
            r2 = r43
        L_0x0668:
            r32 = r39
        L_0x066a:
            if (r22 != 0) goto L_0x066e
            if (r21 == 0) goto L_0x06f1
        L_0x066e:
            if (r14 == 0) goto L_0x06f1
            if (r14 == r15) goto L_0x06f1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            int r2 = r48 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x0685
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0686
        L_0x0685:
            r2 = 0
        L_0x0686:
            r20 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 == 0) goto L_0x0691
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0692
        L_0x0691:
            r2 = 0
        L_0x0692:
            if (r13 == r15) goto L_0x06ac
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            int r4 = r48 + 1
            r3 = r3[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.mTarget
            if (r4 == 0) goto L_0x06a5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r27 = r4
            goto L_0x06a7
        L_0x06a5:
            r27 = 0
        L_0x06a7:
            r2 = r27
            r25 = r2
            goto L_0x06ae
        L_0x06ac:
            r25 = r2
        L_0x06ae:
            if (r14 != r15) goto L_0x06bc
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            r0 = r2[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            int r3 = r48 + 1
            r1 = r2[r3]
            r9 = r1
            goto L_0x06bd
        L_0x06bc:
            r9 = r1
        L_0x06bd:
            if (r20 == 0) goto L_0x06ef
            if (r25 == 0) goto L_0x06ef
            r26 = 1056964608(0x3f000000, float:0.5)
            int r27 = r0.getMargin()
            if (r15 != 0) goto L_0x06cb
            r1 = r13
            r15 = r1
        L_0x06cb:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            int r2 = r48 + 1
            r1 = r1[r2]
            int r30 = r1.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r7 = r9.mSolverVariable
            r31 = 5
            r1 = r46
            r3 = r20
            r4 = r27
            r5 = r26
            r6 = r25
            r8 = r30
            r33 = r9
            r9 = r31
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x06f1
        L_0x06ef:
            r33 = r9
        L_0x06f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
