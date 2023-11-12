package lotto.domain

data class WinningNumbers(val numbers: LottoNumbers, val bonusNumber: BonusNumber) {
    init {
        require(bonusNumber notIn numbers) { "보너스 번호와 당첨 번호는 중복이 불가능합니다." }
    }
}
