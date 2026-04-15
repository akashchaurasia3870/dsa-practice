class TrappingRainwater{

    public static int solve(int[] height){
        int[] leftmaxboundry = new int[height.length];
        int[] rightmaxboundry = new int[height.length];
        leftmaxboundry[0] = height[0];
        for(int i=1;i<height.length;i++){
            leftmaxboundry[i] = Math.max(leftmaxboundry[i-1], height[i]);
        }
        rightmaxboundry[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightmaxboundry[i] = Math.max(rightmaxboundry[i+1], height[i]);
        }
        int volume = 0;
        for(int i=0;i<height.length;i++){
            int volume1 = Math.min(leftmaxboundry[i], rightmaxboundry[i]) - height[i];
            volume += volume1;
            System.out.println("Bar :"+height[i]+" -> volume: "+volume1);
        }

        return volume;
    }
    public static void main(String[] args) {
        // int[] height = {4,2,0,6,3,2,5};
        int[] height = {4,2,0,3,2,5};
        int volume = solve(height);
        System.out.println(volume);
    }
}