package lotto.domain

@JvmInline
value class Lotto(val numbers: LottoNumbers) {

    override fun toString(): String {
        return numbers.numbers.joinToString(
            prefix = "[",
            postfix = "]",
            separator = ", ",
        )
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
