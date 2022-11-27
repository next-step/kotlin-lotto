package lotto.domain

import java.util.*


class RandomLottoGenerator : LottoGenerator {

    override fun generate(): Lotto {
        val lottoBalls = List(Lotto.LOTTO_SIZE) { generateLottoBall() }
        return Lotto(lottoBalls)
    }

    private fun generateLottoBall() = LottoBall(RANDOM.nextInt(50))

    companion object {
        private val RANDOM = Random();
    }
}
