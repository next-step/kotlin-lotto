package lottery.domain

class LotteryNumbers(numbers: List<Int>) : List<Int> by numbers {
    val numbers: HashSet<LotteryNumber> = numbers.map {
        LotteryNumber.from(it)
    }.toHashSet()

    init {
        require(this.numbers.size == MAX_LOTTERY_NUMBERS_SIZE) { "로또 번호의 개수는 6개이여야 합니다. : ${this.numbers.size}" }
    }

    override fun toString(): String {
        return "[ ${numbers.joinToString()} ]"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LotteryNumbers

        if (numbers != other.numbers) return false

        return true
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    companion object {
        const val MAX_LOTTERY_NUMBERS_SIZE = 6
    }
}
