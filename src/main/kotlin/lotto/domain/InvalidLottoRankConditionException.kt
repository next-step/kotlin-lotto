package lotto.domain

class InvalidLottoRankConditionException(matchCount: Int, containsBonusNumber: Boolean) : RuntimeException(
    "matchCount=$matchCount, containsBonusNumber=$containsBonusNumber 에 해당하는 LottoRank가 없습니다.",
)
