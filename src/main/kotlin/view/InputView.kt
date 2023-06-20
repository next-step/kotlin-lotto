package view

import domain.Lottery
import util.InputReader
import util.ManualNumberGenerator
import util.Separator

class InputView(
    private val inputReader: InputReader = InputReader { readln() },
) {

    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val money = inputReader.raedLine()
        require(money.toIntOrNull() != null) { "구입 금액이 올바르지 않습니다 : $money" }
        return money.toInt()
    }

    fun getWinningNums(): Set<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val winningNums = inputReader.raedLine()
        return Separator.extractIntegers(winningNums).toSet()
    }

    fun getBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusBall = inputReader.raedLine().toIntOrNull()
        require(bonusBall != null) { "보너스 볼이 올바르지 않습니다 : $bonusBall" }
        return bonusBall.toInt()
    }

    fun inputManualSize(): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        val manualSize = inputReader.raedLine().toIntOrNull()
        require(manualSize != null) { "수동으로 구매할 로또 수가 잘못되었습니다. : $manualSize" }

        return manualSize
    }

    fun inputManualNums(manualSize: Int): MutableList<Lottery> {
        println("\n수동으로 구매할 번호를 입력해 주세요.")
        val results = mutableListOf<Lottery>()
        for (idx in 1..manualSize) {
            val winningNums = inputReader.raedLine()
            val manualNumberGenerator = ManualNumberGenerator(Separator.extractIntegers(winningNums).toSet())
            results.add(Lottery(manualNumberGenerator))
        }
        return results
    }
}
