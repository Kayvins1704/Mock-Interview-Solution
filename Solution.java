public class Solution {
	static class Pair{
		int node, steps;
		public Pair(int node, int steps){
			this.node = node;
			this.steps = steps;
		}
	}
	public int solve(int[] arr){
		int min = Integer.MAX_VALUE;
		boolean[] visited = new boolean[arr.length];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Map<Integer, List<Integer>> eqMap = new HashMap<>();
		
		for(int i=0; i<arr.length; i++){
			graph.putIfAbsent(i, new ArrayList<>());
			if(i+1 < arr.length) graph.get(i).add(i+1);
			if(i-1 >= 0) graph.get(i).add(i-1);
			
			if(eqMap.containsKey(arr[i])){
				for(Integer node : eqMap.get(arr[i])){
					graph.get(node).add(i);
				}
			}else{
				eqMap.put(arr[i], new ArrayList<>());
			}
			
			eqMap.get(arr[i]).add(i);
		}
		
		Deque<Pair> q = new ArrayDeque<>();
		
		q.addLast(new Pair(0, 0));
		
		while(!q.isEmpty()){
			Pair p = q.removeFirst();
			if(visited[p.node]) continue;
			if(p.node == arr.length - 1) {
				min = Math.min(min, p.steps);
				continue;
			}
			visited[p.node] = true;
			if(graph.containsKey(p.node)){
				for(Integer n : graph.get(p.node)){
					q.addLast(new (p.node, p.steps+1));
				}
			}
		}
		
		return min;
	}
}