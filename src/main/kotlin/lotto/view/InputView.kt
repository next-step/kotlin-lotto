package lotto.view

class InputView {

    companion object {

        fun requireAmountOfPurchaseLotto(): Int {
            println("구입금액을 입력해주세요.")
            return consoleInputInt()
        }

        fun requireWinLottoNum(): List<Int> {
            println("지난 주 당첨 번호를 입력해 주세요.")
            return consoleInputString().replace(" ", "").split(",").map {
                stringToInt(it)
            }
        }

        private fun stringToInt(value: String): Int {
            return try {
                value.toInt()
            } catch (e : NumberFormatException) {
                throw IllegalArgumentException("문자를 숫자로 변경할 수 없습니다.")
            }
        }

        private fun consoleInputInt(): Int = readln().toInt()
        private fun consoleInputString(): String = readln()
    }
}