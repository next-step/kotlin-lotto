package lotto.dto

import lotto.domain.vo.LottoNumber

data class WinningLottoDto private constructor (private val _winningNumber: List<LottoNumber>) {
    val winningNumber
        get() = _winningNumber

    companion object {
        private const val WINNING_NUMBERS_DELIMITER = ","

        fun of(winningNumbers: String?): WinningLottoDto {
            requireNotNull(winningNumbers) { "당첨 번호는 null이 될 수 없습니다." }

            return winningNumbers.split(WINNING_NUMBERS_DELIMITER)
                .map { it.toInt() }
                .map { LottoNumber(it) }
                .let { WinningLottoDto(it) }
        }
    }
}
