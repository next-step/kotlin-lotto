package lotto.dto

import lotto.domain.PrizeLevel

class LottoMatchResponse(val matchLottoResult: Map<PrizeLevel, Int>) {}