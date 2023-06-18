package view

import util.Separator

class InputView(private val inputReader: InputReader) {

    fun enterMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val money = inputReader.raedLine()
        require(money.toIntOrNull() != null) { "구입 금액이 올바르지 않습니다 : $money" }
        return money.toInt()
    }

    fun registerWinningNums(): Set<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val winningNums = inputReader.raedLine()
        return Separator.extractIntegers(winningNums).toSet()
    }
}
