package lotto.view

object InputView {

    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputWinningNumber(): List<Int> {
        println()
        println("지난 주 당첨 번호를 입력해 주세요.")

        val tokens = readln().split(", ")

        return tokens.map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")

        return readln().toInt()
    }
}
