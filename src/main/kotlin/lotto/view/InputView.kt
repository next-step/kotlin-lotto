package lotto.view

fun inputPrice(): String {
    println("구매금액을 입력해 주세요.")
    return readln()
}

fun inputWinningNumbers(): String {
    println("지난 주 당첨 번호를 입력해 주세요.")
    return readln()
}

fun inputBonusNumber(): Int {
    println("보너스 볼을 입력해 주세요.")
    return readln().toInt()
}
