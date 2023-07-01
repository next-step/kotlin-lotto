package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber

@JvmInline
value class ManualNumbers(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == Lotto.NUMBER_COUNT) { "${Lotto.NUMBER_COUNT}개의 로또 번호가 필요합니다" }
    }
}
