package lotto.domain

class NumberOfCorrectsByRank(private val numberOfCorrect: Int, private val rank: Rank) {
    operator fun component1() = numberOfCorrect
    operator fun component2() = rank
}
