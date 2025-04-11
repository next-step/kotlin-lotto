package lotto.view

import lotto.Lotto
import lotto.LottoNumber
import lotto.WinningLotto

class InputView {
    fun getPurchaseAmount(): Int {
        println(GUIDE_PURCHASE_AMOUNT)
        return readln().toInt()
    }

    fun getWinningNumbers(): WinningLotto {
        println(GUIDE_WINNING_NUMBER)
        val numbers = getLottoNumbers().map { LottoNumber.of(it) }
        val bonusNumber = getBonusNumber()
        return WinningLotto(Lotto(numbers), bonusNumber)
    }

    fun getManualTicketCount(): Int {
        println(GUIDE_MANUAL_TICKET_COUNT)
        return readln().toInt()
    }

    fun getManualLottosNumbers(): List<Int> {
        println(GUIDE_MANUAL_LOTTO_NUMBER)
        return getLottoNumbers()
    }

    private fun getLottoNumbers(): List<Int> {
        return readln().split(DELIMITER).map { it.trim().toInt() }
    }

    private fun getBonusNumber(): LottoNumber {
        println(GUIDE_BONUS_NUMBER)
        return LottoNumber.of(readln().toInt())
    }

    companion object {
        private const val GUIDE_PURCHASE_AMOUNT = "Please enter the purchase amount."
        private const val GUIDE_WINNING_NUMBER = "Please enter last week's winning numbers"
        private const val GUIDE_BONUS_NUMBER = "Please enter the bonus number"
        private const val GUIDE_MANUAL_TICKET_COUNT = "Enter the number of manual tickets to purchase."
        private const val GUIDE_MANUAL_LOTTO_NUMBER = "Enter the numbers for manual tickets."
        private const val DELIMITER = ","
    }
}
