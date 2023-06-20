package next.step.lotto.domain

@JvmInline
value class Lottos(val lottos: Set<Lotto>) {

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
        fun buy(payment: Int): Lottos {
            val lottos = mutableSetOf<Lotto>()
            var remained = payment
            while (LottoStore.canBuy(remained)) {
                val lotto: Lotto = LottoStore.preview(LottoNumberGenerator.random())
                if (!lottos.contains(lotto)) {
                    remained = LottoStore.buy(remained)
                    lottos.add(lotto)
                }
            }
            return Lottos(lottos)
        }

        fun of(lottos: Set<Lotto>): Lottos = Lottos(lottos)
    }

}