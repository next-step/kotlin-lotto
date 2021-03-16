package lotto.view

import lotto.domain.value.Price
import lotto.view.request.ManualNumberRequest
import lotto.view.request.WinningNumberRequest

fun inputPrice(): Price {
    println("구매금액을 입력해주세요.")
    val request = readLine() ?: throw IllegalArgumentException("금액을 입력해주세요.")
    return Price(request)
}

fun inputWinningNumbers(): WinningNumberRequest {
    println("지난 주 당첨 번호를 입력해 주세요.")
    val request = readLine() ?: throw IllegalArgumentException("당첨 번호를 입력해주세요.")
    return WinningNumberRequest(request)
}

fun inputBonusNumber(): Int {
    println("보너스 번호를 입력해주세요.")
    val request = readLine() ?: throw IllegalArgumentException("보너스 번호를 입력해주세요.")
    return request.toInt()
}

fun inputManualAmount(): Int {
    println("수동으로 구매할 로또 수를 입력해 주세요.")
    val request = readLine() ?: throw IllegalArgumentException("수동으로 구매할 갯수를 입력해주세요.")
    return request.toInt()
}

fun inputManualNumbers(amount: Int): ManualNumberRequest {
    println("수동으로 구매할 번호를 입력해주세요.")
    return ManualNumberRequest(
        (0 until amount).map {
            readLine() ?: throw IllegalArgumentException("수동으로 구매할 번호를 입력해주세요.")
        }
    )
}
