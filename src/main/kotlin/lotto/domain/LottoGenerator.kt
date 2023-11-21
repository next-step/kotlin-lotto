package lotto.domain

fun interface LottoGenerator {
    fun generateLotto(lottoCount: Int): Lottos

    companion object {
        const val MAX_LOTTO_NUMBER_COUNT = 6
    }
}
