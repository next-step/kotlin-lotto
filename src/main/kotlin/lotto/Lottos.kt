package lotto

class Lottos(private val values: List<Lotto>) {
    val totalUnitPrice: Amount = UNIT_PRICE.multiply(values.size)
    val size: Int = values.size

    fun ranks(lastLotto: Lotto): Ranks {
        return Ranks.fromGroupBy(values.map { Rank.match(it.match(lastLotto)) })
    }

    fun concat(s: String): List<String> {
        return values.map { it.concat(s) }
    }

    companion object {
        private val UNIT_PRICE = Amount("1000")

        fun fromCount(buyAmount: Amount, generator: LottoNumbersGenerator): Lottos {
            val makeCount = buyAmount.divide(UNIT_PRICE)

            return Lottos((1..makeCount).map { Lotto(generator.generate()) })
        }
    }
}