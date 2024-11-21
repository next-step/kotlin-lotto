package lotto

class Lottos(val values: List<Lotto>) {
    val size: Int = values.size

    fun ranks(lastLotto: Lotto): Ranks {
        return Ranks.fromGroupBy(values.map { Rank.match(it.match(lastLotto)) })
    }

    companion object {
        private val UNIT_PRICE = Amount("1000")

        fun fromCount(
            buyAmount: Amount,
            generator: LottoNumbersGenerator,
        ): Lottos {
            val makeCount = buyAmount.divide(UNIT_PRICE)

            return Lottos((1..makeCount).map { Lotto(generator.generate()) })
        }
    }
}
