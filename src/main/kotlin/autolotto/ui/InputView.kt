package autolotto.ui

import autolotto.vo.AutoLotto
import autolotto.vo.WinningLotto

object InputView {
    fun promptForAutoLotto(): AutoLotto {
        println("구입금액을 입력해 주세요.")
        val price = readln().toLongOrNull() ?: throw IllegalArgumentException("가격 입력이 올바르지 않습니다.")
        return AutoLotto(price).also { autoLotto ->
            println("로또 ${autoLotto.count}개를 구매했습니다.")
            autoLotto.lottos.forEach { lotto ->
                println(lotto.numbers)
            }
        }
    }

    fun promptForWinningLotto(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val lastWeekWinningNumbers = readln()
        return WinningLotto(lastWeekWinningNumbers)
    }
}