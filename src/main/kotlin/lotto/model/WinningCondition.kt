package lotto.model

import lotto.model.number.BonusNumber
import lotto.model.number.WinningNumbers

data class WinningCondition(val winningNumbers: WinningNumbers, val bonusNumber: BonusNumber)
