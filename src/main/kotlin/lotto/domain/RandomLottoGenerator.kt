package lotto.domain

import java.util.*


class RandomLottoGenerator : LottoGenerator {

    override fun generate(): Lotto {
        val lottoBalls = List(Lotto.LOTTO_SIZE) { generateLottoBall() }
        return Lotto(lottoBalls)
    }

    private fun generateLottoBall() :LottoBall{
        val number = RANDOM.nextInt(49)
        if(number == 0){
            return LottoBall(1)
        }
        return LottoBall(number)
    }

    companion object {
        private val RANDOM = Random();
    }
}
