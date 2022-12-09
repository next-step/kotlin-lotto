package simulator.lotto

data class WinningNumber(val numbers: Numbers, val bonusNumber: Int) {
    init {
        require(bonusNumber <= Numbers.MAX_NUMBER) {
            "보너스 번호는 ${Numbers.MAX_NUMBER}이하이어야 합니다"
        }

        require(bonusNumber >= Numbers.MIN_NUMBER) {
            "보너스 번호는 ${Numbers.MIN_NUMBER}이상이어야 합니다"
        }

        require(!numbers.values.contains(bonusNumber)) {
            "보너스 번호는 당첨 번호와 중복되어선 안됩니다"
        }
    }
}
