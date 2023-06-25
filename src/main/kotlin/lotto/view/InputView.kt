package lotto.view

interface InputView {
    fun getPurchaseAmount(): Int
    fun getCountOfPurchaseManually(): Int
    fun getNumbersOfManuallyLotto(countOfPurchaseManually: Int): List<List<Int>>
    fun getWinningNumbers(): List<Int>
    fun getBonusNumber(): Int
}
