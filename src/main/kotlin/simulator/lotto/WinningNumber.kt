package simulator.lotto

data class WinningNumber(val numbers: Numbers, val bonusNumber: Number) {
    init {
        require(!numbers.values.contains(bonusNumber)) {
            "보너스 번호는 당첨 번호와 중복되어선 안됩니다"
        }
    }
}
