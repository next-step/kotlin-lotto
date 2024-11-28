package lotto.view

interface InputView {
    fun requestPrice(): Int

    fun requestManualLottoCount(): Int

    fun requestManualLottoNumbers(count: Int): List<List<Int>>

    fun requestWinningNumbers(): List<Int>

    fun requestBonusNumber(): Int
}
