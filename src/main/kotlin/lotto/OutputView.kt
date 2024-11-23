package lotto

interface OutputView {
    fun printLottoQuantity(quantity: Int)

    fun printLottoNumbers(lottos: Lottos)

    fun printLottoResult(lottoResult: LottoResult)
}
