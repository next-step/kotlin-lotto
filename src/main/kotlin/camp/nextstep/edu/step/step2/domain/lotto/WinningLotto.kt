package camp.nextstep.edu.step.step2.domain.lotto

import camp.nextstep.edu.step.step2.domain.number.BonusNumber

data class WinningLotto(
    val winningLotto: Lotto,
    val bonusNumber: BonusNumber
) {

    init {
        require(winningLotto.numbers.isNotEmpty()) { "당첨번호가 입력되지 않았습니다." }
    }

}
