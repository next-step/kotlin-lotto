package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

class InputView {

    fun requestPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readInteger()
    }

    fun requestManualPurchaseCountAndNumbers(): List<LottoNumbers> {
        val count = requestManualPurchaseCount()
        return requestManualLottoNumbers(count)
    }

    private fun requestManualPurchaseCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readInteger()
    }

    private fun requestManualLottoNumbers(count: Int): List<LottoNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(count) {
            LottoNumbers(readlnAndSplitComma().map { LottoNumber(it.trim().toInt()) })
        }
    }

    fun requestWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readlnAndSplitComma()
            .map { it.trim().toInt() }
            .toList()
    }

    fun requestBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readInteger()
    }

    private fun readlnAndSplitComma() = readln().split(",")

    private fun readInteger() = readln().trim().toInt()
}
