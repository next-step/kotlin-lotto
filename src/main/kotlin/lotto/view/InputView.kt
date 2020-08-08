package lotto.view

fun getMoneyForTickets(): Int {
    println("구입금액을 입력해 주세요.")
    return readLine()!!.toInt()
}

fun getLuckyNumbers(): IntArray {
    println("지난 주 당첨 번호를 입력해 주세요.")
    return readLine()!!.split(",").map { it.toInt() }.toIntArray()
}

fun getBonusNumber(): Int {
    println("보너스 볼을 입력해 주세요.")
    return readLine()!!.toInt()
}
