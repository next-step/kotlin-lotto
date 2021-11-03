package lotto.ui

import lotto.domain.ExceptionType.INPUT_MUST_NOT_NULL
import lotto.domain.ExceptionType.TRY_INPUT_MUST_UNSIGNED_INT

object InputView {
    private val unsignedNumberRegex = "\\d*".toRegex()

    private fun isUnsignedInt(s: String) = s.matches(unsignedNumberRegex)

    fun readInputForLottoGameBudget(): Int {
        val tryInput = readLine()
        requireNotNull(tryInput) { INPUT_MUST_NOT_NULL }
        require(isUnsignedInt(tryInput)) { TRY_INPUT_MUST_UNSIGNED_INT }
        return tryInput.toInt()
    }
}
