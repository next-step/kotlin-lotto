package lotto.domain

class AutoLottoGenerator : LottoGenerator {

    override fun generate(amount: Int)= List(amount) { Lotto(generateLottoNumbers()) }

    private fun generateLottoNumbers(): List<LottoNumber> = LottoNumber.VALID_RANGE.shuffled()
        .take(Lotto.COUNT_OF_LOTTO_NUMBER)
        .map { LottoNumber(it) }
}
