package lotto.domain

import lotto.domain.LottoGenerator.Companion.MAX_LOTTO_NUMBER_COUNT

class RandomLottoGenerator : LottoGenerator {
    override fun generateLotto(lottoCount: Int): Lottos {
        val lottos = mutableListOf<Lotto>()
        repeat(lottoCount) {
            val lottoNumbers = LottoNumbers.LOTTO_NUMBERS.shuffled().take(MAX_LOTTO_NUMBER_COUNT)
            lottos.add(Lotto.fromLottoNumbers(lottoNumbers))
        }
        return Lottos(lottos)
    }
}
