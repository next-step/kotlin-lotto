package lotto.vo

data class WinningNumbers(
    val numbers: List<LottoNumber>,
    val bonusNumber: LottoNumber,
) {
    init {
        require(!numbers.contains(bonusNumber)) { "보너스 볼은 당첨 번호와 다른 번호여야 합니다." }
    }
}
