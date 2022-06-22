package lotto.domain

object LottoFactory {
    fun createLottoList(inputMoney: LottoMoney, lottoNumberGenerator: LottoNumberGenerator): List<Lotto> {
        val lottoCount = inputMoney.calculateLottoCount()

        return List(lottoCount) { Lotto.create(lottoNumberGenerator.generate()) }
    }

    fun createWinningLotto(winningLottoNumbers: List<Int>): WinningLotto {
        return WinningLotto(winningLottoNumbers.map { LottoNumber(it) })
    }
}
