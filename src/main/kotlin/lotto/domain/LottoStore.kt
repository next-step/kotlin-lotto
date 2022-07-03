package lotto.domain

object LottoStore {
    fun buyLottos(inputMoney: LottoMoney, lottoNumberGenerator: LottoNumberGenerator): List<Lotto> {
        val lottoCount = inputMoney.calculateLottoCount()

        return List(lottoCount) { Lotto.create(lottoNumberGenerator.generate()) }
    }

    fun buyManualLottos(inputMoney: LottoMoney, manualLottos: List<List<Int>>): Pair<LottoMoney, List<Lotto>> {
        val manualLottosMoney = LottoMoney(manualLottos.size * Lotto.PRICE)
        require(inputMoney > manualLottosMoney) { "수동 로또는 구입금액 내에서만 구매하실 수 있습니다." }

        return Pair(
            inputMoney - manualLottosMoney,
            manualLottos.map { it.map { number -> LottoNumber(number) } }
                .map { Lotto.create(it) }
        )
    }

    fun createWinningLotto(winningLottoNumbers: List<Int>, bonusNumber: Int): WinningLotto {
        return WinningLotto(winningLottoNumbers.map { LottoNumber(it) }, LottoNumber(bonusNumber))
    }
}
