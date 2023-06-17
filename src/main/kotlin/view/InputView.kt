package view

import util.Separator

class InputView(private val inputReader: InputReader) {

    fun buyLotto(): Int {
        val money = enterMoney()
        require(money > 1000) { "돈이 부족합니다." }

        val lottoSize = money / 1000
        println("${lottoSize}개를 구매했습니다.")

        return lottoSize
    }

    private fun enterMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val money = inputReader.raedLine()
        require(money.toIntOrNull() != null) { "구입 금액이 올바르지 않습니다 : $money" }
        return money.toInt()
    }

    fun registerWinningNums(): List<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val winningNums = inputReader.raedLine()
        return Separator.extractIntegers(winningNums)
    }

    fun registerBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusBall = inputReader.raedLine().toIntOrNull()
        require(bonusBall != null && bonusBall in 1..45) { "보너스 볼이 올바르지 않습니다 : $bonusBall" }
        return bonusBall.toInt()
    }
}
