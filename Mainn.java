interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}

abstract class RainySeasonConservation implements WaterConservationSystem {
    public abstract int calculateTrappedWater(int[] blockHeights);
}

class CityBlockConservation extends RainySeasonConservation {
    @Override
    public int calculateTrappedWater(int[] blockHeights) {
        if (blockHeights == null || blockHeights.length < 3) {
            return 0; 
        }

        int n = blockHeights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }

        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - blockHeights[i];
        }

        return trappedWater;
    }
}
public class Mainn {
    public static void main(String[] args) {
        CityBlockConservation conservationSystem = new CityBlockConservation();

    
        int[] testCase1 = {3, 0, 0, 2, 0, 4};
        System.out.println("Test Case 1 Output: " + conservationSystem.calculateTrappedWater(testCase1)); 

    
        int[] testCase2 = {3, 0, 2, 0, 4};
        System.out.println("Test Case 2 Output: " + conservationSystem.calculateTrappedWater(testCase2)); 
    }
}

