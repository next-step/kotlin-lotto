package lotto

@JvmInline
value class LottoNumbers(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "로또는 6자리 입니다." }
    }

    fun countMatchNumber(lottoNumbers: List<Int>): Int {
        return numbers.count { lottoNumbers.contains(it) }
    }
}
