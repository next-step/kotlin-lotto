package controller

import view.InputView

object Reception {
    fun receiveNumberOfLottery(): Int {
        InputView.printInputPrice()
        val readNumber = readLine()!!
        return readNumber.toIntOrNull() ?: throw IllegalArgumentException("value는 숫자여야 합니다. value : $readNumber")
    }
}
