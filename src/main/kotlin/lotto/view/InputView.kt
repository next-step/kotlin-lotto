package lotto.view

private const val DELIMITER = ", "

fun getPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    return getNumber(readLine())
}

fun getWinningNumbers(): List<Int> {
    println("지난 주 당첨 번호를 입력해 주세요.")
    return getNumbers(readLine())
}

fun getBonusNumber(): Int {
    println("보너스 볼을 입력해 주세요.")
    return getNumber(readLine())
}

fun getNumbers(input: String?): List<Int> {
    validateNullOrBlank(input)
    return input!!.split(DELIMITER)
        .map { it.toInt() }
}

fun getNumber(input: String?): Int {
    validateNullOrBlank(input)
    return input!!.toInt()
}

private fun validateNullOrBlank(input: String?) {
    require(!input.isNullOrBlank()) {
        "숫자를 입력해주세요."
    }
}
