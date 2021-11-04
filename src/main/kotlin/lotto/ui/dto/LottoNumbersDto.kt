package lotto.ui.dto

import lotto.domain.LottoNumbers

data class LottoNumbersDto(val lottoNumbers: List<Int>) {
    constructor(numbers: LottoNumbers): this(numbers.numbers.map { it.value }.sorted())
}
