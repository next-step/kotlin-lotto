package camp.nextstep.edu.step.step2.domain.lotto

import camp.nextstep.edu.step.step2.domain.number.Number

data class WinningLotto(
    val winningLotto: Lotto,
    val bonusNumber: Number
) {

    init {
        require(winningLotto.numbers.isNotEmpty()) { "당첨번호가 입력되지 않았습니다." }
        // winningLotto 내 Number들과 bonusNumber가 중복되는지 검사
        require(!winningLotto.isDuplicateNumber(bonusNumber)) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

}
