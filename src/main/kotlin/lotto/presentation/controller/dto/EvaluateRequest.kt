package lotto.presentation.controller.dto

class EvaluateRequest private constructor(
    val winningTicket: List<Int>,
    val bonusNumber: Int,
) {

    companion object {
        fun from(inputWinNumbers: List<Int>, inputBonusNumber: Int): EvaluateRequest {
            return EvaluateRequest(inputWinNumbers, inputBonusNumber)
        }
    }
}
