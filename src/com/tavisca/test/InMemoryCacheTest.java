package com.tavisca.test;

import com.tavisca.main.InMemoryCache;

public class InMemoryCacheTest {

    public static void main(String[] args) throws InterruptedException {
        InMemoryCacheTest cache = new InMemoryCacheTest();

        cache.testAddRemoveObjects();

        cache.testExpiredCacheObjects();

        cache.testObjectsCleanupTime();
    }

    private void testAddRemoveObjects(){
        InMemoryCache<String,String> cache = new InMemoryCache<String ,String >(200,500,6);

        cache.put("eBay", "eBay");
        cache.put("Paypal", "Paypal");
        cache.put("Google", "Google");
        cache.put("Microsoft", "Microsoft");
        cache.put("IBM", "IBM");
        cache.put("Facebook", "Facebook");

        System.out.println("6 Cache Object Added.. cache.size(): " + cache.size());
        cache.remove("IBM");
        System.out.println("One object removed.. cache.size(): " + cache.size());

        cache.put("Twitter", "Twitter");
        cache.put("SAP", "SAP");
        System.out.println("Two objects Added but reached maxItems.. cache.size(): " + cache.size());
    }

    private void testExpiredCacheObjects() throws InterruptedException {
        InMemoryCache<String, String> cache = new InMemoryCache<String, String>(1, 1, 10);

        cache.put("eBay", "eBay");
        cache.put("Paypal", "Paypal");

        Thread.sleep(300);
        System.out.println("Two obj added but reached limit of ttl");
    }

    private void testObjectsCleanupTime() throws InterruptedException {
        int size = 500000;
        InMemoryCache<String, String> cache = new InMemoryCache<String, String>(100, 100, 500000);

        for (int i = 0; i < size; i++) {
            String value = Integer.toString(i);
            cache.put(value, value);
        }

        Thread.sleep(200);

        long start = System.currentTimeMillis();
        cache.cleanup();
        double finish = (double) (System.currentTimeMillis() - start) / 1000.0;

        System.out.println("Cleanup times for " + size + " objects are " + finish + " s");

    }
}
