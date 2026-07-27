class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        HashMap<Integer, Integer> lossCount = new HashMap<>();

        for (int[] match : matches) {

            int winner = match[0];
            int loser = match[1];

            lossCount.putIfAbsent(winner, 0);

            lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);
        }

        List<Integer> neverLost = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();

        for (int player : lossCount.keySet()) {

            if (lossCount.get(player) == 0) {
                neverLost.add(player);
            }
            else if (lossCount.get(player) == 1) {
                lostOnce.add(player);
            }
        }

        Collections.sort(neverLost);
        Collections.sort(lostOnce);

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(neverLost);
        answer.add(lostOnce);

        return answer;
    }
}
