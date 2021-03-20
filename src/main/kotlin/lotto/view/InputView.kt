package lotto.view

import lotto.domain.LottoCount

object InputView {
    private const val BUYING_COMMENT = "구입금액을 입력해 주세요."
    private const val LAST_WEEK_WINNING_LOTTO_NUMBERS_COMMENT = "지난 주 당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_COMMENT = "보너스 볼을 입력해 주세요."
    private const val MANUAL_LOTTO_COUNT_COMMENT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val MANUAL_LOTTO_NUMBERS_COMMENT = "수동으로 구매할 번호를 입력해 주세요."

    fun enterLottoBuyingPrice(): Int {
        println(BUYING_COMMENT)
        return readLine()?.toInt() ?: throw IllegalArgumentException()
    }

    fun enterLastWeekWinningLottoNumbers(): String {
        println(LAST_WEEK_WINNING_LOTTO_NUMBERS_COMMENT)
        return readLine() ?: throw IllegalArgumentException()
    }

    fun enterBonusNumber(): Int {
        println(BONUS_NUMBER_COMMENT)
        return readLine()?.toInt() ?: throw IllegalArgumentException()
    }

    fun enterManualLottoCount(): Int {
        println(MANUAL_LOTTO_COUNT_COMMENT)
        return readLine()?.toInt() ?: throw IllegalArgumentException()
    }

    fun enterManualLottoNumbers(manualCount: LottoCount): String {
        if (manualCount.isEmpty()) return ""
        println(MANUAL_LOTTO_NUMBERS_COMMENT)
        return readLine() ?: throw IllegalArgumentException()
    }
}
