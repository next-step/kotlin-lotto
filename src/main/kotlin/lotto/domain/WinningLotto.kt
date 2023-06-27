package lotto.domain

import lotto.domain.LottoErrorMessage.BONUS_NUMBERS_MUST_NOT_DIFFERENT_FROM_WINNING_NUMBER

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: LottoNumber
) {
    init {
        require(lotto.isCatchBonus(this).not()) { BONUS_NUMBERS_MUST_NOT_DIFFERENT_FROM_WINNING_NUMBER }
    }
}
