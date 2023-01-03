package lotto

data class WinningLottoNumbers(val numbers: LottoNumbers, val bonusNumber: Int) {
    init {
        require(!numbers.value.contains(bonusNumber)) { "보너스 번호는 당첨번호가 될 수 없습니다" }
    }

    fun getAllNumbers(): List<Int> {
        return numbers.value + bonusNumber
    }
}
