package lotto.domain

class RandomLottoGenerator : LottoGenerator {

    override fun generate(): Lotto {
        val lottoBalls = LOTTO_BALL.shuffled()
            .take(Lotto.LOTTO_SIZE)
            .toSet()
        return Lotto(lottoBalls)
    }

    companion object {
        private val LOTTO_BALL = (LottoBall.LOTTOBALL_MIN..LottoBall.LOTTOBALL_MAX).map { LottoBall(it) }
    }
}

