package net.kbg.patterns.observer;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.util.Stack;

@Slf4j
public class UpdateTimeObserver implements PropertyChangeListener {

    private Stack<LocalDateTime> updateTimes;

    public UpdateTimeObserver() {
        updateTimes = new Stack<>();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        updateTimes.push((LocalDateTime) evt.getNewValue());
        log.info("News Update at : " + evt.getNewValue().toString());
    }

    public Stack<LocalDateTime> getUpdateTimes() {
        return updateTimes;
    }

}
