class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
         HashMap<String, HashMap<String, Double>> gr = buildGraph(equations, values);
        double[] finalAns = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if (!gr.containsKey(dividend) || !gr.containsKey(divisor)) {
                finalAns[i] = -1.0;
            } else {
                HashSet<String> vis = new HashSet<>();
                double[] ans = {-1.0};
                double temp = 1.0;
                dfs(dividend, divisor, gr, vis, ans, temp);
                finalAns[i] = ans[0];
            }
        }

        return finalAns;
    }
    public HashMap<String,HashMap<String,Double>> buildGraph(List<List<String>> equations, double[] values){
        HashMap<String,HashMap<String,Double>> g = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];
            g.putIfAbsent(dividend,new HashMap<>());
            g.putIfAbsent(divisor,new HashMap<>());

            g.get(dividend).put(divisor,value);
            g.get(divisor).put(dividend,1.0/value);
        }
        return g;
        } 
        public void dfs(String node,String dest,HashMap<String,HashMap<String,Double>> g,HashSet<String> vis,double ans[],double temp){
            if(vis.contains(node))  return;
            vis.add(node);
            if(node.equals(dest)){
                ans[0]=temp;
                return;
            }
           for (Map.Entry<String, Double> entry : g.get(node).entrySet()) {
            String ne = entry.getKey();
            double val = entry.getValue();
            dfs(ne, dest, g, vis, ans, temp * val);
        }  
        }
    
}
