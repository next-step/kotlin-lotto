package lotto.dto

import lotto.domain.Lotto

data class LottoNumbersDto(
    val lottos: List<List<Int>>,
    val manualLottoCount: Int,
    val randomLottoCount: Int
) {
    constructor(manualLottoCount: Int, randomLottoCount: Int, lottos: List<Lotto>) : this(
        lottos = lottos.map { lotto -> lotto.lottoNumbers.map { it.value } },
        manualLottoCount = manualLottoCount,
        randomLottoCount = randomLottoCount
    )
}
