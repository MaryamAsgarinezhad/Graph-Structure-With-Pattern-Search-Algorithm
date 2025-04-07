# Graph-Structure-With-Pattern-Search-Algorithm
### 📌 Problem Definition

The goal of this project is to implement a custom graph data structure and perform a subgraph pattern search within it. This problem is inspired by the challenge of enabling machines to read handwritten manuscripts by recognizing individual characters and matching them to known patterns.

Imagine a manuscript where each letter can be represented as a small graph: line segments forming shapes, connected at specific angles and points. The entire text can then be seen as a larger graph, where vertices represent intersection points and edges represent line segments, each with a directional angle.

To read or recognize text, we need to search for a pattern graph (representing a known letter or symbol) within a larger graph (representing the scanned manuscript). Thus, the central task becomes:

- Given two graphs (G and P), find all occurrences of P as a subgraph of G, accounting for rotation.

### 🔍 Key Details

- Each vertex in the graph is identified by a number (label).

- Each edge is defined by a triplet:
    (origin_vertex, destination_vertex, angle)
    where the angle is measured relative to the positive horizontal axis.

- The geometry of the graph matters in terms of edge angles, but edge lengths are ignored.

- The search must allow for rotations of the pattern graph (P) within the main graph (G), meaning the entire P can be rotated but must retain relative angles between edges.

- Only basic data structures like arrays and primitive types are allowed—no use of built-in or advanced libraries for graphs or lists.


### 🧠 Objective

Given two graphs as input:

  G: The main graph (e.g., the manuscript),

  P: The pattern graph (e.g., a specific letter),

Identify whether P appears as a subgraph within G, allowing for rotation but requiring structural and angular consistency.


### 📥 Input Format

  The input consists of two space-separated lines.

  Each line contains a sequence of ordered triplets of the form:
    (origin, destination, angle)

  The first line represents the edges of the main graph (G).

  The second line represents the edges of the pattern graph (P).

### 📤 Output Format

  If a matching subgraph is found, output a sequence of ordered pairs:
    (vG, vP)
    where vG is a vertex from the main graph and vP is the corresponding vertex from the pattern graph.

  The output list must be sorted alphabetically, first by the vG and then by vP.

  If multiple matches are possible, output the alphabetically smallest one.

  If no match is found, output:
  NOMATCH


### 📚 Example

Input:

- (1,2,45)(1,3,270)(3,4,45) (1,2,0)(1,3,45)

Output:

- (1,3)(3,1)(4,2)

### 📌 Constraints

  No built-in data structures may be used except for arrays and basic numeric types.

  All list-like structures or hash maps must be implemented manually.
