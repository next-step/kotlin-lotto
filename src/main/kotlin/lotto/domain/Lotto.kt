package lotto.domain

class Lotto(val lotto: List<LottoNumber>) {

    init {
        require(lotto.size == lotto.distinct().size) {
            "중복된 숫자는 올 수 없음"
        }
        require(lotto.size == LOTTO_NUMBER_COUNT) {
            "로또 숫자는 6개이어야함"
        }
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
