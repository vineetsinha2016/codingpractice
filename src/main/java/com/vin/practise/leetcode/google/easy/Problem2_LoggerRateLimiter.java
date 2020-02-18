package com.vin.practise.leetcode.google.easy;

import java.util.concurrent.ConcurrentHashMap;

/***
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 *
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 *
 * It is possible that several messages arrive roughly at the same time.
 *
 * Example:
 * Logger logger = new Logger();
 *
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true;
 *
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 *
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 *
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 *
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 *
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 */
public class Problem2_LoggerRateLimiter {
    private ConcurrentHashMap<String, Integer> hashMap;
    /** Initialize your data structure here. */
    public Problem2_LoggerRateLimiter() {
        hashMap = new ConcurrentHashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (hashMap.containsKey(message)) {
            System.out.println("timestamp-hashMap.get(message)-->"+(timestamp-hashMap.get(message)));
            if (timestamp-hashMap.get(message) >= 10) {
                hashMap.put(message, timestamp);
            }
            else {
                return false;
            }
        }
        else {
            hashMap.put(message, timestamp);
        }
        return true;
    }

    public static void main (String[] args) {
        Problem2_LoggerRateLimiter obj = new Problem2_LoggerRateLimiter();
        boolean param_1 = obj.shouldPrintMessage(1, "foo");
        System.out.println("result 1-->"+param_1);
        param_1 = obj.shouldPrintMessage(2, "bar");
        System.out.println("result 2-->"+param_1);
        param_1 = obj.shouldPrintMessage(3, "foo");
        System.out.println("result 3-->"+param_1);
        param_1 = obj.shouldPrintMessage(8, "bar");
        System.out.println("result 4-->"+param_1);
        param_1 = obj.shouldPrintMessage(10, "foo");
        System.out.println("result 5-->"+param_1);
        param_1 = obj.shouldPrintMessage(11, "foo");
        System.out.println("result 6-->"+param_1);
    }
}
