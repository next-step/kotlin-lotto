package lotto.domain

@JvmInline
value class Lottery private constructor(val numbers: LottoNumbers) {

    companion object {
        fun of(numbers: LottoNumbers): Lottery {
            return Lottery(numbers)
        }
    }
}
