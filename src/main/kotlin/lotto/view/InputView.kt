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

fun getManualLottoCount(): Int {
    println("수동으로 구매할 로또 수를 입력해 주세요.")
    return getNumber(readLine())
}

fun printManualLottoNumbersComment() = println("수동으로 구매할 번호를 입력해 주세요.")

fun getManualLottoNumbers(): List<Int> {
    return getNumbers(readLine()).also { validateSix(it) }
}

fun validateSix(list: List<Int>) {
    require(list.count() == 6) {
        "로또 번호는 여섯개입니다."
    }
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
