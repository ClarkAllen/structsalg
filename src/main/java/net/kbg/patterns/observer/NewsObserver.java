package net.kbg.patterns.observer;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Stack;

@Slf4j
public class NewsObserver implements PropertyChangeListener {

    private Stack<String> newsUpdates;

    public NewsObserver() {
        newsUpdates = new Stack<>();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        newsUpdates.push(evt.getNewValue().toString());
        log.info("Breaking News : " + evt.getNewValue().toString());
    }

    public Stack<String> getNewsUpdates() {
        return newsUpdates;
    }

}
