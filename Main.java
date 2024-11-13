public class Main {
    public static void main(String[] args) {
        JAVAProfessionalRobber robber = new JAVAProfessionalRobber();
        
        // Test RobbingClass and MachineLearning methods
        robber.RobbingClass();  
        robber.MachineLearning(); 

        // Test RowHouses
        int[] rowHouses = {1, 2, 3, 0};
        System.out.println("RowHouses([1, 2, 3, 0]) -> " + robber.RowHouses(rowHouses)); 

        // Test RoundHouses
        int[] roundHouses = {1, 2, 3, 4};
        System.out.println("RoundHouses([1, 2, 3, 4]) -> " + robber.RoundHouses(roundHouses)); 

        // Test SquareHouse
        int[] squareHouse = {5, 10, 2, 7};
        System.out.println("SquareHouse([5, 10, 2, 7]) -> " + robber.SquareHouse(squareHouse)); 

        // Test MultiHouseBuilding
        int[][] multiHouseBuilding = {
            {5, 3, 8, 2},
            {10, 12, 7, 6},
            {4, 9, 11, 5},
            {8, 6, 3, 7}
        };
        System.out.println("MultiHouseBuilding -> " + robber.MultiHouseBuilding(multiHouseBuilding));
    }
}

