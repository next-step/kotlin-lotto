package lotto.domain

class Lotto(val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.toSet().size == NUMBERS_SIZE) { "로또 숫자는 중복없이 $NUMBERS_SIZE 개여야 합니다." }
    }

    fun getMatchingCount(lotto: Lotto): Int {
        return lottoNumbers.count { lotto.contains(it) }
    }

    fun contains(number: LottoNumber): Boolean {
        return lottoNumbers.contains(number)
    }

    companion object {
        const val NUMBERS_SIZE = 6
    }
}
