package lotto.domain

object AutomaticLottoVendingMachine {

    const val LOTTO_PRICE = 1000

    fun purchase(lottoCount: Int): List<LottoNumbers> {
        return List(lottoCount) {
            generate()
        }
    }

    private fun generate(): LottoNumbers {
        val randomNumbers =
            DuplicateFreeSequenceGenerator.generate(LottoNumber.MINIMUM, LottoNumber.MAXIMUM, LottoNumbers.LENGTH)
        return LottoNumbers.fromNumbers(randomNumbers)
    }
}
