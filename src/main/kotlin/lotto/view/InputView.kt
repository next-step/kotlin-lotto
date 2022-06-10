package lotto.view

import lotto.domain.LottoNumber

object InputView {
    private const val ASK_LOTTO_BUY_MONEY = "구입금액을 입력해주세요."
    private const val ASK_WINNING_LOTTO_NUMBERS = "지난주 당첨 번호를 입력해주세요."
    private const val ASK_WINNING_LOTTO_BONUS_NUMBER = "보너스 볼을 입력해 주세요."

    fun askLottoMoney(): Int {
        println(ASK_LOTTO_BUY_MONEY)
        return readln().toInt()
    }

    fun askWinningLottoNumbers(): List<LottoNumber> {
        println(ASK_WINNING_LOTTO_NUMBERS)
        return readln().split(",").map { it.trim().toInt() }.map { LottoNumber.from(it) }
    }

    fun askWinningLottoBonusNumber(): LottoNumber {
        println(ASK_WINNING_LOTTO_BONUS_NUMBER)
        return LottoNumber.from(readln().toInt())
    }
}
