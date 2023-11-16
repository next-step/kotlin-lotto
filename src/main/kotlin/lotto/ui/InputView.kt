package lotto.ui

object InputView {
    fun receivePurchaseMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val money = readln().toInt()
        return money
    }

    fun receiveWinningNumber(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readln()
        return winningNumbers.split(", ")
            .map { it.toInt() }
            .toSet()
    }

    fun receiveBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusBall = readln().toInt()
        return bonusBall
    }
}
