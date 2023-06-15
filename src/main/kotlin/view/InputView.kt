package view

import util.Separator

class InputView(private val inputReader: InputReader) {

    fun buyLotto(): Int {
        val money = enterMoney()
        val lottoSize = money / 1000
        println("${lottoSize}개를 구매했습니다.")
        return lottoSize
    }

    private fun enterMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val money = inputReader.raedLine()
        require(money.toIntOrNull() != null) { "구입 금액이 올바르지 않습니다 : $money" }
        println(money)
        return money.toInt()
    }

    fun registerWinningNums(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNums = inputReader.raedLine()
        println(winningNums)
        return Separator.extractIntegers(winningNums)
    }
}
