package lotto.view

fun inputPrice(): String {
    println("구매금액을 입력해 주세요.")
    return readln()
}

fun inputManualBuyCount(): Int {
    println("수동으로 구매할 로또 수를 입력해 주세요.")
    return readln().toInt()
}

fun inputManualBuy(manualBuyCount: Int): List<String> {
    println()
    println("수동으로 구매할 번호를 입력해 주세요")
    val manualBuyNumbers = mutableListOf<String>()

    for (i in 1..manualBuyCount) {
        manualBuyNumbers.add(readln())
    }

    println()
    return manualBuyNumbers
}

fun inputWinningNumbers(): String {
    println("지난 주 당첨 번호를 입력해 주세요.")
    return readln()
}

fun inputBonusNumber(): Int {
    println("보너스 볼을 입력해 주세요.")
    return readln().toInt()
}
