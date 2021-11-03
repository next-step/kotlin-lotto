package lotto.model

/**
 * 하나의 로또 객체
 * */
data class Lotto(
    private val item: List<LottoNumber>,
) {
    init {
        require(item.size == SIZE_LOTTO_NUMBER) { EXCEPTION_LOTTO_FORMAT }
        require(item.distinct().size == SIZE_LOTTO_NUMBER) { EXCEPTION_DUPLICATED_LOTTO_NUMBER }
    }

    val numbers: List<LottoNumber> = item.sortedBy { it.number }

    fun hasNumber(number: Int): Boolean = item.contains(LottoNumber(number))

    companion object {
        private const val SIZE_LOTTO_NUMBER = 6
        const val EXCEPTION_LOTTO_FORMAT = "숫자 포멧에 맞지 않습니다."
        const val EXCEPTION_DUPLICATED_LOTTO_NUMBER = "중복된 숫자가 존재합니다."
    }
}
