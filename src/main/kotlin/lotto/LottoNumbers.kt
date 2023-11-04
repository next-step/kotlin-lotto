package lotto

class LottoNumbers(createStrategy: CreateStrategy) {
    val numbers: List<Int> = createStrategy.createNumbers()

    init {
        require(numbers.size == 6) {
            "number size must be 6"
        }

        require(isBetween1to49()) {
            "numbers should not contain duplicated number"
        }

        require(numbers.distinct().size == 6) {
            "numbers should not contain duplicated number"
        }
    }

    private fun isBetween1to49(): Boolean {
        for (num in numbers) {
            if (num !in (1..49))
                return false
        }
        return true
    }

    fun getContainCount(winningNumbers: WinningNumbers): Int {
        var count = 0
        for (number in winningNumbers.winningNumbers) {
            if (numbers.contains(number)) count++
        }
        return count
    }
}
