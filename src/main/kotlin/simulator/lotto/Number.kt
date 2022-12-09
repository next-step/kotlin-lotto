package simulator.lotto

data class Number(val value: Int) {
    init {
        require(value <= MAX_NUMBER) {
            "로또 번호는 ${MAX_NUMBER}이하이어야 합니다"
        }

        require(value >= MIN_NUMBER) {
            "로또 번호는 ${MIN_NUMBER}이상이어야 합니다"
        }
    }

    override fun toString(): String {
        return "$value"
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}