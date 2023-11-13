package lotto.dto

import lotto.vo.LottoNumber

data class LottoResult private constructor (private val _winningNumber: List<LottoNumber>) {
    val winningNumber
        get() = _winningNumber

    companion object {
        private const val WINNING_NUMBERS_DELIMITER = ","

        fun of(winningNumbers: String?): LottoResult {
            require(winningNumbers != null) { "당첨 번호는 null이 될 수 없습니다." }

            winningNumbers.split(WINNING_NUMBERS_DELIMITER)
                .map { n -> n.toInt() }
                .map { n -> LottoNumber(n) }
                .let { n -> return LottoResult(n) }
        }
    }
}
