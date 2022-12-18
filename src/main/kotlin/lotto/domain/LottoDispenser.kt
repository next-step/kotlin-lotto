package lotto.domain

import lotto.Tokenizer
import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.Rank
import lotto.domain.model.WinningNumbers

class LottoDispenser(val amount: Int, manualLottoNumberTextList: List<String> = emptyList()) {

    lateinit var ranks: List<Rank>

    val autoLottoList: List<Lotto> = makeLottoList(manualLottoNumberTextList.size)
    val manualLottoList: List<Lotto> = makeManualLottoList(manualLottoNumberTextList)
    val lottoList: List<Lotto>
        get() = manualLottoList + autoLottoList

    init {
        require(amount >= MINIMUM_PRICE) { "구입 금액은 ${MINIMUM_PRICE}원 이하가 될 수 없습니다" }
    }

    fun match(winningNumbers: WinningNumbers) {
        ranks = lottoList.map { lotto ->
            Rank.win(winningNumbers, lotto)
        }
    }

    private fun makeLottoList(manualLottoCount: Int): List<Lotto> {
        val total = amount / MINIMUM_PRICE
        val autoLottoCount = total - manualLottoCount
        return List(autoLottoCount) { Lotto() }
    }

    private fun makeManualLottoList(manualLottoNumberText: List<String>): List<Lotto> {
        val manualLottoCount = manualLottoNumberText.size
        return List(manualLottoCount) { index ->
            val lottoNumbers = Tokenizer.tokenize(manualLottoNumberText[index])
                .map { numberText ->
                    LottoNumber(numberText.toInt())
                }
            Lotto(lottoNumbers)
        }
    }
}
