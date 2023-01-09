package lotto

@JvmInline
value class LottoNumbers(val value: List<LottoNumber>) {
    init {
        require(value.size == 6) { "로또는 6자리 입니다." }
        require(value.distinct().size == 6) { "로또는 중복되지 않는 6자리 입니다." }
    }

    fun countMatchNumber(lottoNumbers: List<LottoNumber>): Int {
        return value.count { lottoNumbers.contains(LottoNumber(it.value)) }
    }

    fun isContainNumber(number: LottoNumber): Boolean {
        return value.contains(number)
    }
}
