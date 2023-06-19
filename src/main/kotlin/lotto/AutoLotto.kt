package lotto

class AutoLotto {
    fun generateNumbers(money: Int): List<DefaultLottoNumber> {
        val lottoCount = LottoPrice.getCountFrom(money)
        return issueLottoNumbers(lottoCount)
    }

    private fun issueLottoNumbers(count: Int): List<DefaultLottoNumber> {
        val resultLottoNumbers = mutableListOf<DefaultLottoNumber>()
        repeat(count) {
            resultLottoNumbers.add(buildAutoNumber())
        }

        return resultLottoNumbers
    }

    private fun buildAutoNumber(): DefaultLottoNumber {
        return DefaultLottoNumber.from(
            numbers = DefaultLottoNumber.LOTTO_NUMBER_RANGE
                .shuffled()
                .take(DefaultLottoNumber.DEFAULT_LOTTO_NUMBER_COUNT),
        )
    }
}
