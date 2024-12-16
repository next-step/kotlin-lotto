package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_TAKE_NUMBER
import lotto.domain.LottoNumber.Companion.MAX_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MIN_LOTTO_NUMBER
import lotto.entity.Lotto
import lotto.repository.LottoRepository

class LottoGame(private val lottoRepository: LottoRepository) {
    fun start(
        amount: Amount,
        lottoManualNumbers: List<LottoNumber>,
    ): Lotto {
        val autoLotto = mutableListOf<LottoNumber>()
        repeat(amount.lottoGameCount) {
            autoLotto.add(generateLottoNumbers())
        }
        lottoRepository.save(Lotto(lottoManualNumbers.toMutableList(), autoLotto))
        return lottoRepository.findAll()
    }

    private fun generateLottoNumbers(): LottoNumber {
        val lottoNumbers =
            (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
                .shuffled()
                .take(LOTTO_TAKE_NUMBER)
                .toSet()
        return LottoNumber(lottoNumbers)
    }
}
