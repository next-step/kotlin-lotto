package lotto

class WinningNumbers(val winningNumbers: List<Int>) {
    init {
        require(winningNumbers.size == 6) {
            "number size must be 6"
        }

        require(isBetween1to49()) {
            "numbers should not contain duplicated number"
        }

        require(winningNumbers.distinct().size == 6) {
            "numbers should not contain duplicated number"
        }
    }

    private fun isBetween1to49(): Boolean {
        for (num in winningNumbers) {
            if (num !in (1..49))
                return false
        }
        return true
    }
}