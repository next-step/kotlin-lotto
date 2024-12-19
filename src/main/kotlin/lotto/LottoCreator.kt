package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto
import lotto.util.LottoNumberGenerator
import lotto.util.RandomLottoNumberGenerator

class LottoCreator(private val lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()) {
    fun createAutoLottos(count: Int): List<Lotto> {
        return List(count) { createSingleLotto() }
    }

    fun createWinningLotto(
        winningNumbers: Set<Int>,
        bonusNumber: Int,
    ): WinningLotto {
        val winningLottoNumbers = winningNumbers.map { LottoNumber.getNumber(it) }.toSet()
        val winningLotto = Lotto.from(winningLottoNumbers)
        return WinningLotto(winningLotto, LottoNumber.getNumber(bonusNumber))
    }

    private fun createSingleLotto(): Lotto {
        return Lotto.from(lottoNumberGenerator.generate())
    }

    fun createManualLottos(manualLottoNumbers: List<Set<Int>>): List<Lotto> {
        return manualLottoNumbers.map { numbers -> Lotto.from(numbers.map { LottoNumber.getNumber(it) }.toSet()) }
    }
}
