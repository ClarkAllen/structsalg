package net.kbg.probs.async;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

// TODO : explore thenRun() and thenApply()
public class FuturesTest {
    private Futures futures;

    public FuturesTest() {
        futures = new Futures();
    }

    @Test
    public void FuturesTest() {
        Long rslt = futures.factorial(19);
        System.out.println("factorial test : " + rslt);
        System.out.println(futures.getImmutableMap());
        rslt = futures.factorial(20);
        System.out.println("factorial test : " + rslt);
    }

    /*
        The thenAccept method takes a consumer method as an argument.
        Note how we still have to call get() when we are ready for
        the CompletableFuture to block.
     */
    @Test
    public void asyncFactorialAcceptTest() throws Exception {
        CompletableFuture<Long> future = futures.asyncFactorial(6);
        future.thenAccept(r -> System.out.println("asyncFactorial test" + r));
        future.get();
    }

}
