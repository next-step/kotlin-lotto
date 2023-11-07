package lotto.collection



class LottoTicket(numbers: List<LottoNumber>) {
    init {
        require(numbers.size == NUMBER_COUNT) { "로또는 ${NUMBER_COUNT}개의 수가 필요 합니다." }
        require(numbers.size == numbers.toSet().size) { "로또의 수는 중복되면 안됩니다." }
    }
    private var _numbers: List<LottoNumber> = numbers.toList()
    val numbers: List<LottoNumber> get() = _numbers.toList()

    fun matchCount(winningNumbers: List<Int>) = numbers.intersect(winningNumbers.toSet()).size
    companion object {
        const val NUMBER_COUNT = 6
    }
}
