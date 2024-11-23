package lotto.view

import lotto.BoughtLotto
import lotto.Lotto
import lotto.WinningLotto

class InputView {
    fun input(): BoughtLotto {
        val lottos = inputMoney()
        val winningLotto = inputWinningLotto()

        return BoughtLotto(
            lottos = lottos,
            winningLotto = winningLotto
        )
    }

    private fun inputMoney(): List<Lotto> {
        println("구입금액을 입력해 주세요.")
        return try {
            val maybeMoney = readlnOrNull()
            val money = (maybeMoney?.toInt()
                ?: throw IllegalArgumentException("구입금액은 필수입니다."))
            val boughtLottoAmount = money / 1000
            (1..boughtLottoAmount).map { Lotto.auto() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.")
        }
    }

    private fun inputWinningLotto(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return try {
            val maybeWinningNumbers = readlnOrNull()
            val winningNumbers = (maybeWinningNumbers?.split(",")?.map { it.toInt() }
                ?: throw IllegalArgumentException("지난 주 당첨 번호는 필수입니다."))
            WinningLotto(Lotto(winningNumbers))
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("지난 주 당첨 번호는 숫자만 입력 가능합니다.")
        }
    }
}