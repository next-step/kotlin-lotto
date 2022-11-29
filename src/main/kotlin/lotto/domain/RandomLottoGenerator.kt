package lotto.domain

import java.util.Random

class RandomLottoGenerator : LottoGenerator {

    override fun generate(): Lotto {
        val lottoBalls = mutableSetOf<LottoBall>()
        while (!Lotto.isLottoSize(lottoBalls.size)) {
            lottoBalls.add(RANDOM.lottoBall(LottoBall.LOTTOBALL_MIN, LottoBall.LOTTOBALL_MAX))
        }
        return Lotto(lottoBalls)
    }

    companion object {
        private val RANDOM = Random()
    }
}

private fun Random.lottoBall(min: Int, max: Int): LottoBall = LottoBall(this.nextInt(max - min) + min)
