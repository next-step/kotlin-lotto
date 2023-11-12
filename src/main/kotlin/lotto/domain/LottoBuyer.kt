package lotto.domain

class LottoBuyer(
    private val lottoNumbersGenerator: LottoNumbersGenerator
) {
    fun buyLotto(lottoMoney: LottoMoney): List<Lotto> {
        val lottoCount = lottoMoney.calculateLottoCount()
        return List(lottoCount) {
            Lotto(lottoNumbersGenerator.generate(Lotto.LOTTO_NUMBER_COUNT))
        }
    }
}
