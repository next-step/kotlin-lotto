package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Money

object InputView {
    private const val INPUT_MONEY = "구입금액을 입력해 주세요."
    private const val INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val INPUT_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요."
    private const val INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "지난 주 보너스 번호를 입력해 주세요."
    private const val INVALID_WINNING_NUMBER = "콤마(,)로 연결되고 중복되지 않은 6자리 숫자를 입력하세요."
    private const val REQUIRE_MORE_THAN_THOUSAND = "1000원 이상의 숫자를 넣어주세요."
    private const val LOTTO_PRICE = 1000
    private const val DELIMITER = ","
    private const val ZERO = 0

    tailrec fun inputMoney(): Money {
        println(INPUT_MONEY)
        return readLine()
            ?.toInt()
            ?.takeIf { it >= LOTTO_PRICE }
            ?.toMoneyOrNull()
            ?: inputMoney()
    }

    private fun Int.toMoneyOrNull(): Money? {
        return try {
            Money(this)
        } catch (e: IllegalArgumentException) {
            println("$REQUIRE_MORE_THAN_THOUSAND ${e.message}")
            null
        }
    }

    tailrec fun inputManualNumberCount(money: Money): Int {
        println(INPUT_MANUAL_COUNT)
        val maxNumber = (money / 1000).toInt()
        return readLine()
            ?.toInt()
            ?.takeIf { it in 0..maxNumber }
            ?: inputManualNumberCount(money)
    }

    tailrec fun getLotto(): Lotto {
        return readLine()
            ?.toLottoOrNull()
            ?: getLotto()
    }

    fun inputManualNumber(count: Int): List<Lotto> {
        if (count == ZERO) return emptyList()
        println(INPUT_MANUAL_NUMBER)
        return (1..count).map { getLotto() }
    }

    private fun String.toListLottoOrNull(count: Int): List<Lotto>? {
        return try {
            val lottos = mutableListOf<Lotto>()
            for (i in 1..count) {
                val lotto = Lotto(this.split(DELIMITER).map { it.toInt() })
                lottos.add(lotto)
            }
            lottos
        } catch (e: IllegalArgumentException) {
            println(e.message)
            null
        }
    }

    tailrec fun inputWinningNumber(): Lotto {
        println(INPUT_WINNING_NUMBER)
        return readLine()
            ?.toLottoOrNull()
            ?: inputWinningNumber()
    }

    private fun String.toLottoOrNull(): Lotto? {
        return try {
            Lotto(this.split(DELIMITER).map { it.toInt() })
        } catch (e: IllegalArgumentException) {
            println("$INVALID_WINNING_NUMBER ${e.message}")
            null
        }
    }

    fun inputBonusNumber(): LottoNumber {
        println(INPUT_BONUS_NUMBER)
        return readLine()
            ?.toInt()
            ?.toLottoNumberOrNull()
            ?: inputBonusNumber()
    }

    private fun Int.toLottoNumberOrNull(): LottoNumber {
        return LottoNumber.of(this)
    }
}
