package lotto

import lotto.const.LottoConst
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto
import lotto.util.NumberGenerator
import lotto.util.RandomNumberGenerator

class LottoCreator(private val numberGenerator: NumberGenerator = RandomNumberGenerator()) {
    fun createLottos(count: Int): List<Lotto> {
        return List(count) { createSingleLotto() }
    }

    fun createWinningLotto(
        winningNumbers: Set<Int>,
        bonusNumber: Int,
    ): WinningLotto {
        val winningLotto = Lotto(winningNumbers.map { LottoNumber(it) }.toSet())
        return WinningLotto(winningLotto, LottoConst.getLottoNumber(bonusNumber))
    }

    private fun createSingleLotto(): Lotto {
        val randomNumbers = numberGenerator.generate()
        val lotto = Lotto(randomNumbers.map { LottoConst.LOTTO_NUMBERS[it - 1] }.toSet())
        return lotto
    }
}
