package lotto

class AutoLotto {
    fun generateNumbers(money: Int): List<LottoNumber> {
        val lottoCount = LottoPrice.getCountFrom(money)
        return issueLottoNumbers(lottoCount)
    }

    private fun issueLottoNumbers(count: Int): List<LottoNumber> {
        val lottoNumbers = mutableListOf<LottoNumber>()
        repeat(count) {
            lottoNumbers.add(buildAutoNumber())
        }

        return lottoNumbers
    }

    private fun buildAutoNumber(): LottoNumber {
        val autoNumbers = LottoNumber.LOTTO_NUMBER_RANGE
            .shuffled()
            .take(LottoNumber.TOTAL_LOTTO_NUMBER_COUNT)

        return LottoNumber.from(
            defaultNumbers = autoNumbers.subList(0, DefaultNumbers.DEFAULT_LOTTO_NUMBER_COUNT),
            bonusNumber = autoNumbers.last(),
        )
    }
}
