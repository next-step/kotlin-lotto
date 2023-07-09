package lotto.domain

@JvmInline
value class Lottos(val lottos: List<Lotto>) {
    val size: Int
        get() = lottos.size

    fun match(winningLotto: WinningLotto): WinningStatistics {
        return lottos.map { lotto -> winningLotto.rank(lotto) }
            .groupingBy { it }
            .eachCount()
            .let { WinningStatistics(it) }
    }
}
