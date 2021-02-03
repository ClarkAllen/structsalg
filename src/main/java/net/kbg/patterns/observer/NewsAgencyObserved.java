package net.kbg.patterns.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDateTime;

/*
    java.util.Observer is deprecated since Java 9.
        * Observer was implemented as a class and not an interface
        * Thus, subclasses from Observer can't be used as observables.
        * A developer can override some of Observable's synchronized
            methods and disrupt their thread safety.
    Now we use PropertyChangeListener.
 */
public class NewsAgencyObserved {
    private String news;
    private LocalDateTime lastUpdate;
    private PropertyChangeSupport changeSupport;

    public NewsAgencyObserved() {
        changeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener pcl) {
        changeSupport.addPropertyChangeListener(propertyName, pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        changeSupport.removePropertyChangeListener(pcl);
    }

    public void setNews(String value) {
        String oldNews = news;
        news = value;
        LocalDateTime oldTime = lastUpdate == null ? LocalDateTime.MIN : lastUpdate;
        lastUpdate = LocalDateTime.now();
        changeSupport.firePropertyChange("news",
                oldNews, news);
        changeSupport.firePropertyChange("lastUpdate",
                oldTime, lastUpdate);
    }
}
