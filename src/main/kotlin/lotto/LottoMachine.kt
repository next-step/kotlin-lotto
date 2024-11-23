package lotto

class LottoMachine(val autoGenerate: (Amount) -> Lottos = defaultAutoGenerateFunction) {
    fun createLotto(values: List<Int>): Lotto {
        return Lotto(values.toSet())
    }

    companion object {
        private val TICKET_PRICE: Amount = Amount(1000)
        private val CACHE = (Lotto.LOTTO_MIN_NUMBER..Lotto.LOTTO_MAX_NUMBER)

        private val defaultAutoGenerateFunction: (Amount) -> Lottos = { amount ->
            val count = amount.div(TICKET_PRICE)
            Lottos(
                List(count) {
                    Lotto(
                        CACHE.shuffled()
                            .take(Lotto.LOTTO_SIZE)
                            .toSet(),
                    )
                },
            )
        }
    }
}
