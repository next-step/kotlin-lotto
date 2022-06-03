package lotto.ui

import lotto.Lotto

class InputView {
    fun getPurchaseMoney(): Int {
        println(MESSAGE_REQUIRE_PURCHASE_MONEY)
        return requireNotNull(readln().toIntOrNull())
    }

    fun getWinningLotto(): Lotto {
        println(MESSAGE_REQUIRE_WINNING_LOTTO_NUMBER)
        return InputParser.parse(readln())
    }

    fun getBonusLottoNumber(): Int {
        println(MESSAGE_REQUIRE_BONUS_LOTTO_NUMBER)
        return requireNotNull(readln().toIntOrNull())
    }

    companion object {
        private const val MESSAGE_REQUIRE_PURCHASE_MONEY = "구입금액을 입력해 주세요."
        private const val MESSAGE_REQUIRE_WINNING_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
        private const val MESSAGE_REQUIRE_BONUS_LOTTO_NUMBER = "보너스 볼을 입력해 주세요."
    }
}
