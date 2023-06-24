package lotto.view

interface InputView {
    fun getPurchaseAmount(): Int
    fun getWinningNumbers(): List<Int>
    fun getBonusNumber(): Int
}
