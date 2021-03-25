package lotto.model.number

data class LottoNumbers(val lottoNumbers: Set<LottoNumber>) : Set<LottoNumber> by lottoNumbers {
    init {
        require(lottoNumbers.size == CANDIDATE_SIZE) { "로또 티켓은 6개의 로또 숫자로 이루어져 있다" }
    }

    constructor(numbers: List<Int>) : this(numbers.map { LottoNumber.get(it) }.toSet())

    companion object {
        const val CANDIDATE_SIZE = 6
    }
}
