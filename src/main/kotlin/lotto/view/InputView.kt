package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto
import lotto.error.LottoErrorMessage.BUDGET_MUST_BE_POSITIVE
import lotto.error.LottoErrorMessage.NUMBER_OF_LOTTO_MUST_BE_POSITIVE

class InputView {
    fun inputPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")
        val budget = readln().toInt()
        require(budget > 0) { BUDGET_MUST_BE_POSITIVE }
        return budget
    }

    fun inputManualPurchaseAmount(): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        val manualAmount = readln().toInt()
        require(manualAmount > 0) { NUMBER_OF_LOTTO_MUST_BE_POSITIVE }
        return manualAmount
    }

    fun inputManualLottos(count: Int): List<List<Int>> {
        println("\n수동으로 구매할 번호를 입력해 주세요.")

        val numbersList = mutableListOf<List<Int>>()
        repeat(count) {
            val numbers = readln().split(NUMBERS_DELIMITER).map(String::toInt)
            numbersList.add(numbers)
        }

        return numbersList
    }

    fun inputLastWeekWinningLotto(): WinningLotto {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln().split(NUMBERS_DELIMITER).map { it.toInt() }
        val bonusNumber = inputBonusNumber()
        return WinningLotto(Lotto.manualCreate(numbers), bonusNumber)
    }

    private fun inputBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber.create(readln().toInt())
    }

    companion object {
        private const val NUMBERS_DELIMITER: String = ", "
    }
}
