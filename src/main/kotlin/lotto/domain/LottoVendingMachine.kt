package lotto.domain

object LottoVendingMachine {
    fun buy(numberOfLotto: Int): List<LottoNumbers> {
        return List(numberOfLotto) { LottoNumbers.createRandom() }
    }
}
