package lotto.view

import lotto.domain.LottoNumbers
import lotto.domain.WinningNumbers

class InputView {

    fun inputPurchasePrice(): Int {
        println(MANUAL_PURCHASE_PRICE)
        return readln().toInt()
    }

    fun inputLastWinNumbers(): WinningNumbers {
        println(MANUAL_LAST_WINNER_NUMBER)
        val inputData = readln().split(",").map {
            it.toIntOrNull() ?: throw IllegalArgumentException(ERROR_ONLY_INTEGER)
        }
        return WinningNumbers(inputData)
    }

    fun inputBonusNumber(): Int {
        println(MANUAL_BONUS_NUMBER)
        return readln().toInt()
    }

    fun inputCustomNumberCount(): Int {
        println(MANUAL_CUSTOM_COUNT)
        return readln().toInt()
    }

    fun inputCustomLotto(customCount: Int): List<LottoNumbers> {
        println(MANUAL_CUSTOM_LOTTO)
        return List(customCount) {
            LottoNumbers(readln().split(",").map { it.toInt() })
        }
    }

    companion object {
        const val MANUAL_PURCHASE_PRICE = "구입 금액을 입력해주세요."
        const val MANUAL_LAST_WINNER_NUMBER = "지난 주 당첨 번호를 입력해주세요."
        const val MANUAL_BONUS_NUMBER = "보너스 볼을 입력해주세요."
        const val MANUAL_CUSTOM_COUNT = "수동으로 구매할 로또 수를 입력해주세요."
        const val MANUAL_CUSTOM_LOTTO = "수동으로 구매할 번호를 입력해주세요."
        const val ERROR_ONLY_INTEGER = "정수만 입력 가능합니다."
    }
}
