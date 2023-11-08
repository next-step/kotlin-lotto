package lotto

class LottoMachine(private val lottoNumberGenerator: LottoNumberGenerator) {
    fun generateLotto(amount: Amount): List<Lotto> {
        val lottoCount = amount.divide(LOTTO_UNIT_PRICE)
        val lottos = mutableListOf<Lotto>()
        repeat(lottoCount) {
            val lottoNumbers = generateLottoNumbers()
            lottos.add(Lotto(lottoNumbers))
        }
        return lottos
    }

    private fun generateLottoNumbers(): List<LottoNumber> {
        val lottoNumbers = mutableListOf<LottoNumber>()
        repeat(Lotto.SIZE) {
            lottoNumbers.add(generateLottoNumber(lottoNumbers))
        }
        return lottoNumbers
    }

    private fun generateLottoNumber(lottoNumbers: MutableList<LottoNumber>): LottoNumber {
        var lottoNumber = LottoNumber(lottoNumberGenerator.generate())
        while (lottoNumbers.contains(lottoNumber)) {
            lottoNumber = LottoNumber(lottoNumberGenerator.generate())
        }
        return lottoNumber
    }

    companion object {
        private const val LOTTO_UNIT_PRICE = 1_000
    }
}
