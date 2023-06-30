package lotto

class AutoLotto {
    fun generateNumbers(money: Int): List<Lotto> {
        val lottoCount = LottoPrice.getCountFrom(money)
        return issueLottoNumbers(lottoCount)
    }

    private fun issueLottoNumbers(count: Int): List<Lotto> {
        val resultLottoNumbers = mutableListOf<Lotto>()
        repeat(count) {
            resultLottoNumbers.add(buildAutoNumber())
        }

        return resultLottoNumbers
    }

    private fun buildAutoNumber(): Lotto {
        return Lotto.from(
            numbers = Lotto.LOTTO_NUMBER_RANGE
                .shuffled()
                .take(Lotto.LOTTO_NUMBER_COUNT)
                .toSet(),
        )
    }
}
