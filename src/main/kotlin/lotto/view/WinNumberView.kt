package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinNumbers

class WinNumberView(private val io: IO) {

    fun readWinNumbers(): WinNumbers {
        io.print("")
        io.print("지난 주 당첨 번호를 입력해 주세요.")

        val winNumbers = read()

        io.print("")

        return winNumbers
    }

    private tailrec fun read(): WinNumbers {
        val result = io.read()
            .replace(" ", "")
            .split(',')
            .mapNotNull { it.toIntOrNull() }

        if (result.size != Lotto.NUMBER_COUNT) {
            io.print("유효한 당첨번호를 입력해주세요.")
            return read()
        }

        return WinNumbers(result)
    }
}
