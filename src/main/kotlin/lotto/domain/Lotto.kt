package lotto.domain

/**
 * 서로 중복되지 않는 1과 45사이의 숫자 6개를 가지는 로또 클래스 입니다.
 */
data class Lotto(
    val numbers: Set<LottoNumber>
) {
    init {
        require(numbers.size == MAX_LOTTO_NUMBER_SIZE) {
            "lotto number size must be $MAX_LOTTO_NUMBER_SIZE"
        }
    }

    fun match(winningLotto: WinningLotto): LottoMatchResult {
        val matchCount = numbers.intersect(winningLotto.winningNumbers).size
        val bonusMatched = numbers.any { it == winningLotto.bonusNumber }
        return LottoMatchResult(
            matchCount = matchCount,
            bonusMatched = bonusMatched,
        )
    }

    override fun toString(): String {
        return "$numbers"
    }

    companion object {
        const val MAX_LOTTO_NUMBER_SIZE = 6
    }
}
