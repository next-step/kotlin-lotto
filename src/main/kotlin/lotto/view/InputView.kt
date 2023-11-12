package lotto.view

import lotto.model.LottoNumber
import lotto.model.LottoTicket

object InputView {
    fun getPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getWinningNumbers(): Pair<List<LottoNumber>, LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val numbers = readln().split(",").map { LottoNumber.from(it.trim().toInt()) }

        require(numbers.size == LottoTicket.NUMBER_COUNT) { "당첨 번호는 ${LottoTicket.NUMBER_COUNT}개 여야 합니다" }

        println("보너스 볼을 입력해 주세요.")

        val bonusNumber = LottoNumber.from(readln().toInt())

        return Pair(numbers, bonusNumber)
    }

    fun getManualNumbers(): List<List<LottoNumber>> {
        println("수동으로 구매할 로또 수를 입력해 주세요.")

        val count = readln().toInt()
        var numbersList = emptyList<List<LottoNumber>>()
        if(count > 0){
            println("수동으로 구매할 번호를 입력해 주세요.")
            numbersList = (1..count).map {
                readln().split(",").map { LottoNumber.from(it.trim().toInt()) }
            }
        }

        return numbersList
    }
}
