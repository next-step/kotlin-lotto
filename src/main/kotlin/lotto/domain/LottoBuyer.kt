package lotto.domain

class LottoBuyer(
    private val lottoNumbersGenerator: LottoNumbersGenerator
) {
    fun buyLotto(lottoMoney: LottoMoney): List<Lotto> {
        val lottoCount = lottoMoney.calculateLottoCount()
        val lotto: MutableList<Lotto> = mutableListOf()
        repeat(lottoCount) {
            lotto.add(Lotto(lottoNumbersGenerator.generate(Lotto.LOTTO_NUMBER_COUNT)))
        }

        return lotto
    }
}
