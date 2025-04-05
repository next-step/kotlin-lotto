package lotto.view

import lotto.Lotto
import lotto.LottoNumber
import lotto.WinningLotto

class InputView {
    fun getPurchaseAmount(): Double {
        println(GUIDE_PURCHASE_AMOUNT)
        return readln().toDouble()
    }

    fun getWinningNumbers(): WinningLotto {
        println(GUIDE_WINNING_NUMBER)
        val numbers = readln().split(DELIMITER).map { LottoNumber.of(it.trim().toInt()) }
        val bonusNumber = getBonusNumber()
        return WinningLotto(Lotto(numbers), bonusNumber)
    }

    private fun getBonusNumber(): LottoNumber {
        println(GUIDE_BONUS_NUMBER)
        return LottoNumber.of(readln().toInt())
    }

    companion object {
        private const val GUIDE_PURCHASE_AMOUNT = "Please enter the purchase amount."
        private const val GUIDE_WINNING_NUMBER = "Please enter last week's winning numbers"
        private const val GUIDE_BONUS_NUMBER = "Please enter the bonus number"
        private const val DELIMITER = ","
    }
}
