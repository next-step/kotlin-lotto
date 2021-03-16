package lotto.domain

class WinningLottoNumbers private constructor(
    val lottoNumbers: List<LottoNumber>
) {

    private fun isContainLottoNumber(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    fun countWinningNumbers(lottoTicket: LottoTicket): Int {
        return lottoTicket.lottoNumbers.filter {
            this.isContainLottoNumber(it)
        }.size
    }

    companion object {
        private const val WINNING_LOTTO_NUMBERS_SIZE = 6

        fun from(stringWinningLottoNumbers: String): WinningLottoNumbers {
            val winningLottoNumberTokens = stringWinningLottoNumbers.trim().split(",").map { it.trim() }

            validate(winningLottoNumberTokens)

            return WinningLottoNumbers(winningLottoNumberTokens.map { LottoNumber.from(it.toInt()) })
        }

        private fun validate(tokens: List<String>) {
            require(tokens.size == WINNING_LOTTO_NUMBERS_SIZE) {
                "당첨 번호는 ${WINNING_LOTTO_NUMBERS_SIZE}개의 수로 이뤄져야 합니다."
            }

            require(tokens.groupBy { it }.all { it.value.size == 1 }) {
                "당첨 번호는 중복된 번호를 허용할 수 없습니다."
            }
        }
    }
}
