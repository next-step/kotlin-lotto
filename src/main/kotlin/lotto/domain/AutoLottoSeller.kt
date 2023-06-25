package lotto.domain

class AutoLottoSeller : LottoSeller {

    override fun sell(amount: Int) = List(amount) { Lotto(generateLottoNumbers()) }

    private fun generateLottoNumbers(): Set<LottoNumber> = LottoNumber.VALID_RANGE.shuffled()
        .take(Lotto.COUNT_OF_LOTTO_NUMBER)
        .map { LottoNumber(it) }
        .toSet()
}
