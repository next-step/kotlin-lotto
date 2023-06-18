package lotto.domain.lottery

@JvmInline
value class LottoNumber(val numbers: Set<Int>) : Set<Int> by numbers
