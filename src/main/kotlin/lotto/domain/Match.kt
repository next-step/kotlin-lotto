package lotto.domain

data class Match(val count: Int = 0) {
    constructor(left: List<Int>, right: List<Int>) : this(left.intersect(right).size)
}
