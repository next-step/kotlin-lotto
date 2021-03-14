package domain

class LotteryNumbers(val numbers: List<Int>) {
    val lotteryNumbers: HashSet<LotteryNumber> = numbers.map {
        LotteryNumber.from(it)
    }.toHashSet()
}
