package lotto.domain

class Lotto private constructor(val lottoNumbers: Set<LottoNumber>) {
    fun getIntersectSize(winningLotto: Lotto): Int {
        val lottoNumbers: Set<LottoNumber> = lottoNumbers
        val winningLottoNumbers: Set<LottoNumber> = winningLotto.lottoNumbers
        return lottoNumbers.intersect(winningLottoNumbers).size
    }

    companion object {
        fun createLotto(numbers: List<Int>): Lotto {
            val lottoNumbers = numbers.map { LottoNumber(it) }.toSet()
            return Lotto(lottoNumbers)
        }
    }
}
