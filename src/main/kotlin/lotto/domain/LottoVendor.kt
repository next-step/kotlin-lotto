package lotto.domain

import lotto.util.RandomUtil

object LottoVendor {
    private const val MINIMUM_NUMBER = 1
    private const val MAXIMUM_NUMBER = 45
    private const val SIZE = 6
    private val NUMBER_RANGE = MINIMUM_NUMBER..MAXIMUM_NUMBER

    fun generate(autoLottoCount: Int, manualLottos: ManualLottos): LottoTickets =
        LottoTickets(
            autoLottos(autoLottoCount)
        ).merge(
            manualLottos.lottos
        )

    private fun autoLottos(autoLottoCount: Int) =
        List(autoLottoCount) { LottoTicket(generateNumbers()) }

    private fun generateNumbers(): LottoNumbers =
        LottoNumbers(
            RandomUtil.getShuffledNumbers(NUMBER_RANGE, SIZE).map(LottoNumber::from).toSet()
        )
}
