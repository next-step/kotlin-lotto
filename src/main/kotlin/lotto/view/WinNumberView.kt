package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinNumbers

class WinNumberView(private val io: IO) {

    fun readWinNumbers(): WinNumbers {
        io.print("")
        io.print("지난 주 당첨 번호를 입력해 주세요.")

        val winNumbers = readNumbers()

        io.print("보너스 볼을 입력해 주세요.")

        val bonus = readBonus(winNumbers)

        io.print("")

        return WinNumbers(winNumbers, bonus)
    }

    private tailrec fun readNumbers(): List<LottoNumber> {
        val result = io.read()
            .replace(" ", "")
            .split(',')
            .mapNotNull { it.toIntOrNull() }

        if (result.size != Lotto.NUMBER_COUNT) {
            io.print("유효한 당첨번호를 입력해주세요.")
            return readNumbers()
        }

        return result.map(::LottoNumber)
    }

    private tailrec fun readBonus(winNumbers: List<LottoNumber>): LottoNumber {
        val result = io.read().toIntOrNull()

        if (result == null) {
            io.print("유효한 보너스 볼을 입력해주세요.")
            return readBonus(winNumbers)
        }

        if (winNumbers.contains(LottoNumber(result))) {
            io.print("당첨 번호와 중복되지 않는 보너스 볼을 입력해주세요.")
            return readBonus(winNumbers)
        }

        return LottoNumber(result)
    }
}
