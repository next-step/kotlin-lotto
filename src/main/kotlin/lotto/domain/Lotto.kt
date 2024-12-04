package lotto.domain

import lotto.constant.NUMBER_OF_SELECT

class Lotto private constructor(val lottoNumbers: Set<LottoNumber>) {
    fun getIntersectSize(winningLotto: Lotto): Int {
        val lottoNumbers: Set<LottoNumber> = lottoNumbers
        val winningLottoNumbers: Set<LottoNumber> = winningLotto.lottoNumbers
        return lottoNumbers.intersect(winningLottoNumbers).size
    }

    companion object {
        fun createLotto(numbers: List<Int>): Lotto {
            require(numbers.size == NUMBER_OF_SELECT) { ERROR_WRONG_NUMBER_COUNT }
            val lottoNumbers = numbers.map { LottoNumber(it) }.toSet()
            return Lotto(lottoNumbers)
        }

        private const val ERROR_WRONG_NUMBER_COUNT = "정확히 6개의 숫자를 입력해야 합니다."
    }
}
