import java.util.concurrent.*;

public class CoinCombination {

    static class CombinationTask implements Callable<Integer> {
        private final int[] coins;
        private final int n;
        private final int sum;

        public CombinationTask(int[] coins, int n, int sum) {
            this.coins = coins;
            this.n = n;
            this.sum = sum;
        }

        @Override
        public Integer call() {
            int[] dp = new int[sum + 1];
            dp[0] = 1; 

            for (int i = 0; i < n; i++) {
                for (int j = coins[i]; j <= sum; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }

            return dp[sum];
        }
    }

    public static int findWays(int[] coins, int n, int sum) throws InterruptedException, ExecutionException {
        
        ExecutorService executor = Executors.newFixedThreadPool(n);
        
        Future<Integer> result = executor.submit(new CombinationTask(coins, n, sum));
        
        int ways = result.get();
        executor.shutdown();
        return ways;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] coins1 = {1, 2, 3};
        int n1 = coins1.length;
        int sum1 = 4;
        System.out.println("Output for Test Case 1: " + findWays(coins1, n1, sum1)); 

        int[] coins2 = {2, 5, 3, 6};
        int n2 = coins2.length;
        int sum2 = 10;
        System.out.println("Output for Test Case 2: " + findWays(coins2, n2, sum2)); 
    }
}
