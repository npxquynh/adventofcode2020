package adventofcode

object GraphUtils {
  def bfs[T](s: List[T], f: T => List[T], visitedNodes: List[T]): List[T] = {
    if (s.isEmpty) visitedNodes
    else {
      val newNeighbors = s.flatMap(f).distinct.filterNot(visitedNodes.contains)
      bfs(newNeighbors, f, visitedNodes :++ s)
    }
  }
}
