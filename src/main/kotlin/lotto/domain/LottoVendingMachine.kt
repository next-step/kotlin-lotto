package lotto.domain

object LottoVendingMachine {
    fun buyRandomLottos(numberOfLotto: Int): List<LottoNumbers> {
        return List(numberOfLotto) { LottoNumbers.createRandom() }
    }

    fun makeWinningLotto(inputWinningNumbers: List<Int>, bonusNumber: Int): WinningLottoNumbers {
        val lottoNumbers = LottoNumbers(
            inputWinningNumbers.map {
                LottoNumber.from(it)
            }.toSet()
        )
        val bonusLottoNumber = LottoNumber.from(bonusNumber)

        return WinningLottoNumbers(lottoNumbers = lottoNumbers, bonusLottoNumber = bonusLottoNumber)
    }

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
