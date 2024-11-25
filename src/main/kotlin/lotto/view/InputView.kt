package lotto.view

interface InputView {
    fun requestPrice(): Int

    fun requestWinningNumbers(): List<Int>
}
