package lotto.view

import lotto.domain.Lottery
import lotto.domain.Lotto
import lotto.domain.WinningLotto

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualLotto(count: Int): Lottery {
        println("수동으로 구매할 번호를 입력해 주세요.")

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
        println("지난 주 당첨 번호를 입력해 주세요.")
        val lotto = Lotto(
            readln()
                .split(",")
                .map { it.trim().toInt() },
        )

        return WinningLotto(lotto, getBonusNumber())
    }

    private fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}
