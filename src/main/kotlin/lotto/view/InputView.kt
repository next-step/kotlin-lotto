package lotto.view

import lotto.exception.NotNumericException
import lotto.exception.WonLottoNumberCountInconsistencyException

class InputView {
    fun enterMoney(): Int {
        println("구입금액을 입력해 주세요.")

        val text = readln()
        validateNotString(text)
        return text.toInt()
    }

    fun enterWonLotto(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val text = readln().trim().split(",")
        text.map { validateNotString(it) }
        val wonLottoNumbers = text.map { it.toInt() }
        validateWonLottoNumberCount(wonLottoNumbers)
        return wonLottoNumbers
    }

    private fun validateNotString(toCheck: String) {
        if (toCheck.toIntOrNull() == null) {
            throw NotNumericException("로또 구매를 위해서는 숫자를 입력하셔야 합니다.")
        }
    }

    private fun validateWonLottoNumberCount(toCheck: List<Int>) {
        if (toCheck.size != WON_LOTTO_NUMBER_COUNT) {
            throw WonLottoNumberCountInconsistencyException("로또 당첨 번호는 ${WON_LOTTO_NUMBER_COUNT}개를 입력해야합니다.")
        }
    }

    companion object {
        const val WON_LOTTO_NUMBER_COUNT = 6
    }
}
