package lotto.view

class InputView {
    fun getPurchaseAmount(): Int? {
        println("구입금액을 입력해 주세요.")
        val input = readlnOrNull()
        if (input.isNullOrEmpty()) {
            println("아무값도 입력되지 않았습니다.")
            return null
        }
        if (input.toIntOrNull() == null) {
            println("숫자만 입력 가능합니다.")
            return null
        }
        return input.toInt()
    }

    fun getWinningNumbers(): List<Int>? {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input = readlnOrNull()
        if (input.isNullOrEmpty()) {
            println("아무값도 입력되지 않았습니다.")
            return null
        }
        val slicedInput = input.split(",")
        slicedInput.forEach {
            if (it.toIntOrNull() == null) {
                println("숫자만 입력 가능합니다.")
                return null
            }
        }
        return slicedInput.map { it.toInt() }
    }
}
