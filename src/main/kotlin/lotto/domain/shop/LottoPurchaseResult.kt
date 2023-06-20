package lotto.domain.shop

data class LottoPurchaseResult(
    val lottoGames: List<LottoGame>,
) {
    val selfSettingCount = lottoGames.count(LottoGameType.SELF)
    val autoSettingCount = lottoGames.count(LottoGameType.AUTO)
}
