/*
 * @lc app=leetcode id=1233 lang=java
 *
 * [1233] Remove Sub-Folders from the Filesystem
 */

// @lc code=start
class TrieNode {

    private Map<String, TrieNode> subfolders;
    private String folderName;

    public TrieNode() {
        subfolders = new HashMap<>();
    }

    public boolean hasFolder(String name) {
        return subfolders.containsKey(name);
    }

    public TrieNode getFolder(String name) {
        return subfolders.get(name);
    }

    public void putFolder(String name, TrieNode folder) {
        subfolders.put(name, folder);
    }

    public List<TrieNode> getFolders() {
        List<TrieNode> folders = new ArrayList<>();
        for (Map.Entry<String, TrieNode> entry: subfolders.entrySet()) {
            folders.add(entry.getValue());
        }
        return folders;
    }

    public String getName() {
        return folderName;
    }

    public void setName(String name) {
        folderName = name;
    }

}

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        return solution1(folder);
    }

    private List<String> solution1(String[] folder) {
        TrieNode root = new TrieNode();
        for (String folderName: folder) {
            String[] path = folderName.split("/");
            TrieNode cur = root;
            for (int i = 1; i < path.length; i++) {
                if (!cur.hasFolder(path[i])) {
                    cur.putFolder(path[i], new TrieNode());
                }
                cur = cur.getFolder(path[i]);
            }
            cur.setName(folderName);
        }
        List<String> results = new ArrayList<>();
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TrieNode cur = queue.remove();
            if (cur.getName() != null) {
                results.add(cur.getName());
                continue;
            }
            queue.addAll(cur.getFolders());
        }
        return results;
    }

    // private List<String> solution2(String[] folder) {

    // }
}
// @lc code=end

