package lotto

class LottoMachine(private val lottoNumberGenerator: LottoNumberGenerator) {
    fun generateLotto(amount: Amount): List<Lotto> {
        val lottoCount = amount.divide(LOTTO_UNIT_PRICE)
        return (0 until lottoCount).map { Lotto(generateLottoNumbers()) }
    }

    private fun generateLottoNumbers(): Set<LottoNumber> {
        val lottoNumbers = mutableSetOf<LottoNumber>()
        while (lottoNumbers.size < Lotto.SIZE) {
            lottoNumbers.add(LottoNumber(lottoNumberGenerator.generate()))
        }
        return lottoNumbers
    }

    companion object {
        private const val LOTTO_UNIT_PRICE = 1_000
    }
}
