package lotto.view

class InputView {

    companion object {

        fun requireAmountOfPurchaseLotto(): Int {
            println("구입금액을 입력해주세요.")
            return readInt()
        }

        fun requireWinLottoNum(): List<Int> {
            println("지난 주 당첨 번호를 입력해 주세요.")
            return readString().replace(" ", "").split(",").map {
                stringToInt(it)
            }
        }

        fun requireWinBonusNum(): Int {
            println("보너스 볼을 입력해주세요.")
            return readInt()
        }

        private fun stringToInt(value: String): Int {
            return value.toIntOrNull() ?: throw IllegalArgumentException("문자를 숫자로 변경할 수 없습니다.")
        }

        private fun readInt(): Int = readln().toInt()
        private fun readString(): String = readln()
    }
}