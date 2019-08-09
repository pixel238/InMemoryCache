package com.tavisca.test;

import com.tavisca.main.InMemoryCache;

public class InMemoryCacheTest {

    public static void main(String[] args){
        InMemoryCacheTest cache = new InMemoryCacheTest();

        cache.testAddRemoveObjects();
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
}
