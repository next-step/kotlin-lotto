package lotto.domain.shop

import math.PositiveNumber

class RealLottoShop(
    private val lottoGameMachine: LottoGameMachine,
) : LottoShop {

    override fun purchase(lottoPurchasePaper: LottoPurchasePaper): LottoPurchaseResult {
        val selfSettingLottoGames = createSelfSettingLottoGames(lottoPurchasePaper.selfSettingLottoNumbersPapers)
        val autoSettingLottoGames = createAutoSettingLottoGames(lottoPurchasePaper.autoPurchaseSize(LOTTO_PRICE))
        return LottoPurchaseResult(
            lottoGames = selfSettingLottoGames.plus(autoSettingLottoGames),
        )
    }

    private fun createSelfSettingLottoGames(selfSettingLottoNumberPapers: List<SelfSettingLottoNumberPaper>): List<LottoGame> {
        return selfSettingLottoNumberPapers
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

        private val LOTTO_PRICE = PositiveNumber(1_000)
    }
}
