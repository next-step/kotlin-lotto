package lotto.view

import lotto.domain.Lottery
import lotto.domain.Lotto
import lotto.domain.WinningLotto

object InputView {
    fun getPurchaseAmount(): Int {
        println(TextResource.ENTER_PURCHASE_AMOUNT)
        return readln().toInt()
    }

    fun getManualLottoCount(): Int {
        println(TextResource.ENTER_MANUAL_LOTTO_COUNT)
        return readln().toInt()
    }

    fun getManualLotto(count: Int): Lottery {
        if (count == 0) {
            return Lottery(emptyList())
        }

        println(TextResource.ENTER_MANUAL_LOTTO_NUMBERS)

        return Lottery(
            List(count) { _ ->
                Lotto(
                    readln()
                        .split(",")
                        .map { it.trim().toInt() },
                )
            }
        )
    }

    fun getLastWinnerLotto(): WinningLotto {
        println(TextResource.ENTER_LAST_WINNER_LOTTO)
        val lotto = Lotto(
            readln()
                .split(",")
                .map { it.trim().toInt() },
        )

        return WinningLotto(lotto, getBonusNumber())
    }

    private fun getBonusNumber(): Int {
        println(TextResource.ENTER_BONUS_NUMBER)
        return readln().toInt()
    }
}
