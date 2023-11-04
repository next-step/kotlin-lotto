package lotto.view

import lotto.domain.ArgumentValidator
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

object InputView {

    fun inputPrice(): Int {
        println("구입금액을 입력해 주세요.")
        return ArgumentValidator(readln()).intValue
    }

    fun inputManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return ArgumentValidator(readln()).intValue
    }

    fun inputManualLotto(manualCount: Int): List<LottoNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")

        return List(manualCount) {
            LottoNumbers(parseLottoNumber(readln()))
        }
    }

    fun inputWinningLotto(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return parseLottoNumber(readln())
    }

    fun inputBonusBall(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val bonusBall = readln()
        return LottoNumber(ArgumentValidator(bonusBall).intValue)
    }

    private fun parseLottoNumber(input: String): List<LottoNumber> {
        require(input.isNotBlank()) { println(BLANK_ERROR_MESSAGE) }
        return input.split(DELIMITER).map { LottoNumber(ArgumentValidator(it.trim()).intValue) }
    }

    private const val DELIMITER = ","
    private const val BLANK_ERROR_MESSAGE = "입력값이 없습니다."
}
