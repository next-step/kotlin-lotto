package lotto.view

fun inputMoney(): Int {
    println("구입금액을 입력해 주세요.")
    return readLine()?.toIntOrNull() ?: throw IllegalArgumentException()
}

fun inputManualLottoCount(): Int {
    println("수동으로 구매할 로또 수를 입력해 주세요.")
    return readLine()?.toIntOrNull() ?: throw IllegalArgumentException()
}

fun inputManualLottoNumbers(): List<Int> {
    println("수동으로 구매할 번호를 입력해 주세요.")
    return (readLine() ?: throw IllegalArgumentException())
        .split(",")
        .map { it.toInt() }
}

fun inputWinningLottoNumbers(): List<Int> {
    println("지난 주 당첨 번호를 입력해 주세요.")
    return (readLine() ?: throw IllegalArgumentException())
        .split(",")
        .map { it.toInt() }
}

fun inputBonusNumber(): Int {
    println("보너스 볼을 입력해 주세요.")
    return readLine()?.toInt() ?: throw IllegalArgumentException()
}
