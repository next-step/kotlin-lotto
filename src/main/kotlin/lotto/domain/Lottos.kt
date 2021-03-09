package lotto.domain

data class Lottos(val elements: List<Lotto>) {

    fun match(winningLotto: Lotto): Result {
        return Result(
            elements.map { winningLotto.matchCount(it) }
                .map { Rank.of(it) }
                .groupingBy { it }
                .eachCount()
        )
    }
}
