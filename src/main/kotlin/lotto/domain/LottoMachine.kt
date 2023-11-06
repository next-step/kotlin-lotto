package lotto.domain

class LottoMachine(val lottoPrice: Int) {
    fun purchase(price: Int): Lottos {
        return Lottos(price / lottoPrice)
    }
}
