package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.Money

object LottoStore {
    fun buy(money: Money, manualNumbers: List<ManualNumbers> = listOf()): List<Lotto> {
        val totalLottoCount = money.value / Lotto.PRICE
        val manualLottoCount = manualNumbers.size

        require(totalLottoCount >= manualLottoCount) { "구입금액이 부족합니다" }

        return mutableListOf<Lotto>().apply {
            addAll(manualNumbers.map { Lotto(it.numbers) })
            addAll(List(totalLottoCount - manualLottoCount) { Lotto(generateAuto()) })
        }
    }

    private fun generateAuto(): List<LottoNumber> {
        return (LottoNumber.FIRST_NUMBER..LottoNumber.LAST_NUMBER)
            .shuffled()
            .subList(0, Lotto.NUMBER_COUNT)
            .map { LottoNumber.from(it) }
    }
}
