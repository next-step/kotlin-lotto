package lotto

data class WinningLottoNumbers(val numbers: LottoNumbers, val bonusNumber: LottoNumber) {
    init {
        require(!numbers.isContainNumber(bonusNumber)) { "보너스 번호는 당첨번호가 될 수 없습니다" }
    }
}
