package lotto

interface InputView {
    fun requestPrice(): Int

    fun requestWinningNumbers(): List<Int>
}
