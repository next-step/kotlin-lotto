package lotto.domain

data class LottoResults(
    val threeNumberMatchCount: Int,
    val fourNumberMatchCount: Int,
    val fiveNumberMatchCount: Int,
    val sixNumberMatchCount: Int,
    val profitMargin: Double,
) {
    init {
        require(threeNumberMatchCount > LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(fourNumberMatchCount > LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(fiveNumberMatchCount > LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(sixNumberMatchCount > LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(profitMargin > PROFIT_MARGIN_MIN_VALUE) { INVALID_PROFIT_MARGIN_MESSAGE }
    }

    companion object {
        const val LOTTO_MATCH_COUNT_MIN_VALUE: Int = 0
        const val INVALID_LOTTO_MATCH_COUNT_MESSAGE: String = "로또 당첨 번호 매치 결과는 0 이상 이어야합니다"
        const val PROFIT_MARGIN_MIN_VALUE: Int = 0
        const val INVALID_PROFIT_MARGIN_MESSAGE: String = "수익률은 0 이상 이어야합니다"
    }
}
