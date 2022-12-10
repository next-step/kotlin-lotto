package step2.lotto.domain

class Lottos private constructor(private val elements: List<Lotto>) {
    fun match(winningNumber: WinningNumber): MatchResults =
        elements.map {
            it.match(winningNumber)
        }.run {
            MatchResults.of(this)
        }

    companion object {
        fun of(lottos: List<Lotto>): Lottos {
            return Lottos(lottos)
        }
    }
}
