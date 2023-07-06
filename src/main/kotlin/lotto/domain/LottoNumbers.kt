package lotto.domain

class LottoNumbers(
    val lottoNumbers: Set<LottoNumber>,
) {

    fun getMatchCount(winningLottoNumbers: LottoNumbers): Int {
        return lottoNumbers.intersect(winningLottoNumbers.lottoNumbers).size
    }

    fun containsBonusNumber(bonusNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(bonusNumber)
    }

    companion object {
        fun of(lottoNumbers: List<LottoNumber>): LottoNumbers {
            return LottoNumbers(lottoNumbers.map { it }.toSet())
        }

        fun of(winningLottoNumbers: LottoNumbers, bonusNumber: LottoNumber): LottoNumbers {
            return LottoNumbers((winningLottoNumbers.lottoNumbers.map { it } + bonusNumber).toSet())
        }
    }
}
