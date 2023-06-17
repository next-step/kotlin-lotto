package next.step.lotto.domain

@JvmInline
value class Lottos(val lottos: Set<Lotto>) {
    fun match(winningNumbers: LottoWinningNumbers): LottoWinningStat =
        LottoWinningStat.of(lottos.groupingBy { it.match(winningNumbers) }.eachCount())

    fun size(): Int = lottos.size
    fun numbers(): Set<Set<Int>> = lottos.map { it.numbers().toSet() }.toSet()

    companion object {
        fun buy(payment: Int): Lottos {
            val lottos = mutableSetOf<Lotto>()
            var remained = payment
            while (Lotto.canBuy(remained)) {
                val lotto = Lotto.preview()
                if (!lottos.contains(lotto)) {
                    remained = lotto.buy(remained)
                    lottos.add(lotto)
                }
            }
            return Lottos(lottos)
        }

        fun of(lottos: Set<Lotto>): Lottos = Lottos(lottos)
    }

}