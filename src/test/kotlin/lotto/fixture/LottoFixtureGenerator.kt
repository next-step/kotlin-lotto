package lotto.fixture

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningNumber

object LottoFixtureGenerator {
    fun winningNumberFixture(bonusNumber: Int, vararg inputs: Int): WinningNumber {
        val lottoFixture = lottoFixture(*inputs)
        val bonusNumberFixture = bonusNumberFixture(bonusNumber)
        return WinningNumber.of(lottoFixture, bonusNumberFixture)
    }

    private fun lottoFixture(vararg inputs: Int): Lotto = Lotto.of(inputs.toSet())

    fun bonusNumberFixture(input: Int): LottoNumber = LottoNumber.of(input)
}
