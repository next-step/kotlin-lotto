package simulator.io

import simulator.lotto.Number
import simulator.lotto.Numbers

class Input {
    fun getMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getBonusNumber(): Number {
        println("보너스 볼을 입력해 주세요.")
        return Number(readln().toInt())
    }

    fun getWinningNumbers(): Numbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return Numbers(readln().split(",")
            .map { Number(it.toInt()) })
    }
}