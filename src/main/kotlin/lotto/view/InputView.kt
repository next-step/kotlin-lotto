package lotto.view

import lotto.domain.LottoCount

private const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
private const val INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
private const val INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요."
private const val INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
private const val INPUT_LOTTO_NUMBERS_DELIMITER = ", "
private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."

fun readPrice(): Int {
    println(INPUT_PRICE_MESSAGE)
    return readln().toInt()
}

fun readManualLottoCount(): Int {
    println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE)
    return readln().toInt()
}

fun readLottoNumbers(count: LottoCount): List<Set<Int>> {
    println(INPUT_MANUAL_LOTTO_NUMBERS)
    val inputLottoNumbers: MutableList<Set<Int>> = ArrayList()
    for (i in 1..count.value) {
        inputLottoNumbers.add(
            readln().split(INPUT_LOTTO_NUMBERS_DELIMITER).map { it.toInt() }.toSet()
        )
    }
    return inputLottoNumbers
}

fun readWinningNumbers(): Set<Int> {
    println(INPUT_WINNING_NUMBERS_MESSAGE)
    return readln().split(INPUT_LOTTO_NUMBERS_DELIMITER).map { it.toInt() }.toSet()
}

fun readBonusNumber(): Int {
    println(INPUT_BONUS_NUMBER_MESSAGE)
    return readln().toInt()
}
