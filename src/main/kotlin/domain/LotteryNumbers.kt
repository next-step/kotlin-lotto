package domain

class LotteryNumbers(numbers: List<Int>) {
    val numbers: HashSet<LotteryNumber> = numbers.map {
        LotteryNumber.from(it)
    }.toHashSet()

    init {
        require(this.numbers.size == MAX_LOTTERY_NUMBERS_SIZE) { "로또 번호의 개수는 6개이여야 합니다. : ${this.numbers.size}" }
    }

    companion object {
        const val MAX_LOTTERY_NUMBERS_SIZE = 6
    }

    override fun toString(): String {
        return "[ ${numbers.joinToString()} ]"
    }
}
