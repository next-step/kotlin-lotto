package lotto.domain

@JvmInline
value class Lottery private constructor(val values: LottoNumbers) {

    companion object {
        fun of(values: LottoNumbers): Lottery {
            return Lottery(values)
        }
    }
}
