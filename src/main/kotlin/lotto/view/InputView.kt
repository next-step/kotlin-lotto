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
        var money: Money? = null
        while (money == null) {
            println(INPUT_MONEY)
            money = try {
                val value = readLine()!!.toInt()
                require(value >= LOTTO_PRICE) { REQUIRE_MORE_THAN_THOUSAND }
                Money(value)
            } catch (e: Throwable) {
                println("$ERROR_INVALID_STRING ${e.message}")
                null
            }
        }
        return money
    }

    fun inputManualNumberCount(money: Money): Int {
        var count: Int? = null
        while (count == null) {
            println(INPUT_MANUAL_COUNT)
            count = try {
                val value = readLine()!!.toInt()
                val maxNumber = (money / 1000).toInt()
                require(value <= maxNumber) { "$maxNumber$MAX_NUMBER_SUFFIX" }
                value
            } catch (e: Throwable) {
                println(e.message)
                null
            }
        }
        return count
    }

    fun inputManualNumber(count: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        while (lottos.size != count) {
            println(INPUT_MANUAL_NUMBER)
            for (i in 1..count) {
                try {
                    val value = readLine()!!
                    val lotto = Lotto(value.split(DELIMITER).map { it.toInt() })
                    lottos.add(lotto)
                } catch (e: Throwable) {
                    println(e.message)
                }
            }
        }
        return lottos
    }

    fun inputWinningNumber(): Lotto {
        var lotto: Lotto? = null
        while (lotto == null) {
            println(INPUT_WINNING_NUMBER)
            lotto = try {
                val value = readLine() ?: throw IllegalArgumentException(INVALID_WINNING_NUMBER)
                Lotto(value.split(DELIMITER).map { it.toInt() })
            } catch (e: Throwable) {
                println("$ERROR_INVALID_STRING ${e.message}")
                null
            }
        }
        return lotto
    }

    fun inputBonusNumber(): LottoNumber {
        var lottoNumber: LottoNumber? = null
        while (lottoNumber == null) {
            println(INPUT_BONUS_NUMBER)
            lottoNumber = try {
                LottoNumber.of(readLine()!!.toInt())
            } catch (e: Throwable) {
                println("$ERROR_INVALID_STRING ${e.message}")
                null
            }
        }
        return lottoNumber
    }
}
