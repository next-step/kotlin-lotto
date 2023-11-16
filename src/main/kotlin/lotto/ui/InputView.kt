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

    fun receiveManualCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요")
        return readln().toInt()
    }

    fun receiveManualNumbers(count: Int): List<Set<Int>> {
        val numbers = mutableListOf<Set<Int>>()
        if (count == 0) return numbers
        println("수동으로 구매할 번호를 입력해 주세요")
        for (i in 1..count) {
            val numberList = readln().split(", ")
                .map { it.toInt() }
                .toSet()
            numbers.add(numberList)
        }
        return numbers
    }
}
