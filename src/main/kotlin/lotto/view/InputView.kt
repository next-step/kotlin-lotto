package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.Lotto

private const val ENTER_MONEY_FOR_LOTTO = "구입금액을 입력해주세요."
private const val RE_ENTER_ENOUGH_MONEY = "1000원 이상이 필요합니다."
private const val ENTER_MANUAL_ORDER = "수동으로 구매할 로또 개수를 입력해주세요."
private const val ENTER_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해주세요."
private const val ENTER_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해주세요."
private const val ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요."
private const val LOTTO_NUMBERS_DEMILITER = ","
private const val LOTTO_PRICE = 1_000
private const val ZERO_VALUE = 0

object InputView {
    fun readPayment(): Int {
        println(ENTER_MONEY_FOR_LOTTO)

        var payment = readLine()?.toIntOrNull()
        while (payment == null || LOTTO_PRICE > payment) {
            println(RE_ENTER_ENOUGH_MONEY)
            payment = readLine()?.toIntOrNull()
        }
        return payment
    }

    fun readManualOrder(availableQuantity: Int): Int {
        println("\n$ENTER_MANUAL_ORDER")
        var number = readLine()?.toIntOrNull()

        while (number == null || number > availableQuantity) {
            println("총 구입개수는 ${availableQuantity}개입니다. 이보다 작거나 같은 수를 입력해주세요")
            number = readLine()?.toIntOrNull()
        }
        require(number >= ZERO_VALUE) { "Manual order(${number}) should be positive or zero" }
        return number
    }

    private fun readManualNumbers(): List<LottoNumber> {
        var numbers = readLine()
        while (numbers.isNullOrBlank()) {
            numbers = readLine()
        }
        val lottoNumbers = numbers.split(LOTTO_NUMBERS_DEMILITER).map { it.toIntOrNull() }
        return lottoNumbers.map { LottoNumber.of(it) }
    }

    fun getManualLottos(manualOrder: Int): List<Lotto> {
        if (manualOrder != ZERO_VALUE) {
            println("\n$ENTER_MANUAL_NUMBERS")
        }

        val manualNumbers = (1..manualOrder).map { readManualNumbers() }
        return manualNumbers.map { Lotto(it) }
    }

    fun readWinningNumbers(): List<Int?> {
        println("\n$ENTER_WINNING_NUMBERS")
        var numbers = readLine()
        while (numbers.isNullOrBlank()) {
            numbers = readLine()
        }
        return numbers.split(LOTTO_NUMBERS_DEMILITER).map { it.toIntOrNull() }
    }

    fun getWinningNumbers(numbers: List<Int?>): Lotto {
        val lottoNumbers = numbers.map { LottoNumber.of(it) }
        return Lotto(lottoNumbers)
    }

    fun readBonusNumber(): Int? {
        println(ENTER_BONUS_NUMBER)
        var number = readLine()
        while (number.isNullOrBlank()) {
            number = readLine()
        }
        return number.toIntOrNull()
    }
}
