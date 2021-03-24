import LottoCard.Companion.LOTTO_LAST_NUMBER
import LottoCard.Companion.LOTTO_START_NUMBER

data class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_START_NUMBER..LOTTO_LAST_NUMBER)
    }
}
