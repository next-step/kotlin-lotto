package lotto.business

abstract class LottoNumberSet(val lottoNumbers: Set<LottoNumber>) {

    val sortedLottoNumbers
        get() = this.lottoNumbers.sortedBy { it.number }

    init {
        require(lottoNumbers.size == LOTTO_NUMBER_SIZE) {
            "서로 다른 ${LOTTO_NUMBER_SIZE}개 로또 번호 이여야 합니다."
        }
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
