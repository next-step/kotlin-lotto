package lottery

class Lottery(
    val values: List<LotteryNumber>
) {
    init {
        require(values.size == 6) { "로또 번호는 6개만 입력하여야한다" }
        require(values.distinct().size == 6) { "로또 번호는 중복되어 입력될 수 없다" }
    }
}
