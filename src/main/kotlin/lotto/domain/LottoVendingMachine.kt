package lotto.domain

object LottoVendingMachine {
    fun buyRandomLottos(numberOfLotto: Int): List<LottoNumbers> {
        return List(numberOfLotto) { LottoNumbers.createRandom() }
    }
}
