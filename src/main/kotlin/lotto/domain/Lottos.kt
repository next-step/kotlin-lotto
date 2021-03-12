package lotto.domain

data class Lottos(val elements: List<Lotto>) {

    fun match(winningLotto: WinningLotto): Result {
        return Result(
            elements.map { winningLotto.match(it) }
                .groupingBy { it }
                .eachCount()
        )
    }
}
