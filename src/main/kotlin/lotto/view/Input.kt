package lotto.view

import lotto.domain.LottoSingleLine

fun inputMoney(): Int {
    print("구입금액을 입력해 주세요.")
    return readLine()!!.toInt()
}

fun printLottoTicket(list: List<LottoSingleLine>) {
    println("${list.size}개를 구입했습니다.")
    list.forEach {
        println(it)
    }
}
