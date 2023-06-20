package lotto.util

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.io.InputView

object ManualLottoGenerator : LottoGenerator {
    private const val MANUAL_LOTTO_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요."

    override fun getLottos(count: Int): Lottos {
        println(MANUAL_LOTTO_INPUT_MESSAGE)
        return super.getLottos(count)
    }

    override fun getLotto(): Lotto {
        return Lotto(InputView.getManualLotto().map { LottoNumber(it) }.toSortedSet())
    }
}
