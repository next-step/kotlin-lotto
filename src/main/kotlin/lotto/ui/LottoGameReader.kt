package lotto.ui

import lotto.domain.LottoNumber

object LottoGameReader {
    fun readAmount(): Int {
        LottoGamePrinter.printAmountMessage()
        val str = ConsoleReader.readLine()
        return convertToNumber(str)
    }

    fun readWinningLottoNumbers(): Set<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return ConsoleReader.readLine().split(",")
            .map { str -> convertToNumber(str) }
            .map { number -> LottoNumber(number) }
            .toSet()
    }

    private fun convertToNumber(str: String): Int {
        val number = str.trim().toIntOrNull()
        requireNotNull(number) { "숫자만 입력해야 합니다. 현재 입력=$str" }
        return number
    }
}
