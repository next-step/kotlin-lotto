package lotto.ui

object InputView {
    fun receivePurchaseMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val money = readln().toInt()
        return money
    }

    fun receiveWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readln()
        return winningNumbers.split(", ")
            .toList()
            .map { it.toInt() }
    }

    fun receiveBonusBall(winningNumber: List<Int>): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusBall = readln().toInt()
        if (winningNumber.contains(bonusBall)) {
            throw IllegalArgumentException("보너스 볼은 당첨 번호 중 하나와 같을 수 없습니다.")
        }
        return bonusBall
    }
}
