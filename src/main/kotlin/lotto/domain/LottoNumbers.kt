package lotto.domain

class LottoNumbers(lottoNumbers: List<LottoNumber>) {
    val lottoNumbers = lottoNumbers.toList().sortedBy { LottoNumber.toString() }

    init {
        require(lottoNumbers.size == LOTTO_NUMBER_SIZE) { LOTTO_NUMBER_SIZE_MESSAGE }
        require(lottoNumbers.toSet().size == LOTTO_NUMBER_SIZE) { LOTTO_DUPLICATE_MESSAGE }
    }

    fun getCountWithWinningLottoNumber(winningLottoNumbers: LottoNumbers): Int {
        return winningLottoNumbers.lottoNumbers
            .filter { winningLottoNumber -> lottoNumbers.contains(winningLottoNumber) }.size
    }

    fun hasBonusNumber(winningLottoBonusNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(winningLottoBonusNumber)
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private const val LOTTO_NUMBER_SIZE_MESSAGE = "로또 번호는 6개의 숫자로 생성되어야 합니다."
        private const val LOTTO_DUPLICATE_MESSAGE = "로또 번호내 중복된 숫자가 존재합니다."

        fun random(): LottoNumbers {
            val lottoNumbers = (LottoNumber.LOTTO_START_NUMBER..LottoNumber.LOTTO_END_NUMBER)
                .shuffled().take(6).sorted().map { num -> LottoNumber.from(num) }.toList()
            return LottoNumbers(lottoNumbers)
        }
    }
}
