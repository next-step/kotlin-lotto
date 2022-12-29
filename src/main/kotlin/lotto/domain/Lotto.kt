package lotto.domain

import lotto.model.LottoNumbers

class Lotto(
    val numbers: List<LottoNumbers>,
) {
    val size: Int
        get() = numbers.size

    fun matches(winningLotto: WinningLotto): LottoPrizeResults =
        numbers.mapNotNull(winningLotto::prize)
            .let(::LottoPrizeResults)

    companion object {
        const val PRICE = 1000
    }
}
