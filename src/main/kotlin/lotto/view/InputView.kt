package lotto.view

import lotto.model.Lotto
import lotto.model.LottoNo
import lotto.model.Money

const val WINNER_NUMBER_DELIMITER = ","

object InputView {
    fun getAmountOfMoney(): Money {
        println("구입금액을 입력해 주세요.")

        return Money(readLine()!!.toInt())
    }

    fun getWinnerLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val winner = readLine().toString().split(WINNER_NUMBER_DELIMITER)

        return Lotto(winner.map { LottoNo(it) })
    }

    fun getBonusNumber(): LottoNo {
        println("보너스 볼을 입력해 주세요.")

        return LottoNo(readLine()!!)
    }
}
