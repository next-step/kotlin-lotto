package lotto.view

fun getPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    return getNumber(readLine())
}

fun getWinningNumber(): List<Int> {
    print("지난 주 당첨 번호를 입력해 주세요.")
    return getNumbers(readLine())
}

fun getNumbers(input: String?): List<Int> {
    validateNullOrBlank(input)
    return input!!.split(", ")
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
