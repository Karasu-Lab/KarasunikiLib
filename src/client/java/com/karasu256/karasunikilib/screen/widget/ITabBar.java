package com.karasu256.karasunikilib.screen.widget;

public interface ITabBar<T extends IControlWidget> extends IControlWidget {
    void addTab(T tab, ITabContent content);

    void selectTab(int index);

    ITabContent getActiveContent();
}
