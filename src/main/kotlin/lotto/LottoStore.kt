package lotto

object LottoStore {
    fun buy(money: Int): List<Lotto> = List(money / Lotto.PRICE) { Lotto() }
}
