package lotto.view

fun getMoneyForTickets(): Long {
    println("구입금액을 입력해 주세요.")
    return readLine()!!.toLong()
}

fun getManualTicketCount(): Int {
    println("수동으로 구매할 로또 수를 입력해 주세요.")
    return readLine()!!.toInt()
}

fun getManualLottoNumbersList(count: Int): List<IntArray> {
    println("수동으로 구매할 번호를 입력해 주세요.")
    return (1..count).map {
        readLine()!!.split(",").map { it.toInt() }.toIntArray()
    }
}

fun getLuckyNumbers(): IntArray {
    println("지난 주 당첨 번호를 입력해 주세요.")
    return readLine()!!.split(",").map { it.toInt() }.toIntArray()
}

fun getBonusNumber(): Int {
    println("보너스 볼을 입력해 주세요.")
    return readLine()!!.toInt()
}
