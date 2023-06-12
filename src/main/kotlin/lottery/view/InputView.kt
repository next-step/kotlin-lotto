package lottery.view

fun inputPurchaseMoney(): Int {
    println("구입금액을 입력해 주세요.")
    return readln().toIntOrNull()?: retryInputPurchaseMoney()
}

private fun retryInputPurchaseMoney(): Int {
    println("구입금액은 숫자를 입력하여야 합니다.")
    return inputPurchaseMoney()
}
