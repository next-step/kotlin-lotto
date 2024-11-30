package lotto.domain

class LottoTicket {
    val lottoNumbers =
        (LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE).toSet().shuffled().take(LOTTO_NUMBER_COUNT).sorted()

    companion object {
        const val LOTTO_NUMBER_MIN_VALUE: Int = 1
        const val LOTTO_NUMBER_MAX_VALUE: Int = 45
        const val LOTTO_NUMBER_COUNT: Int = 6
    }
}
