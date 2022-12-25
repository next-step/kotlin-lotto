package lotto.view

object InputView {
    fun getPurchaseAmount(): Int {
        println("구매금액을 입력해 주세요.")
        val amount = readln()
        require(amount.isNotEmpty()) { "금액을 입력해주세요." }

        return amount.toInt()
    }

    fun getNumberOfPurchases(count: Int) {
        println("$count 개를 구매했습니다.")
    }

    fun getWinningNumber(): Pair<Set<Int>, Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumber = readln()
        require(winningNumber.isNotEmpty()) { "당첨 번호를 입력해주세요." }

        val numbers = winningNumber.split(", ").map { it.toInt() }.toSet()
        require(numbers.size == 6) { " 중복없는 6개의 숫자를 입력해주세요." }

        println("보너스 볼을 입력해 주세요.")
        val bonusBall = readln().toInt()
        require(!numbers.contains(bonusBall)) { "보너스 볼은 당첨 번호와 중복될 수 없습니다." }

        return numbers to bonusBall
    }
}
