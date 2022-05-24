package lotto.ui

object InputView {

    fun readAmountOfMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun readWinningNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요")
        return readln().split(",")
            .map { it.trim().toInt() }
            .toSet()
    }

    fun readBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}
