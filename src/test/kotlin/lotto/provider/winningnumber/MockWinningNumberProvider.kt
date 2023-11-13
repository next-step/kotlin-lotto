package lotto.provider.winningnumber

import lotto.domain.WinningNumber

class MockWinningNumberProvider(private val winningNumber: WinningNumber) : WinningNumberProvider {
    override fun provide(): WinningNumber = winningNumber
}
