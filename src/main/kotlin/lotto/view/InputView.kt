package lotto.view

import lotto.domain.WinnerNumbers

object InputView {
    const val WINER_TEXT_DELIMITER = ","

    fun getCash(): Int {
        println("구매금액을 입력해 주세요.")
        return readPositiveNumber()
    }

    private fun readPositiveNumber(): Int {
        val str = readLine()
        if (str.isNullOrEmpty() || !isPositiveNumber(str)) {
            println("잘못된 입력입니다. 다시 입력해주세요.")
            return readPositiveNumber()
        }
        return str.toInt()
    }

    fun getWinner(): WinnerNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readWinner()
    }

    private fun readWinner(): WinnerNumbers {
        val str = readLine()
        if (isInvalidWinnerString(str)) {
            println("잘못된 입력입니다. 다시 입력해주세요.")
            return readWinner()
        }

        return WinnerNumbers(str!!.split(WINER_TEXT_DELIMITER).map { it.trim().toInt() })
    }

    private fun isInvalidWinnerString(str: String?): Boolean {
        return str.isNullOrEmpty() ||
            str.split(WINER_TEXT_DELIMITER).size != 6 ||
            !str.split(WINER_TEXT_DELIMITER).map { it.trim() }.all { isPositiveNumber(it) }
    }

    private fun isPositiveNumber(str: String): Boolean {
        return str.all { it.isDigit() }
    }
}
