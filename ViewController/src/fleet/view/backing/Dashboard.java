package fleet.view.backing;

import oracle.adf.view.faces.bi.component.chart.UIBarChart;
import oracle.adf.view.faces.bi.component.chart.UIDataItem;
import oracle.adf.view.faces.bi.component.chart.UILegend;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;
import oracle.adf.view.rich.component.rich.layout.RichMasonryLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.output.RichMessages;

public class Dashboard {
    private RichPageTemplate pt1;
    private RichForm f1;
    private RichDocument d1;
    private RichPanelStretchLayout psl1;
    private RichMasonryLayout ml1;
    private RichPanelBox pb2;
    private RichPanelBox pb3;
    private RichPanelBox pb1;
    private RichPanelBox pb4;
    private UIBarChart barChart1;
    private UILegend cl1;
    private UIDataItem di1;
    private RichMessages m1;

    public void setPt1(RichPageTemplate pt1) {
        this.pt1 = pt1;
    }

    public RichPageTemplate getPt1() {
        return pt1;
    }

    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }

    public void setMl1(RichMasonryLayout ml1) {
        this.ml1 = ml1;
    }

    public RichMasonryLayout getMl1() {
        return ml1;
    }


    public void setPb2(RichPanelBox pb2) {
        this.pb2 = pb2;
    }

    public RichPanelBox getPb2() {
        return pb2;
    }

    public void setPb3(RichPanelBox pb3) {
        this.pb3 = pb3;
    }

    public RichPanelBox getPb3() {
        return pb3;
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
    }

    public void setPb4(RichPanelBox pb4) {
        this.pb4 = pb4;
    }

    public RichPanelBox getPb4() {
        return pb4;
    }


    public void setBarChart1(UIBarChart barChart1) {
        this.barChart1 = barChart1;
    }

    public UIBarChart getBarChart1() {
        return barChart1;
    }

    public void setCl1(UILegend cl1) {
        this.cl1 = cl1;
    }

    public UILegend getCl1() {
        return cl1;
    }

    public void setDi1(UIDataItem di1) {
        this.di1 = di1;
    }

    public UIDataItem getDi1() {
        return di1;
    }

    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
    }
}
