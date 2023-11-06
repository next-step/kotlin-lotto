package lotto.view

object InputView {
    fun getAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("Invalid input")
    }

    fun getWinningNumbers(): Set<Int> {
        while (true) {
            println("지난 주 당첨 번호를 입력해 주세요.")
            val input = readln().split(",").mapNotNull { it.trim().toIntOrNull() }.toSet()
            if (input.size == 6 && input.all { it in 1..45 }) {
                return input
            } else {
                println("당첨 번호는 1에서 45 사이의 숫자 6개여야 합니다. 정확히 입력해주세요.")
            }
        }
    }
}
