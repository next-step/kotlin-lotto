package lotto

@JvmInline
value class LottoNumbers(val value: List<Int>) {
    init {
        require(value.size == 6) { "로또는 6자리 입니다." }
    }

    fun countMatchNumber(lottoNumbers: List<Int>): Int {
        return value.count { lottoNumbers.contains(it) }
    }

    fun isContainNumber(number: Int): Boolean {
        return value.contains(number)
    }
}
