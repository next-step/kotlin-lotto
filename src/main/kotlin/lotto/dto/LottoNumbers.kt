package lotto.dto

data class LottoNumbers(
    val numbers: List<Int>
) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
        numbers.forEach { require(it in LOTTO_NUMBER_RANGE) { "로또 번호 범위는 1 ~ 45여야 합니다." } }
        require(numbers.toSet().size == 6) { "로또 번호는 중복되지 않아야 합니다." }
    }

    fun compareLottoNumbers(lottoNumbers: LottoNumbers): Int {
        return numbers.intersect(lottoNumbers.numbers.toSet()).count()
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000
        val LOTTO_NUMBER_RANGE = 1..45
    }
}
