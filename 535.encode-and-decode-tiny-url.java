/*
 * @lc app=leetcode id=535 lang=java
 *
 * [535] Encode and Decode TinyURL
 */

// @lc code=start
public class Codec {

    private long id = 0;
    private Map<String, String> long2Short = new HashMap<>();
    private Map<String, String> short2Long = new HashMap<>();
    private String CHARS = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
    private int MAX_LEN = 6;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (long2Short.containsKey(longUrl)) {
            return long2Short.get(longUrl);
        } else {
            String shortUrl = "";
            while (id > 0) {
                shortUrl = CHARS.charAt((int)(id % 62)) + shortUrl;
                id /= 62;
            }
            while (shortUrl.length() < MAX_LEN) {
                shortUrl = "0" + shortUrl;
            }
            short2Long.put(shortUrl, longUrl);
            long2Short.put(longUrl, shortUrl);
            return shortUrl;
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return short2Long.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
// @lc code=end

