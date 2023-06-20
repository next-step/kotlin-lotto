package next.step.lotto.domain

@JvmInline
value class Lottos(private val lottos: Set<Lotto>) {

    fun match(winningNumbers: LottoWinningNumbers, bonusNumber: LottoNumber): LottoWinningStat =
        LottoWinningStat.of(lottos.groupingBy {
            LottoRank.from(
                it.match(winningNumbers.numbers),
                it.match(bonusNumber)
            )
        }.eachCount())

    fun size(): Int = lottos.size

    fun numbers(): Set<Set<Int>> = lottos.map { it.numbers().toSet() }.toSet()

    companion object {
        fun of(lottos: Set<Lotto>): Lottos = Lottos(lottos)
    }

}