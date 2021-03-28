package lotto.view

import lotto.domain.value.Price
import lotto.view.request.LottoPurchaseRequest
import lotto.view.request.LottoPurchaseRequest.ManualNumberRequest
import lotto.view.request.WinningLottoRequest

fun lottoRequest(): LottoPurchaseRequest {
    val price = inputPrice()
    val manualNumberRequest = inputManualRequest()
    return LottoPurchaseRequest(price, manualNumberRequest)
}

private fun inputPrice(): Price {
    println("구매금액을 입력해주세요.")
    val request = readLine() ?: throw IllegalArgumentException("금액을 입력해주세요.")
    return Price(request)
}

private fun inputManualRequest(): ManualNumberRequest {
    val amount = inputManualAmount()
    return inputManualNumbers(amount)
}

private fun inputManualAmount(): Int {
    println("수동으로 구매할 로또 수를 입력해 주세요.")
    val request = readLine() ?: throw IllegalArgumentException("수동으로 구매할 갯수를 입력해주세요.")
    return request.toInt()
}

private fun inputManualNumbers(amount: Int): ManualNumberRequest {
    if (amount == 0) {
        return ManualNumberRequest(
            amount = amount,
            numbers = emptyList()
        )
    }
    println("수동으로 구매할 번호를 입력해주세요.")
    return ManualNumberRequest(
        amount = amount,
        numbers = (0 until amount).map {
            readLine() ?: throw IllegalArgumentException("수동으로 구매할 번호를 입력해주세요.")
        }
    )
}

fun winningLottoRequest(): WinningLottoRequest {
    val winningNumbers = inputWinningNumbers()
    val bonusNumber = inputBonusNumber()
    return WinningLottoRequest(
        winningNumbers,
        bonusNumber
    )
}

private fun inputWinningNumbers(): String {
    println("지난 주 당첨 번호를 입력해 주세요.")
    return readLine() ?: throw IllegalArgumentException("당첨 번호를 입력해주세요.")
}

private fun inputBonusNumber(): Int {
    println("보너스 번호를 입력해주세요.")
    val request = readLine() ?: throw IllegalArgumentException("보너스 번호를 입력해주세요.")
    return request.toInt()
}
