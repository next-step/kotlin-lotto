package lotto.domain

class InvalidMatchCountException(matchCount: Int) : RuntimeException("matchCount=$matchCount 에 해당하는 LottoRank가 없습니다.")
