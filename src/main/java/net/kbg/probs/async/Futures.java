package net.kbg.probs.async;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class Futures {

    private static Map<Integer, Long> facts;

    public Futures() {
        facts = new ConcurrentHashMap<>(20);
    }

    public Map<Integer, Long> getImmutableMap() {
        return Collections.unmodifiableMap(facts);
    }

    CompletableFuture<Long> asyncFactorial(int number) {
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> factorial(number));
        return completableFuture;
    }

    public Long factorial(int n) {
        Long rslt = 0L;
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n < 2) {
            return 1L;
        }
        if (facts.get(n) != null) {
            return facts.get(n);
        } else {
            rslt = n * factorial(n - 1);
            facts.put(n, rslt);
        }
        return rslt;
    }

}
