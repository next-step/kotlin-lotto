package lotto.view

object InputView {
    fun getPurchaseAmount(): Int {
        println("구매금액을 입력해 주세요.")
        val amount = readln()
        require(amount.isNotEmpty()) { "금액을 입력해주세요." }

        println(amount)

        return amount.toInt()
    }

    fun getNumberOfPurchases(count: Int) {
        println("$count 개를 구매했습니다.")
    }

    fun getWinningNumber(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumber = readln()
        require(winningNumber.isNotEmpty()) { "당첨 번호를 입력해주세요." }

        val numbers = winningNumber.split(", ").map { it.toInt() }.toSet()
        require(numbers.size == 6) { " 중복없는 6개의 숫자를 입력해주세요." }

        return numbers
    }
}
