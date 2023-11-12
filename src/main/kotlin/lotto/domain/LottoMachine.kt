package lotto.domain

class LottoMachine(
    money: LottoMoney,
    private val lottoNumbersGenerator: LottoNumbersGenerator
) {
    val lottos: Lottos = Lottos(buyLotto(money))

    fun getTotalCount(): Int {
        return lottos.getTotalCount()
    }

    fun getLottos(): List<Lotto> {
        return lottos.lottos
    }

    private fun buyLotto(money: LottoMoney): List<Lotto> {
        return LottoBuyer(lottoNumbersGenerator).buyLotto(money)
    }
}
