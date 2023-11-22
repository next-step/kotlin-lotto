package lotto.domain.vo

import lotto.domain.LottoStore.Companion.LOTTO_NUMBER_MAX

@JvmInline
value class MatchCount private constructor(val value: Int) {
    companion object {
        fun of(value: Int): MatchCount {
            require(value in 0..LOTTO_NUMBER_MAX) { "일치하는 번호의 개수는 0 이상 $LOTTO_NUMBER_MAX 이하여야 합니다." }

            return MatchCount(value)
        }
    }
}
