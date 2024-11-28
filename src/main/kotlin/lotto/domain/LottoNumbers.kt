package lotto.domain

data class LottoNumbers(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == Lotto.NUMBER_OF_NUMBER) { "로또는 정확히 6개의 숫자가 필요해요" }
    }

    fun containNumber(number: Int): Boolean {
        return lottoNumbers.map { it.number }.contains(number)
    }

    companion object {
        fun of(lottoNumbers: List<Int>): LottoNumbers {
            return LottoNumbers(lottoNumbers.map { LottoNumber(it) }.toSet())
        }
    }
}
