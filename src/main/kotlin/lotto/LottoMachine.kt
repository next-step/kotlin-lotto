package lotto

class LottoMachine(val autoGenerate: (Amount) -> Lottos = defaultAutoGenerateFunction) {
    fun createLotto(values: List<Int>): Lotto {
        return Lotto(values.map { LottoNumber(it) }.toSet())
    }

    fun createPay(value: String): Amount {
        if (value.toIntOrNull() == null) {
            throw IllegalArgumentException("숫자가 아닙니다.")
        }
        return Amount(value)
    }

    fun createManualLottos(
        manualLottoCount: Int,
        generator: () -> List<Int>,
    ): Lottos {
        return Lottos.from(manualLottoCount) { generator() }
    }

    companion object {
        private val TICKET_PRICE: Amount = Amount(1000)
        private val CACHE: List<LottoNumber> = (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER).map { LottoNumber(it) }

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
