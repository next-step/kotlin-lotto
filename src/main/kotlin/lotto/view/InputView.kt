package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

object InputView {
    private const val ASK_LOTTO_BUY_MONEY = "구입금액을 입력해주세요."
    private const val ASK_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해주세요."
    private const val ASK_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해주세요."
    private const val ASK_WINNING_LOTTO_NUMBERS = "지난주 당첨 번호를 입력해주세요."
    private const val ASK_WINNING_LOTTO_BONUS_NUMBER = "보너스 볼을 입력해 주세요."

    fun askLottoMoney(): Int {
        println(ASK_LOTTO_BUY_MONEY)
        return readln().toInt()
    }

    fun askManualLottoCount(): Int {
        println(ASK_MANUAL_LOTTO_COUNT)
        return readln().toInt()
    }

    fun askManualLottoNumbers(manualLottoCount: Int): List<LottoNumbers> {
        println(ASK_MANUAL_LOTTO_NUMBERS)
        val result = mutableListOf<LottoNumbers>()
        repeat(manualLottoCount) {
            result.add(LottoNumbers(readln().split(",").map { it.trim().toInt() }.map { LottoNumber.from(it) }))
        }
        return result
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
