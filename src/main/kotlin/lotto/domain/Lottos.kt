package lotto.domain

@JvmInline
value class Lottos(val value: List<Lotto>) {
    fun matchAll(winningLotto: WinningLotto): MatchedLottos {
        val matchedLottos = value.map { it.match(winningLotto) }

        return MatchedLottos(matchedLottos)
    }
}
