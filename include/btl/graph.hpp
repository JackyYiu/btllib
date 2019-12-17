#ifndef BTL_GRAPH_HPP
#define BTL_GRAPH_HPP

#include <boost/graph/adjacency_list.hpp>
#include <boost/graph/graphviz.hpp>

#include <iostream>

namespace btl {

class Graph;

class Vertex
{

public:
private:
  friend class Graph;

  Vertex(long id)
    : id(id)
  {}

  long id;
};

class Edge
{

public:
private:
  friend class Graph;

  Edge(Vertex u, Vertex v)
    : u(u)
    , v(v)
  {}

  Vertex u, v;
};

class Graph
{

public:
  Graph() {}

  Vertex add_vertex();
  void remove_vertex(Vertex v);

  Edge add_edge(Vertex u, Vertex v);
  void remove_edge(Edge e);

  friend std::ostream& operator<<(std::ostream& os, const Graph& g);

private:
  boost::adjacency_list<boost::vecS, boost::vecS, boost::bidirectionalS> graph;
};

inline Vertex
Graph::add_vertex()
{
  return boost::add_vertex(graph);
}

inline void
Graph::remove_vertex(Vertex v)
{}

inline Edge
Graph::add_edge(Vertex u, Vertex v)
{
  boost::add_edge(u.id, v.id, graph);
  return Edge(u, v);
}

inline void
Graph::remove_edge(Edge e)
{
  boost::remove_edge(e.u.id, e.v.id, graph);
}

inline std::ostream&
operator<<(std::ostream& os, const Graph& g)
{
  boost::write_graphviz(os, g.graph);
  return os;
}

} // namespace btl

#endif