package lottoAuto.domain

data class LottoNumbers(
    val numbers: List<LottoNumber>
) {
    init {
        require(numbers.size == NUM_OF_LOTTO_NUMBERS) { "로또 번호는 ${NUM_OF_LOTTO_NUMBERS}개여야 합니다." }
    }

    fun countSameNumber(lottoNumbers: LottoNumbers): Int {
        return this.numbers.intersect(
            lottoNumbers.numbers.toSet()).size
    }

    companion object {
        const val NUM_OF_LOTTO_NUMBERS = 6
    }
}
