package lotto.view

fun inputMoney(): Int {
    println("구입금액을 입력해 주세요.")
    return readLine()?.toInt() ?: throw IllegalArgumentException()
}

fun inputWinningLottoNumbers(): List<Int> {
    println("지난 주 당첨 번호를 입력해 주세요.")
    return (readLine() ?: throw NullPointerException())
        .split(",")
        .map { it.toInt() }
}
