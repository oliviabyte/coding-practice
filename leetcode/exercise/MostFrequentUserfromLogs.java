package leetcode.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem: Most Frequent User from Logs
 *
 * You are given a list of log entries, where each log is a string formatted as:
 *     "<username> <YYYY-MM-DD> <HH:MM>"
 *
 * Each log represents a single access to the system by a user at a specific time.
 * Your task is to find the user who accessed the system the most times.
 * If multiple users have the same highest number of accesses, return any one of them.
 *
 * Example Input:
 * [
 *     "Alice 2024-05-01 12:30",
 *     "Bob 2024-05-01 13:00",
 *     "Alice 2024-05-02 09:15",
 *     "Charlie 2024-05-03 10:00",
 *     "Alice 2024-05-04 15:20",
 *     "Bob 2024-05-05 16:45"
 * ]
 *
 * Example Output:
 * Alice
 *
 * Constraints:
 * - 1 <= logs.length <= 10^5
 * - Each log is a valid string with format "<username> <YYYY-MM-DD> <HH:MM>"
 * - Usernames contain only letters and are at most 20 characters long
 * - Return any user with the highest access count
 * 
 * followup:
 * - 如果有多个用户访问次数并列最多，能不能返回所有这些用户？
 * - 如果日志有上亿条，放不进内存，你该怎么处理？
 * - 如果只统计最近 7 天内的访问记录，该怎么改？
 * - 能不能返回访问次数最多的前 K 个用户？
 * - 如果多个线程同时处理日志，你该如何设计程序确保统计正确？
 * - 能否统计每个小时段（如 12:00-13:00）哪个用户最活跃？
 */
public class MostFrequentUserfromLogs{
    public static String findMostFrequentUser(String[] logs) {
        HashMap<String, Integer> visitCount = new HashMap<>();
        String resultUser = null;
        int maxCount = 0;
        for(String log : logs) {
            String[] parts = log.split(" ");
            if(parts.length < 1) continue;
            String user = parts[0];
            visitCount.put(user, visitCount.getOrDefault(user, 0)+1);

            if(visitCount.get(user) > maxCount) {
                maxCount = visitCount.get(user);
                resultUser = user;
            }
        }
        return resultUser;
    }
    public static List<String> findAllMostFrequentUsers(String[] logs) {
        HashMap<String, Integer> visitCount = new HashMap<>();
        int maxCount = 0;
        for(String log : logs) {
            String[] parts = log.split(" ");
            if(parts.length < 1) continue;
            String user = parts[0];
            visitCount.put(user, visitCount.getOrDefault(user, 0)+1);

            if(visitCount.get(user) > maxCount) {
                maxCount = visitCount.get(user);
            }
        }
        List<String> result = new ArrayList<>();
        for(String user : visitCount.keySet()) {
            if(visitCount.get(user) == maxCount) {
                result.add(user);
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        String[] logs = {
            "Alice 2024-05-01 12:30",
            "Bob 2024-05-01 13:00",
            "Alice 2024-05-02 09:15",
            "Charlie 2024-05-03 10:00",
            "Alice 2024-05-04 15:20",
            "Bob 2024-05-05 16:45",
            "Bob 2024-05-05 16:46",
            "Bob 2024-05-05 16:46"
        };
        String result = findMostFrequentUser(logs);
        System.out.println("most frequent user is: " + result);
    }
}

