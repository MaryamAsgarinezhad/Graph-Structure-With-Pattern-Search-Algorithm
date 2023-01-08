# Graph-Structure-With-Pattern-Search-Algorithm

Definition :
The purpose of this project is to implement the data structure of the graph and perform search and navigation operations on it. Suppose we want to read a manuscript by a machine. One of the ways to do this is to identify different letters in the manuscript and from their combination words and finally the whole text can be read. We can consider the text in the form of a number of line segments that are connected at points and use graph vertices to display points and its edges as line segments as a data structure. This can be done both for the whole text and for each letter. Now, to read the text, we must look for subgraphs of the graph related to the text, which are similar to the graph related to the letters.

As a result, the main task in this manuscript reading algorithm is to find a specific subgraph in another graph.
To be precise, two graphs are given to us as input, and we have to find the location of the second graph in the first graph as the output. The vertices of each graph have a number (label) and each edge has a label that indicates its angle with the positive direction of the horizontal axis. As a result, the geometric position of the edges adjacent to each vertex is known. As a result, we must look for a subgraph of the primary graph that be exactly compatible with the second graph.

Pay attention, the second graph may be found by turning the page in the first graph. Note that there is no need to control the length of the edges and the geometric accuracy of the graph.

Our input is in two lines and in the form of sequences of ordered triplets which represent the edges of the two input graphs and the first, second and third components of these triplets are respectively the origin vertex, the destination vertex and the edge angle between these two.
The output is in the form of sequences of two ordered nodes, each pair is the correspondence between the vertices of the first and second graph in the form of number of vertices, and this sequence is sorted alphabetically first based on the first component and then based on the second component in the output. If there is more than one match, the match that is smaller in alphabetical order is declared, and if there is no match, the word NOMATCH is placed in the output.
We have not used any ready-made data structure except for the array and primitive numbers. For example, if a list is needed, it should be implemented by ourselves.

INPUT EXAMPLE:
(1,2,45)(1,3,270)(3,4,45)
(1,2,0)(1,3,45)

OUTPUT EXAMPLE:
(1,3)(3,1)(4,2)
