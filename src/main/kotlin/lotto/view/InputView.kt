package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Money

object InputView {
    private const val INPUT_MONEY = "구입금액을 입력해 주세요."
    private const val INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val MAX_NUMBER_SUFFIX = "개 까지 구매할 수 있습니다."
    private const val INPUT_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요."
    private const val INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "지난 주 보너스 번호를 입력해 주세요."
    private const val INVALID_WINNING_NUMBER = "콤마(,)로 연결되고 중복되지 않은 6자리 숫자를 입력하세요."
    private const val ERROR_INVALID_STRING = "틀린 형식입니다."
    private const val REQUIRE_MORE_THAN_THOUSAND = "1000원 이상의 숫자를 넣어주세요."
    private const val LOTTO_PRICE = 1000
    private const val DELIMITER = ","

    fun inputMoney(): Money {
        println(INPUT_MONEY)
        return getMoney()
    }

    private fun getMoney() = try {
        val money = readLine()!!.toInt()
        require(money >= LOTTO_PRICE) { REQUIRE_MORE_THAN_THOUSAND }
        Money(money)
    } catch (e: Throwable) {
        println("$ERROR_INVALID_STRING ${e.message}")
        inputMoney()
    }

    fun inputManualNumberCount(money: Money): Int {
        println(INPUT_MANUAL_COUNT)
        return try {
            val value = readLine()!!.toInt()
            val maxNumber = (money / 1000).toInt()
            require(value <= maxNumber) { "$maxNumber$MAX_NUMBER_SUFFIX" }
            value
        } catch (e: Throwable) {
            println(e.message)
            inputManualNumberCount(money)
        }
    }

    fun inputManualNumber(count: Int): List<Lotto> {
        println(INPUT_MANUAL_NUMBER)
        val lottos = mutableListOf<Lotto>()
        for (i in 1..count) {
            try {
                val value = readLine()!!
                lottos.add(Lotto(value.split(DELIMITER).map { it.toInt() }))
            } catch (e: Throwable) {
                println(e.message)
                inputManualNumber(count)
            }
        }
        return lottos
    }

    fun inputWinningNumber(): Lotto {
        println(INPUT_WINNING_NUMBER)
        val value = readLine() ?: throw IllegalArgumentException(INVALID_WINNING_NUMBER)
        return getWinningNumber(value)
    }

    private fun getWinningNumber(value: String): Lotto {
        return try {
            Lotto(value.split(DELIMITER).map { it.toInt() })
        } catch (e: Throwable) {
            println("$ERROR_INVALID_STRING ${e.message}")
            inputWinningNumber()
        }
    }

    fun inputBonusNumber(): LottoNumber {
        println(INPUT_BONUS_NUMBER)
        return getBonusNumber()
    }

    private fun getBonusNumber() = try {
        LottoNumber.of(readLine()!!.toInt())
    } catch (e: Throwable) {
        println("$ERROR_INVALID_STRING ${e.message}")
        inputBonusNumber()
    }
}
