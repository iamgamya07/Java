class JAVAProfessionalRobber extends Robber {

    // Method to maximize money from row houses without robbing adjacent houses
    int RowHouses(int[] houses) {
        if (houses == null || houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];
        
        int prev1 = 0, prev2 = 0;
        for (int amount : houses) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + amount);
            prev2 = temp;
        }
        return prev1;
    }

    // Method to maximize money from round houses without robbing adjacent houses
    int RoundHouses(int[] houses) {
        if (houses == null || houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];
        
        return Math.max(rob(houses, 0, houses.length - 2), rob(houses, 1, houses.length - 1));
    }

    // Helper function for RoundHouses method
    private int rob(int[] houses, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + houses[i]);
            prev2 = temp;
        }
        return prev1;
    }

    // Method to maximize money from square houses without robbing adjacent houses
    int SquareHouse(int[] houses) {
        if (houses == null || houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];
        
        int prev1 = 0, prev2 = 0;
        for (int amount : houses) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + amount);
            prev2 = temp;
        }
        return prev1;
    }

    // Method to maximize money from multi-type house buildings without robbing adjacent houses
    
    int MultiHouseBuilding(int[][] houses) {
        int maxAmount = 0;
        for (int[] houseType : houses) {
            maxAmount += RowHouses(houseType);
        }
        return maxAmount;
    }
}

