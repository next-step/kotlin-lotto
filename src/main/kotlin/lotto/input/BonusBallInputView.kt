package lotto.input

import lotto.LottoMessageConst.Companion.ERROR_MESSAGE_EMPTY
import lotto.domain.BonusBall
import lotto.domain.Lotto
import lotto.domain.LottoNumber

class BonusBallInputView() {
    companion object {
        private const val ERROR_MESSAGE_INVALID = "올바른 보너스번호를 입력하세요"

        fun process(
            winLotto: Lotto,
            input: String?,
        ): BonusBall {
            return BonusBall(winLotto, parseAndValidate(input))
        }

        fun process(winLotto: Lotto): BonusBall {
            while (true) {
                try {
                    println("보너스 볼을 입력해 주세요.")
                    return process(winLotto, readln())
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        private fun parseAndValidate(bonusBall: String?): LottoNumber {
            requireNotNull(bonusBall) { ERROR_MESSAGE_EMPTY }
            require(bonusBall.isNotBlank()) { ERROR_MESSAGE_EMPTY }
            requireNotNull(bonusBall.toIntOrNull()) { ERROR_MESSAGE_INVALID }

            return LottoNumber(bonusBall.toInt())
        }
    }
}
