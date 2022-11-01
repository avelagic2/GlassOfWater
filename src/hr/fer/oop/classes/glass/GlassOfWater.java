package hr.fer.oop.classes.glass;

public class GlassOfWater {

    /**
     * clanske varijable
     */
    private int glassSize, currentWaterAmount, currentIceCubeCount;

    /**
     *
     * @param glassSize dodjeljujemo zapreminu preko konstruktora
     */
     public GlassOfWater(int glassSize) {
         this.glassSize = glassSize;
     }

    /**
     *
     * @param waterAmount dodajemo kolicinu vode i provjeravamo ima li preljevanja
     */
    public void addWater(int waterAmount) {
         System.out.printf("Glass contains %d ml of water and %d ice cubes before addition\n",
                 this.currentWaterAmount,
                 this.currentIceCubeCount);
         System.out.printf("Adding %d ml of water\n", waterAmount);

         currentWaterAmount += waterAmount;
         checkForOverflow();

         System.out.printf("Glass contains %d ml of water and %d ice cubes after addition\n",
                 this.currentWaterAmount,
                 this.currentIceCubeCount);

     }

    /**
     *
     * @param numberOfIceCubes dodajemo kolicinu kockica leda i provjeravamo ima li preljevanja
     */
    public void addIceCubes(int numberOfIceCubes) {
        System.out.printf("Glass contains %d ml of water and %d ice cubes before addition\n",
                this.currentWaterAmount,
                this.currentIceCubeCount);
        System.out.printf("Adding %d ice cubes\n", numberOfIceCubes);

        currentIceCubeCount += numberOfIceCubes;
        checkForOverflow();

        System.out.printf("Glass contains %d ml of water and %d ice cubes after addition\n",
                this.currentWaterAmount,
                this.currentIceCubeCount);

    }

    private void checkForOverflow() {
    int currentIceCubeVolume = currentIceCubeCount * 50;

    if(currentIceCubeVolume + currentWaterAmount > glassSize) {
     int overflowVolume = currentIceCubeVolume + currentWaterAmount - glassSize;

     if(overflowVolume <= currentWaterAmount) {
         currentWaterAmount -= overflowVolume;
         System.out.printf("%d ml of water has overflown\n", overflowVolume);

     }
     else {

         currentWaterAmount = 0;
         overflowVolume = currentIceCubeVolume - glassSize;
         //trik
         int overflownIceCubes = ((overflowVolume + 49)/ 50);
         this.currentIceCubeCount -= overflownIceCubes;
         System.out.printf("All water has overflown. %d ice cubes have overflown\n",
                 overflownIceCubes);
     }

    }
    }


}
