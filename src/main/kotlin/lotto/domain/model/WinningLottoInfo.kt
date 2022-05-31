package lotto.domain.model

data class WinningLottoInfo(
    val numbers: WinningNumbers,
    val bonusBall: LottoNumber
) {
    init {
        require(bonusBall !in numbers.value) {
            MESSAGE_DUPLICATE_WINNING_NUMBERS
        }
    }

    companion object {
        private const val MESSAGE_DUPLICATE_WINNING_NUMBERS = "보너스 볼 번호는 당첨 번호와 중복될 수 없습니다."
    }
}
