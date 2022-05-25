package lotto.domain.model

@JvmInline
value class Lotto(val numbers: List<Int>) {
    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
