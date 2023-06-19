package lotto.domain

class Lotto(lottoNumbers: List<LottoNumber>) {

    val numbers: List<LottoNumber>

    init {
        require(lottoNumbers.size == 6) { "서로 다른 6개의 숫자를 입력해야 합니다." }
        require(lottoNumbers.distinct().size == 6) { "서로 다른 6개의 숫자를 입력해야 합니다." }
        numbers = lottoNumbers.sorted()
    }

    fun matchCount(other: Lotto): Int {
        val difference = this.numbers - other.numbers.toSet()
        return 6 - difference.size
    }
}
