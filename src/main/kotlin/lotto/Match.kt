package lotto

class Match(left: List<Int>, right: List<Int>) {
    val count: Int = left.intersect(right).size
}
