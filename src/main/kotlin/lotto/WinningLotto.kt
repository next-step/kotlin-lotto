package lotto

data class WinningLotto(
    val numbers: List<LottoNumber> = emptyList(),
    val bonusNumber: LottoNumber
) {

    init {
        require(bonusNumber !in numbers) {
            DUPLICATED_BONUS_NUMBER_MSG
        }
    }

    companion object {
        const val DUPLICATED_BONUS_NUMBER_MSG = "당첨 번호와 중복된 보너스 번호입니다."
    }
}
