package lotto.domain

import lotto.domain.data.Lotto

class LottoNumberMatchCounter {
    fun countMatchingNumbersAndGet(
        target: Lotto,
        lottoList: List<Lotto>
    ): Map<Lotto, Int> {
        require(lottoList.isNotEmpty()) { "You don't have any lotto !" }
        require(target.value.isNotEmpty()) { "Match target lotto numbers cannot be empty." }
        return countAndGet(target, lottoList)
    }

    private fun countAndGet(
        lotto: Lotto,
        lottoList: List<Lotto>
    ): Map<Lotto, Int> {
        return lottoList.associateWith {
            it.value.count { number -> lotto.value.contains(number) }
        }
    }
}
