package lotto.view

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val input = readlnOrNull() ?: exitProgram()
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            println("유효하지 않은 금액입니다. 숫자를 입력해 주세요.")
            return readPurchaseAmount()
        }
    }

    fun readWinningNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요. (쉼표로 구분)")
        val input =
            readLine()
                ?: throw IllegalArgumentException("번호를 입력해 주세요.")
        val numbers = input.split(",").map { it.trim().toIntOrNull() }
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "로또 번호는 1부터 45 사이여야 합니다." }
        return numbers.filterNotNull().toSet()
    }

    private fun exitProgram(): Nothing {
        println("프로그램을 종료합니다.")
        kotlin.system.exitProcess(0)
    }
}
