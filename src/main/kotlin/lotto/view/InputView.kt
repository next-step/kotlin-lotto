package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoStore
import lotto.vo.LottoNumber
import lotto.vo.Money

object InputView {
    fun inputPrice(): Money {
        println("구입금액을 입력해 주세요.")
        val price = Money.from(read())
        require(price.money >= LottoStore.LOTTO_PRICE.money) { "금액이 모자랍니다. 로또 최소 구매 금액은 ${LottoStore.LOTTO_PRICE.money}원 입니다." }
        return price
    }

    fun inputManualLotto(totalPrice: Money): List<Lotto> {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualCount = read().toInt()
        require(manualCount >= 0) { "0개 이상만 허용됩니다." }
        require(totalPrice.money >= manualCount * LottoStore.LOTTO_PRICE.money) { "금액이 모자랍니다." }

        if (manualCount == 0) return emptyList()

        println("수동으로 구매할 번호를 입력해 주세요.")
        val manualLottoList = mutableListOf<Lotto>()
        repeat(manualCount) {
            val input = read()
            manualLottoList.add(Lotto(inputToLottoNumberSet(input)))
        }

        return manualLottoList
    }

    fun inputWinnerNumber(): Set<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winnerNumber = read()
        return inputToLottoNumberSet(winnerNumber)
    }

    fun inputBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 입력해 주세요.")
        val bonusNumber = read()
        return LottoNumber.from(bonusNumber.trim())
    }

    private fun read(): String {
        val input = readLine()
        require(!input.isNullOrBlank()) { "입력값은 null 혹은 공백이 될 수 없습니다." }
        return input
    }

    private fun inputToLottoNumberSet(input: String): Set<LottoNumber> {
        return input.split(",").map { LottoNumber.from(it.trim()) }.toSet()
    }
}
