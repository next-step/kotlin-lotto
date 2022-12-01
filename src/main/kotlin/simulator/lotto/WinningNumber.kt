package simulator.lotto

data class WinningNumber(val number: Number, val bonusNumber: Int) {
    init {
        require(bonusNumber <= Number.MAX_NUMBER) {
            "보너스 번호는 ${Number.MAX_NUMBER}이하이어야 합니다"
        }

        require(bonusNumber >= Number.MIN_NUMBER) {
            "보너스 번호는 ${Number.MIN_NUMBER}이상이어야 합니다"
        }

        require(!number.values.contains(bonusNumber)) {
            "보너스 번호는 당첨 번호와 중복되어선 안됩니다"
        }
    }
}
