package lotto.domain

class LottoNumbers(
    val lottoNumbers: Set<LottoNumber>,
) {

    init {
        require(lottoNumbers.size == LOTTO_NUMBERS_SIZE) { "로또번호의 개수가 잘못되었습니다." }
    }

    fun getMatchCount(winningLottoNumbers: LottoNumbers): Int {
        return lottoNumbers.intersect(winningLottoNumbers.lottoNumbers).size
    }

    fun containsBonusNumber(bonusNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(bonusNumber)
    }

    companion object {

        private const val LOTTO_NUMBERS_SIZE = 6

        fun of(lottoNumbers: List<LottoNumber>): LottoNumbers {
            return LottoNumbers(lottoNumbers.map { it }.toSet())
        }

        fun of(winningLottoNumbers: LottoNumbers, bonusNumber: LottoNumber): LottoNumbers {
            return LottoNumbers((winningLottoNumbers.lottoNumbers.map { it } + bonusNumber).toSet())
        }
    }
}
