package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.PurchasePrice

object InputView {

    fun inputPrice(): PurchasePrice {
        println("구입금액을 입력해 주세요.")
        return PurchasePrice(readln())
    }

    fun inputManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun inputWinningLotto(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningLotto = readln()
        return parseLottoNumber(winningLotto)
    }

    fun inputBonusBall(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val bonusBall = readln()
        return try {
            require(bonusBall.isNotBlank())
            LottoNumber(bonusBall.toInt())
        } catch (e: NumberFormatException) {
            println(NUMBER_ERROR_MESSAGE)
            inputBonusBall()
        } catch (e: IllegalArgumentException) {
            println(BLANK_ERROR_MESSAGE)
            inputBonusBall()
        }
    }

    private fun parseLottoNumber(input: String): List<LottoNumber> {
        return try {
            require(input.isNotBlank()) { println(BLANK_ERROR_MESSAGE) }
            input.split(DELIMITER).map { LottoNumber(it.trim().toInt()) }
        } catch (e: NumberFormatException) {
            println(NUMBER_ERROR_MESSAGE)
            inputWinningLotto()
        } catch (e: IllegalArgumentException) {
            inputWinningLotto()
        }
    }

    private const val DELIMITER = ","
    private const val BLANK_ERROR_MESSAGE = "입력값이 없습니다."
    private const val NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요."
}
