package domain

class LotteryNumbers(numbers: List<Int>) {
    val numbers: HashSet<LotteryNumber> = numbers.map {
        LotteryNumber.from(it)
    }.toHashSet()
}
