package simulator.io

import simulator.lotto.Lotto
import simulator.lotto.Number
import simulator.lotto.Numbers

class Input {
    fun getMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualCount():Int{
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun getBonusNumber(): Number {
        println("보너스 볼을 입력해 주세요.")
        return Number(readln().toInt())
    }

    fun getManualNumbers(manualCount:Int): List<Lotto> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(manualCount) {
            Lotto(getNumbers())
        }
    }

    fun getWinningNumbers(): Numbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return getNumbers()
    }

    private fun getNumbers(): Numbers {
        return Numbers(readln().split(",")
            .map { Number(it.toInt()) })
    }
}