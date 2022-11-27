package lotto.domain

object LottoVendingMachine {
    fun buy(numberOfLotto: Int): List<Lotto> {
        return List(numberOfLotto) { Lotto.createRandom() }
    }
}
