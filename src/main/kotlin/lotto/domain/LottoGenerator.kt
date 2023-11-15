package lotto.domain

fun interface LottoGenerator {
    fun generateLotto(): Lotto

    companion object {
        const val MAX_LOTTO_NUMBER_COUNT = 6
    }
}
