class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] alice = new int[n];
        int[] bob = new int[n];
        for (int i = 0; i < n; i++) {
            alice[i] = i;
            bob[i] = i;
        }

        Arrays.sort(edges, (o1, o2) -> o2[0] - o1[0]);

        int aliceCount = n;
        int bobCount = n;
        int count = 0;
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1] - 1;
            int v = edge[2] - 1;

            boolean a = false;
            if (type != 2) {
                a = union(u, v, alice);
            }
            if (a) {
                aliceCount -= 1;
            }

            boolean b = false;
            if (type != 1) {
                b = union(u, v, bob);
            }
            if (b) {
                bobCount -= 1;
            }

            if (a || b) {
                count += 1;
            }
        }

        if (aliceCount == 1 && bobCount == 1) {
            return edges.length - count;
        }

        return -1;
    }
    
    private boolean union(int a, int b, int[] arr) {
        a = find(a, arr);
        b = find(b, arr);

        if (a != b) {
            arr[b] = a;
        }

        return a != b;
    }
    
    private int find(int a, int[] arr) {
        if (a == arr[a]) {
            return a;
        }
        arr[a] = find(arr[a], arr);
        return arr[a];
    }
}