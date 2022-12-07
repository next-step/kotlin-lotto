package lotto.domain

object LottoVendingMachine {
    fun buyLottos(purchaseAmount: PurchaseAmount, inputManualNumbers: List<List<Int>>): UserLottos {
        val numberOfLottoByRandom = purchaseAmount.getNumberOfLotto() - inputManualNumbers.size
        val randomLottos = makeRandomLottos(numberOfLotto = numberOfLottoByRandom)
        val manualLottos = inputManualNumbers.map { lottoNumbers ->
            LottoNumbers(
                lottoNumbers.map {
                    LottoNumber.from(it)
                }.toSet()
            )
        }

        return UserLottos(manualLottos + randomLottos)
    }

    private fun makeRandomLottos(numberOfLotto: Int): List<LottoNumbers> {
        return List(numberOfLotto) { LottoNumbers.createRandom() }
    }
}
