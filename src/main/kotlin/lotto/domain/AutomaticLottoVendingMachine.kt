package lotto.domain

object AutomaticLottoVendingMachine {

    const val LOTTO_PRICE = 1000

    fun purchase(lottoCount: Int): List<LottoNumbers> {
        return List(lottoCount) {
            LottoNumbers.generate()
        }
    }
}
