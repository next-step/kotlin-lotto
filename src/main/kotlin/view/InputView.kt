package view

import domain.Lottery
import util.ManualNumberGenerator
import util.Separator

class InputView {

    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val money = readln().toIntOrNull()
        require(money != null) { "구입 금액이 올바르지 않습니다 : $money" }

        return money
    }

    fun getWinningNums(): Set<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val winningNums = readln()

        return Separator.extractIntegers(winningNums).toSet()
    }

    fun getBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusBall = readln().toIntOrNull()
        require(bonusBall != null) { "보너스 볼이 올바르지 않습니다 : $bonusBall" }

        return bonusBall
    }

    fun inputManualSize(): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        val manualSize = readln().toIntOrNull()
        require(manualSize != null) { "수동으로 구매할 로또 수가 잘못되었습니다. : $manualSize" }

        return manualSize
    }

    fun inputManualNums(manualSize: Int): List<Lottery> {
        println("\n수동으로 구매할 번호를 입력해 주세요.")

        return List(manualSize) {
            val winningNums = readln()
            val manualNumberGenerator = ManualNumberGenerator(Separator.extractIntegers(winningNums).toSet())
            Lottery(manualNumberGenerator)
        }
    }
}
