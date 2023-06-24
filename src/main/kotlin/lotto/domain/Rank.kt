package lotto.domain

enum class Rank(val countOfMatch: Int, val winningMoney: Long) {
    FIRST(LottoNumbers.LENGTH, 2_000_000_000),
    SECOND(LottoNumbers.LENGTH - 1, 30_000_000),
    THIRD(LottoNumbers.LENGTH - 1, 1_500_000),
    FOURTH(LottoNumbers.LENGTH - 2, 50_000),
    FIFTH(LottoNumbers.LENGTH - 3, 5_000);
}
