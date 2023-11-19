package lotto.presentation.controller

import lotto.domain.LottoNumber

class EvaluateRequest private constructor(
    val winningTicket: List<Int>,
    val bonusNumber: Int,
) {

    companion object {
        fun from(inputWinNumbers: String, inputBonusNumber: String): EvaluateRequest {
            val winningTicket = inputWinNumbers
                .replace(" ", "")
                .split(",")
                .map { it.toIntOrNull() ?: throw IllegalArgumentException("우승자 번호는 숫자여야 합니다.") }
            val bonusNumber = inputBonusNumber.toIntOrNull() ?: throw IllegalArgumentException("보너스볼 번호는 숫자여야 합니다.")

            return EvaluateRequest(winningTicket, bonusNumber)
        }
    }
}

// TODO : Winning Lotto 효용성이 낮아서, 별도 선언하지 않았습니다.
class WinningNumber(
    val lottoNumber: LottoNumber
)
