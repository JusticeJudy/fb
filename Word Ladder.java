//Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end
public List<List<String>> findLadders(String start, String end, Set<String> dict) {
// store results
    List<List<String>> ladders = new ArrayList<List<String>>();
// Store the list of words that are one edit away from each word
    Map<String, List<String>> map = new HashMap<String, List<String>>();
// store the distance from the staring word for each word
    Map<String, Integer> distance = new HashMap<String, Integer>();

    dict.add(start);
    dict.add(end);

    bfs(map, distance, start, end, dict);

    List<String> path = new ArrayList<String>();

    dfs(ladders, path, end, start, distance, map);

    return ladders;
}

void dfs(List<List<String>> ladders, List<String> path, String crt, String start, Map<String, Integer> distance,
        Map<String, List<String>> map) {
    path.add(crt);
    if (crt.equals(start)) {
        Collections.reverse(path);
        ladders.add(new ArrayList<String>(path));
        Collections.reverse(path);
    } else {
        for (String next : map.get(crt)) {
            if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) { 
                dfs(ladders, path, next, start, distance, map);
            }
        }           
    }
    path.remove(path.size() - 1);
}

void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
        String start, String end, Set<String> dict) {
    Queue<String> q = new LinkedList<String>();
    q.offer(start);
    distance.put(start, 0);
    for (String s : dict) {
        map.put(s, new ArrayList<String>());
    }

    while (!q.isEmpty()) {
        String crt = q.poll();

        List<String> nextList = expand(crt, dict);
        for (String next : nextList) {
            map.get(next).add(crt);
            if (!distance.containsKey(next)) {
                distance.put(next, distance.get(crt) + 1);
                q.offer(next);
            }
        }
    }
}

List<String> expand(String crt, Set<String> dict) {
    List<String> expansion = new ArrayList<String>();

    for (int i = 0; i < crt.length(); i++) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch != crt.charAt(i)) {
                String expanded = crt.substring(0, i) + ch
                        + crt.substring(i + 1);
                if (dict.contains(expanded)) {
                    expansion.add(expanded);
                }
            }
        }
    }

    return expansion;
}
    
// return the shortest ladder length    
public int ladderLength(String start, String end, Set<String> dict) {
    if (dict == null) {
        return 0;
    }

    if (start.equals(end)) {
        return 1;
    }

    dict.add(start);
    dict.add(end);

    Set<String> hash = new HashSet<String>();
    Queue<String> queue = new LinkedList<String>();
    queue.offer(start);
    hash.add(start);

    int length = 1;
    while(!queue.isEmpty()) {
        length++;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String word = queue.poll();
            for (String nextWord: expand(word, dict)) {
                if (hash.contains(nextWord)) {
                    continue;
                }
                if (nextWord.equals(end)) {
                    return length;
                }

                hash.add(nextWord);
                queue.offer(nextWord);
            }
        }
    }
    return 0;
}
