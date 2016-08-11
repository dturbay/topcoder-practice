package tda.srm696;

/**
 * Hero has a simple undirected graph. I.e., the graph has no self-loops and each pair of vertices is
 * connected by at most one edge. Hero would like to solve a standard problem: he wants to find the
 * size of the largest clique in his graph. (A clique is a subset C of vertices such that each pair
 * of vertices in C is connected by an edge. The size of a clique is the number of vertices in C.)
 * However, Hero is facing an issue: for some (at most 20) pairs of vertices he does not remember
 * whether they are connected by an edge or not. You are given the information Hero remembers: a g
 * with n elements, where n is the number of vertices in the graph. The vertices are numbered 0 through n-1.
 * For each valid i and j, g[i][j] is one of '0', '1', and '?'. Here, '0' means that vertices i and j
 * are not connected, '1' means that they are connected, and '?' means that Hero does not remember whether
 * they are connected. Let there be k unordered pairs of vertices for which Hero does not remember whether
 * they are connected or not. Then, there are exactly 2^k different graphs consistent with what Hero remembers.
 * For each of those graphs find the size of the largest clique, and return the sum of those 2^k numbers.
 */
public class Clicountingd2 {
  public int count(String[] g) {
    return 0;
  }
}
