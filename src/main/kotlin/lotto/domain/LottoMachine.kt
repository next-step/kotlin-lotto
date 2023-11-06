package lotto.domain

class LottoMachine(val lottoPrice: Int) {
    fun purchase(money: Int): Lottos {
        return Lottos(money / lottoPrice)
    }
}
