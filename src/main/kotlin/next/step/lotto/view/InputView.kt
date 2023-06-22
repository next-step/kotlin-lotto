package next.step.racing.view

import next.step.lotto.domain.Lotto
import next.step.lotto.domain.LottoNumber
import next.step.lotto.domain.Lottos
import next.step.lotto.view.LottoNumberParser

object InputView {

    private const val ENTER_PAYMENT = "구입금액을 입력해 주세요."
    private const val ENTER_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
    private const val ENTER_BONUS_NUBER = "보너스 볼을 입력해 주세요."
    private const val ENTER_MANUAL_NUMBERS_CNT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val ENTER_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요."

    fun readPayment(): Int = read(ENTER_PAYMENT, String::toInt)

    private fun <T> read(enterMsg: String, constructor: (String) -> T): T {
        return try {
            println(enterMsg)
            constructor(readln())
        } catch (e: Exception) {
            OutputView.showError(e.message)
            read(enterMsg, constructor)
        }
    }

    fun readWinningNumbers(): Set<LottoNumber> = read(ENTER_WINNING_NUMBERS) { LottoNumberParser.parse(it) }

    fun readBonusNumber(): LottoNumber = read(ENTER_BONUS_NUBER) { LottoNumber.of(it.toInt()) }

    fun readManualLottos(): Lottos {
        println()
        val cnt = read(ENTER_MANUAL_NUMBERS_CNT, String::toInt)
        println()
        return read(ENTER_MANUAL_NUMBERS, cnt) {
            Lottos.of(it.map { str -> Lotto.of(LottoNumberParser.parse(str)) }.toSet())
        }
    }

    private fun <T> read(enterMsg: String, cnt: Int, constructor: (List<String>) -> T): T {
        return try {
            println(enterMsg)
            constructor((1..cnt).map { readln() })
        } catch (e: Exception) {
            OutputView.showError(e.message)
            read(enterMsg, cnt, constructor)
        }
    }
}
