package lotto.view

import lotto.domain.Lotto
import lotto.domain.Money

class InputView {

    fun inputMoney(): Money {
        println("구입금액을 입력해 주세요.")
        return Money(readln().toInt())
    }

    fun inputManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun inputManualLotto(manualLottoCount: Int): List<Lotto> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..manualLottoCount).map {
            println("{$it}번 로또 번호를 입력해 주세요.")
            inputLotto()
        }
    }

    fun inputWinningLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return inputLotto()
    }

    private fun inputLotto(): Lotto {
        return Lotto(readln().split(",").map { it.trim().toInt() }.toSet())
    }

    fun inputBonusBall(): Int {
        println("보너스 볼을 입력해 주세요..")
        return readln().toInt()
    }
}
