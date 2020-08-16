package lotto.view

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.LottoTicket
import kotlin.system.exitProcess

object Input {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toIntOrNull() ?: exitProcess(-1)
    }

    fun inputManualCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readLine()?.toIntOrNull() ?: exitProcess(-1)
    }

    fun inputManualNumbers(count: Int): LottoTicket {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val list = LottoTicket(emptyList())
        repeat(count) {
            val result = readLine() ?: ""
            if (resultInvalid(result)) {
                list.plus(LottoTicket(listOf(Lotto(result.split(",").map { LottoNumber.from(it.toInt()) }))))
            } else {
                exitProcess(-1)
            }
        }
        return list
    }

    fun inputWinningLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val result = readLine() ?: ""
        return if (resultInvalid(result)) {
            Lotto(result.split(",").map { LottoNumber.from(it.toInt()) })
        } else {
            exitProcess(-1)
        }
    }

    fun inputBonusNumber(lotto: Lotto): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readLine()?.toIntOrNull() ?: exitProcess(-1)
        return if (lotto.matchBonus(LottoNumber.from(bonusNumber))) {
            exitProcess(-1)
        } else {
            return LottoNumber.from(bonusNumber)
        }
    }

    private fun resultInvalid(readLine: String): Boolean {
        return !(readLine.isEmpty() || !readLine.contains(",") || readLine.split(",").size != 6)
    }
}
