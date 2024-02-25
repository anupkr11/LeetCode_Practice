class Solution {

    public List<Integer> get_factors(int N){

        List<Integer> factors_list = new ArrayList<Integer>();

        for(int i = 2 , end = ((int) Math.sqrt(N)) ; (i <= end) ; i++){

            while((N % i) == 0){

                factors_list.add(i);

                N /= i;
            }
        }

        if(N > 1){
            factors_list.add(N);
        }

        return factors_list;
    }

    public void depth_first_search(int current_node , Map<Integer , List<Integer>> adjacency_list , Set<Integer> visited_set){

        visited_set.add(current_node);

        for(int neighbour_node : adjacency_list.getOrDefault(current_node , (new ArrayList<Integer>()))){

            if(!visited_set.contains(neighbour_node)){

                depth_first_search(neighbour_node , adjacency_list , visited_set);
            }
        }
    }

    public boolean canTraverseAllPairs(int[] array){
        
        int N = array.length;

        Map<Integer , Integer> gcd_map = new HashMap();

        Map<Integer , List<Integer>> adjacency_list = new HashMap<>();

        for(int i = 0 ; (i < N) ; i++){

            for(int factor : get_factors(array[i])){

                if(gcd_map.get(factor) != null){

                    int node_1 = i;

                    int node_2 = gcd_map.get(factor);

                    adjacency_list.computeIfAbsent(node_1 , (k -> (new ArrayList<Integer>()))).add(node_2);

                    adjacency_list.computeIfAbsent(node_2 , (k -> (new ArrayList<Integer>()))).add(node_1);
                }

                gcd_map.put(factor , i);
            }
        }

        Set<Integer> visited_set = new HashSet<Integer>();

        depth_first_search(0 , adjacency_list , visited_set);

        return (visited_set.size() == N);
    }
}