package lotto.domain

@JvmInline
value class Lottos(val lottos: List<Lotto>) {
    val size: Int
        get() = lottos.size

    operator fun plus(other: Lottos): Lottos {
        return Lottos(lottos + other.lottos)
    }

    fun match(winningLotto: WinningLotto): WinningStatistics {
        return WinningStatistics(Ranks(lottos.map { lotto -> winningLotto.rank(lotto) }))
    }
}
