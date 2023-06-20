package lotto.domain.shop

class RealLottoShop(
    private val lottoGameMachine: LottoGameMachine,
) : LottoShop {

    override fun purchase(lottoPurchasePaper: LottoPurchasePaper): LottoPurchaseResult {
        val purchaseSize = lottoPurchasePaper.lottoPurchaseAmount / LOTTO_PRICE
        val selfSettingLottoGames = createSelfSettingLottoGames(lottoPurchasePaper.selfSettingLottoGames)
        val autoSettingLottoGames = createAutoSettingLottoGames(purchaseSize - selfSettingLottoGames.size)
        return LottoPurchaseResult(
            lottoGames = selfSettingLottoGames.plus(autoSettingLottoGames),
        )
    }

    private fun createSelfSettingLottoGames(selfSettingLottoGames: List<SelfSettingLottoGame>): List<LottoGame> {
        return selfSettingLottoGames
            .map { selfSettingLottoGame -> selfSettingLottoGame.lottoNumbers }
            .map { lottoNumbers -> LottoGameMachineOption.Self(lottoNumbers) }
            .map { optionBySelfSetting -> lottoGameMachine.create(optionBySelfSetting) }
    }

    private fun createAutoSettingLottoGames(size: Int): List<LottoGame> {
        return List(size) {
            lottoGameMachine.create(LottoGameMachineOption.Auto)
        }
    }

    companion object {

        private const val LOTTO_PRICE = 1_000
    }
}
