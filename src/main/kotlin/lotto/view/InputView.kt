package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber

private const val MONEY_STRING = "구입금액을 입력해 주세요."

private const val BONUS_STRING = "보너스 볼을 입력해 주세요."

private const val LAST_NUM_STRING = "\n지난 주 당첨 번호를 입력해 주세요."

private const val MANUAL_NUM_STRING = "\n수동으로 구매할 로또 수를 입력해 주세요."

private const val MANUAL_LOTTO_STRING = "\n수동으로 구매할 번호를 입력해 주세요."

object InputView {
    fun getMoney(): Int {
        println(MONEY_STRING)
        return readln().toInt()
    }

    fun getManualLotto(): Int {
        println(MANUAL_NUM_STRING)
        return readln().toInt()
    }

    fun getManualLotto(num: Int): List<Lotto> {
        if (num == 0) {
            return listOf()
        }
        println(MANUAL_LOTTO_STRING)
        return List(num) { Lotto(readln().split(",").map { LottoNumber(it.trim().toInt()) }) }
    }

    fun getWinningLottoNums(): Lotto {
        println(LAST_NUM_STRING)
        return Lotto(readln().split(",").map { LottoNumber(it.trim().toInt()) })
    }

    fun getBonusNum(): Int {
        println(BONUS_STRING)
        return readln().toInt()
    }
}
