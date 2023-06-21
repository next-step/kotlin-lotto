package lotto.domain.shop

data class LottoPurchaseResult(
    val lottoGames: List<LottoGame>,
) {
    val selfSettingCount = lottoGames.count { it.type == LottoGameType.SELF }
    val autoSettingCount = lottoGames.count { it.type == LottoGameType.AUTO }
}
