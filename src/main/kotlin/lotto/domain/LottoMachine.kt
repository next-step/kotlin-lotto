package lotto.domain

object LottoMachine : LottoGenerator {
    private const val LOTTO_PRICE = 1_000

    fun getLottoList(amount: Int): List<Lotto> {
        require(amount >= LOTTO_PRICE)

        val lottoCount = amount / LOTTO_PRICE

        return (1..lottoCount).map { generateLotto() }
    }

    private fun generateLotto(): Lotto {
        val lottoNumbers = LottoNumber.NUMBERS
            .keys
            .shuffled()
            .take(Lotto.COUNT)

        return generateLotto(lottoNumbers)
    }

    override fun generateLotto(numbers: List<Int>): Lotto {
        val lottoNumbers = numbers.map { number -> LottoNumber.from(number) }
            .toSet()

        return Lotto(lottoNumbers)
    }
}
