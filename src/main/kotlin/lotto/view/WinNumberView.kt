package lotto.view

import lotto.domain.WinNumbers

class WinNumberView(private val io: IO) {

    fun readWinNumbers(): WinNumbers {
        io.print("")
        io.print("")

        return WinNumbers(listOf(1, 2, 3, 4, 5, 6))
    }
}
