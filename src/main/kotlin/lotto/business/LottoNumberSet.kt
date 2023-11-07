package lotto.business

interface LottoNumberSet {

    val lottoNumbers: Set<LottoNumber>

    fun validateNumbers() {
        require(lottoNumbers.size == LOTTO_NUMBER_SIZE) {
            "서로 다른 ${LOTTO_NUMBER_SIZE}개 로또 번호 이여야 합니다."
        }
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}

fun LottoNumberSet.sortedLottoNumbers(): List<LottoNumber> =
    this.lottoNumbers.sortedBy { it.number }
