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
        require(lottoManualNumbers.size == amount.manualCount) {
            "수동으로 입력한 로또 번호의 개수가 수동 구매 개수와 일치하지 않습니다. " +
                    "필요한 개수: ${amount.manualCount}, 입력된 개수: ${lottoManualNumbers.size}"
        }

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

    fun getLottoGameResult(lottoGameResult: Lotto, winnerNumbers: WinningLottoNumber): LottoGameResult {
        return LottoGameResult(lottoGameResult, winnerNumbers)
    }
}
