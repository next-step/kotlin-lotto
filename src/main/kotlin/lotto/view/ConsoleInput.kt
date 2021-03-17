package lotto.view

import lotto.domain.value.Price
import lotto.view.request.WinningNumberRequest

fun inputPrice(): Price {
    println("구매금액을 입력해주세요.")
    val request = readLine() ?: throw IllegalArgumentException("금액을 입력해주세요.")
    return Price(request)
}

fun inputWinningNumbers(): WinningNumberRequest {
    println("지난 주 당첨 번호를 입력해 주세요.")
    val request = readLine() ?: throw IllegalArgumentException("번호를 입력해주세요.")
    return WinningNumberRequest(request)
}

fun inputBonusNumber(): Int {
    println("보너스 번호를 입력해주세요.")
    val request = readLine() ?: throw IllegalArgumentException("번호를 입력해주세요.")
    return request.toInt()
}
