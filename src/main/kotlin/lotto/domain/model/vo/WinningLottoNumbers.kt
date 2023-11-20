package lotto.domain.model.vo


/**
 * 로또 당첨 번호
 * */
@JvmInline
value class WinningLottoNumbers(val winningNumbers: Set<LottoNumber>) {

    init {
        require(winningNumbers.size == DEFAULT_SIZE) {
            "로또 당첨 번호는 총 6자리 여야합니다."
        }
    }

    companion object {
        private const val WINNING_LOTTO_NUMBER_DELIMITER = ", "
        private const val DEFAULT_SIZE = 6

        fun valueOf(winningLottoNumberListText: String): WinningLottoNumbers {

            require(winningLottoNumberListText.isNotBlank()) {
                "로또 당첨 번호는 비어 있을 수 없습니다."
            }

            val winningNumberTextList: List<String> = winningLottoNumberListText.split(WINNING_LOTTO_NUMBER_DELIMITER)
            require(winningNumberTextList.all { it.isNotBlank() && it.toIntOrNull() != null }) {
                "로또 당첨 번호는 숫자로만 이루어져야 합니다."
            }

            val winningNumberList: Set<LottoNumber> = winningNumberTextList.map { LottoNumber.valueOf(it.toInt()) }.toSet()

            return WinningLottoNumbers(winningNumberList)
        }
    }
}
