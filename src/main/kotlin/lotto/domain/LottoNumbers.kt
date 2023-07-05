package lotto.domain

class LottoNumbers(val numbers: Set<Int>) {
    fun countMatch(lottoNumbers: LottoNumbers): Int {
        return numbers
            .intersect(lottoNumbers.numbers)
            .size
    }

    fun match(number: Int): Boolean {
        return numbers.contains(number)
    }

    val size: Int = numbers.size

    init {
        require(numbers.size == Lotto.LOTTO_NUMBER_SIZE) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it in Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX }) { "로또 번호는 1부터 45 사이여야 합니다." }
    }
}
