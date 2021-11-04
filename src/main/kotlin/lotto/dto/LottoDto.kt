package lotto.dto

import lotto.domain.Lotto

@JvmInline
value class LottoDto(val numbers: List<Int>) {
    fun toLotto(): Lotto {
        return Lotto.from(numbers)
    }
}
