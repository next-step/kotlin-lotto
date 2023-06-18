import Lotto.Companion.LOTTO_SIZE
import LottoNumber.Companion.MAX_LOTTO_NUMBER
import LottoNumber.Companion.MIN_LOTTO_NUMBER

interface LottoGenerator {
    fun generate(): Lotto
}

class RandomLottoGenerator : LottoGenerator {
    override fun generate(): Lotto = LOTTO_NUMBERS.shuffled().subList(0, LOTTO_SIZE).let { Lotto(it) }

    companion object {
        private val LOTTO_NUMBERS = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).map { LottoNumber(it) }
    }
}
