package lotto.domain

class WinningLotto(private val winningLottoNumbers: List<LottoNumber>) {

    init {
        require(winningLottoNumbers.size == VALID_WINNING_LOTTO_NUMBER_COUNT) { "로또번호 개수가 ${VALID_WINNING_LOTTO_NUMBER_COUNT}개가 아닙니다." }
        require(hasNotDuplicatedLottoNumber(winningLottoNumbers)) { "중복된 로또번호가 있습니다." }
    }

    private fun hasNotDuplicatedLottoNumber(lottoNumbers: List<LottoNumber>): Boolean {
        return lottoNumbers.distinct().size == VALID_WINNING_LOTTO_NUMBER_COUNT
    }

    companion object {
        private const val VALID_WINNING_LOTTO_NUMBER_COUNT = 6
    }
}
