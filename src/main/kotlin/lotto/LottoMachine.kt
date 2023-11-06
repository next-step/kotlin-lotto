package lotto

class LottoMachine(private val lottoNumberGenerator: LottoNumberGenerator) {

    fun generateLotto(): Lotto {
        val lottoNumbers = generateLottoNumbers()
        return Lotto(lottoNumbers)
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
}
