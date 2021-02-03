package net.kbg.patterns.observer;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewsAgencyObservedTest {

    @Test
    public void testNewsUpdateHappyPath() {
        NewsAgencyObserved observed = new NewsAgencyObserved();

        NewsObserver newsObserver = new NewsObserver();
        observed.addPropertyChangeListener("news", newsObserver);

        UpdateTimeObserver timeObserver = new UpdateTimeObserver();
        observed.addPropertyChangeListener("lastUpdate", timeObserver);

        observed.setNews("Argentine revolution overthrows government.");

        assertEquals(newsObserver.getNewsUpdates().size(), 1);
        assertEquals(timeObserver.getUpdateTimes().size(), 1);
    }
}