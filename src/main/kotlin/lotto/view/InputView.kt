package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.Lotto

private const val ENTER_PAYMENT_FOR_LOTTO = "1000원 이상의 구입금액을 입력해주세요."
private const val ENTER_MANUAL_ORDER = "수동으로 구매할 로또 개수를 입력해주세요."
private const val ENTER_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해주세요."
private const val ENTER_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해주세요."
private const val ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요."
private const val LOTTO_NUMBERS_DEMILITER = ","
private const val LOTTO_PRICE = 1_000

object InputView {
    fun readPayment(): Int {
        println(ENTER_PAYMENT_FOR_LOTTO)
        var payment = readLine()
        while (payment.isNullOrBlank() || payment.toInt() < LOTTO_PRICE) {
            println(ENTER_PAYMENT_FOR_LOTTO)
            payment = readLine()
        }
        return payment.toInt()
    }

    fun readManualOrder(): Int {
        println("\n$ENTER_MANUAL_ORDER")
        var number = readLine()
        while (number.isNullOrBlank()) {
            number = readLine()
        }
        return number.toInt()
    }

    fun getManualLottos(manualOrder: Int): List<Lotto> {
        var order = manualOrder
        val manualLottos = mutableListOf<Lotto>()
        println("\n$ENTER_MANUAL_NUMBERS")

        while (order > 0) {
            val lottoNumbers = readManualNumbers()
            manualLottos.add(Lotto(lottoNumbers))
            order--
        }
        return manualLottos.toList()
    }

    private fun readManualNumbers(): List<LottoNumber> {
        var numbers = readLine()
        while (numbers.isNullOrBlank()) {
            numbers = readLine()
        }
        val lottoNumbers = numbers.split(LOTTO_NUMBERS_DEMILITER).map { it.toInt() }
        return lottoNumbers.map { LottoNumber(it) }
    }

    fun readWinningNumbers(): List<Int> {
        println("\n$ENTER_WINNING_NUMBERS")
        var numbers = readLine()
        while (numbers.isNullOrBlank()) {
            numbers = readLine()
        }
        return numbers.split(LOTTO_NUMBERS_DEMILITER).map { it.toInt() }
    }

    fun getWinningNumbers(numbers: List<Int>): Lotto {
        val lottoNumbers = numbers.map { LottoNumber.of(it) }
        return Lotto(lottoNumbers)
    }

    fun readBonusNumber(): Int {
        println(ENTER_BONUS_NUMBER)
        var number = readLine()
        while (number.isNullOrBlank()) {
            number = readLine()
        }
        return number.toInt()
    }
}
