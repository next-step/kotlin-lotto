package lotto.provider.winningnumber

import lotto.domain.WinningNumber

interface WinningNumberProvider {
    fun provide(): WinningNumber
}
