package com.vin.practise.leetcode.Amazon.oa;

import java.util.*;

/**
 * Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the
 * user has listened to as values.
 *
 * Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within
 * that genre as values. The song can only belong to only one genre.
 *
 * The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list
 * of the user's favorite genre(s). Favorite genre is the most listened to genre.
 * A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.
 *
 * Example 1:
 * Input:
 * userSongs = {
 *    "David": ["song1", "song2", "song3", "song4", "song8"],
 *    "Emma":  ["song5", "song6", "song7"]
 * },
 * songGenres = {
 *    "Rock":    ["song1", "song3"],
 *    "Dubstep": ["song7"],
 *    "Techno":  ["song2", "song4"],
 *    "Pop":     ["song5", "song6"],
 *    "Jazz":    ["song8", "song9"]
 * }
 *
 * Output: {
 *    "David": ["Rock", "Techno"],
 *    "Emma":  ["Pop"]
 * }
 *
 * Explanation:
 * David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
 * Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
 *
 * Example 2:
 *
 * Input:
 * userSongs = {
 *    "David": ["song1", "song2"],
 *    "Emma":  ["song3", "song4"]
 * },
 * songGenres = {}
 *
 * Output: {
 *    "David": [],
 *    "Emma":  []
 * }
 */
public class FavoriteGenre {
    public static void main (String[] args) {
        Map<String,List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));
        Map<String,List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));
        System.out.println("Result--->"+favoritegenre(userSongs,songGenres));
    }

    static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        //Step 1: From genreMap of genre and songs make a map of song(keys) to genre
        //Step 2: Create a result map of user to favgenres
        //Step 3: loop through userMap and find the counts max(s) and add them to result
        System.out.println("UserMap-->"+userMap);
        System.out.println("GenreMap-->"+genreMap);
        HashMap<String, String> songGenreMap = new HashMap<>();
        HashMap<String, List<String>> result = new HashMap<>();
        for (String genre : genreMap.keySet()) {
            List<String> songs = new ArrayList<>(genreMap.get(genre));
            songs.forEach(x->songGenreMap.put(x, genre));
        }
        System.out.println("SongToGenreMap-->"+songGenreMap);

        for (String user : userMap.keySet()){
            int max=0,count=0;
            final List<String> songs = userMap.get(user);
            System.out.println("user's songs:;"+songs);
            HashMap<String, Integer> genreCount = new HashMap<>();
            result.put(user, new ArrayList<>());
            for (String song:songs) {
                //if (songGenreMap.containsKey(song)) {
                String genreOFsong = songGenreMap.get(song);
                int countOfThisGenre = genreCount.getOrDefault(songGenreMap.get(song),0)+1;
                    genreCount.put(genreOFsong,countOfThisGenre);
                    max=Math.max(countOfThisGenre, max);
                //}
            }
            List<String> genreList = new ArrayList<>();
            for (String genre : genreCount.keySet()) {
                if (genreCount.get(genre)==max) {
                    genreList.add(genre);
                }
            }
            result.put(user,genreList);
            System.out.println("User::"+user +" and genreList:"+genreList);
        }
        return result;
    }
}
