package lotto.domain

import lotto.model.LottoNumbers

class Lotto(
    val numbers: List<LottoNumbers>,
) {
    val size: Int
        get() = numbers.size

    fun matches(winningLotto: WinningLotto): LottoRankResults =
        numbers.mapNotNull(winningLotto::rank)
            .let(::LottoRankResults)

    companion object {
        const val PRICE = 1000
    }
}
