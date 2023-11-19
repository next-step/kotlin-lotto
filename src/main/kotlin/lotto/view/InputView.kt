package lotto.view

private const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
private const val INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
private const val INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
private const val INPUT_WINNING_NUMBERS_DELIMITER = ", "
private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."

fun readPrice(): Int? {
    println(INPUT_PRICE_MESSAGE)
    return readln().toIntOrNull()
}

fun readManualLottoCount(): Int? {
    println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE)
    return readln().toIntOrNull()
}

fun readWinningNumbers(): Set<Int> {
    println(INPUT_WINNING_NUMBERS_MESSAGE)
    return readln().split(INPUT_WINNING_NUMBERS_DELIMITER).map { it.toInt() }.toSet()
}

fun readBonusNumber(): Int {
    println(INPUT_BONUS_NUMBER_MESSAGE)
    return readln().toInt()
}
